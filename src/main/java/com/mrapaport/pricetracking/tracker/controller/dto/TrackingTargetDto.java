package com.mrapaport.pricetracking.tracker.controller.dto;

import com.mrapaport.pricetracking.tracker.model.TrackingTarget;
import lombok.Data;

@Data
public class TrackingTargetDto {

    private String link;

    public TrackingTargetDto(TrackingTarget trackingTarget) {
        this.link = trackingTarget.getLink();
    }
}
