package com.mrapaport.pricetracking.tracker.model.exchange;

import com.mrapaport.pricetracking.tracker.model.TrackingTarget;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TargetPriceCreateRequest {

    TrackingTarget target;

    BigDecimal price;

}
