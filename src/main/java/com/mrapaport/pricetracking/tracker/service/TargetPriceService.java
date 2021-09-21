package com.mrapaport.pricetracking.tracker.service;

import com.mrapaport.pricetracking.tracker.model.TargetPrice;
import com.mrapaport.pricetracking.tracker.model.TrackingTarget;
import com.mrapaport.pricetracking.tracker.model.exchange.TargetPriceCreateRequest;
import com.mrapaport.pricetracking.tracker.model.exchange.TargetPriceCreateResponse;
import com.mrapaport.pricetracking.tracker.repository.TargetPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TargetPriceService {

    @Autowired
    private TargetPriceRepository repository;

    Logger logger = LoggerFactory.getLogger(TargetPriceService.class);

    public void updatePrice(TrackingTarget savedTarget, BigDecimal price) {
        TargetPrice targetPrice = new TargetPrice(savedTarget, price, LocalDateTime.now());
        this.save(targetPrice);
    }

    private TargetPriceCreateResponse save(TargetPrice targetPrice) {
        TargetPrice savedPrice = repository.save(targetPrice);
        return TargetPriceCreateResponse.from(savedPrice);
    }
}
