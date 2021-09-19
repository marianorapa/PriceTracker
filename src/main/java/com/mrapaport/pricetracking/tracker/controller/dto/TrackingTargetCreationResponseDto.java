package com.mrapaport.pricetracking.tracker.controller.dto;

import com.mrapaport.pricetracking.tracker.model.TrackingTarget;
import com.mrapaport.pricetracking.tracker.model.exchange.response.PriceTrackingResponse;
import com.mrapaport.pricetracking.tracker.model.exchange.response.TrackingTargetCreateResponse;
import lombok.Data;

@Data
public class TrackingTargetCreationResponseDto {

    private Object status;

    private TrackingTargetDto target;

    public TrackingTargetCreationResponseDto(PriceTrackingResponse.PriceTrackingResponseStatus status, TrackingTarget trackingTarget) {
        this.status = status;
        this.target = new TrackingTargetDto(trackingTarget);
    }

    public static TrackingTargetCreationResponseDto from(TrackingTargetCreateResponse serviceResponse) {
        return new TrackingTargetCreationResponseDto(serviceResponse.getStatus(), serviceResponse.getTrackingTarget());
    }
}
