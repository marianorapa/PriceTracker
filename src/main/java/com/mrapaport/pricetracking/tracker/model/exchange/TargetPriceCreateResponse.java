package com.mrapaport.pricetracking.tracker.model.exchange;

import com.mrapaport.pricetracking.tracker.model.TargetPrice;
import com.mrapaport.pricetracking.tracker.model.TrackingTarget;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TargetPriceCreateResponse {

    TrackingTarget target;

    BigDecimal price;

    public static TargetPriceCreateResponse from(TargetPrice savedPrice) {
        TargetPriceCreateResponse response = new TargetPriceCreateResponse();
        response.setTarget(savedPrice.getTrackingTarget());
        response.setPrice(savedPrice.getPrice());
        return response;
    }
}
