package com.mrapaport.pricetracking.tracker.service;

import com.mrapaport.pricetracking.tracker.model.TargetPrice;
import com.mrapaport.pricetracking.tracker.model.exchange.TargetPriceCreateRequest;
import com.mrapaport.pricetracking.tracker.model.exchange.TargetPriceCreateResponse;
import com.mrapaport.pricetracking.tracker.repository.TargetPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TargetPriceService {

    @Autowired
    private TargetPriceRepository repository;

    Logger logger = LoggerFactory.getLogger(TargetPriceService.class);

    public TargetPriceCreateResponse save(TargetPriceCreateRequest request) {
        TargetPrice newPrice = new TargetPrice();
        newPrice.setTrackingTarget(request.getTarget());
        newPrice.setPrice(request.getPrice());
        newPrice.setFetchedAt(LocalDateTime.now());
        TargetPrice savedPrice = repository.save(newPrice);
        return TargetPriceCreateResponse.from(savedPrice);
    }

}
