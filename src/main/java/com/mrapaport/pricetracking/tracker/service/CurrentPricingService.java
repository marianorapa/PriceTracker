package com.mrapaport.pricetracking.tracker.service;

import com.mrapaport.pricetracking.tracker.model.TrackingTarget;
import org.springframework.stereotype.Service;

@Service
public class CurrentPricingService {


    public void checkCurrentPrice(TrackingTarget savedTarget) {

        System.out.println("Checking current price for target " + savedTarget.getLink());
    }
}
