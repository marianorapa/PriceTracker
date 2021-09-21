package com.mrapaport.pricetracking.tracker.service;

import com.mrapaport.pricetracking.tracker.model.TrackingTarget;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class CurrentPricingService {

    Logger logger = LoggerFactory.getLogger(CurrentPricingService.class);

    @Autowired
    TargetPriceService targetPriceService;

    public void checkCurrentPrice(TrackingTarget savedTarget) throws IOException {
        BigDecimal price = getTargetPrice(savedTarget);
        logger.info("Response for {}: {}", savedTarget.getLink(), price);
        targetPriceService.updatePrice(savedTarget, price);
    }

    private BigDecimal getTargetPrice(TrackingTarget savedTarget) throws IOException {
        Document document = Jsoup.connect(savedTarget.getLink()).get();
        Elements possiblePrice = document.getElementsByAttributeValue("itemprop", "price");
        String price = possiblePrice.attr("content");
        return new BigDecimal(price);
    }
}
