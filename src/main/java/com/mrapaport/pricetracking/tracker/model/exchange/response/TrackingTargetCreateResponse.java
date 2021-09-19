package com.mrapaport.pricetracking.tracker.model.exchange.response;

import com.mrapaport.pricetracking.tracker.model.TrackingTarget;
import com.mrapaport.pricetracking.tracker.model.exchange.TrackingSchedulerResponse;
import lombok.Data;

@Data
public class TrackingTargetCreateResponse extends PriceTrackingResponse {

    private TrackingTarget trackingTarget;

    public TrackingTargetCreateResponse(PriceTrackingResponseStatus ok, TrackingTarget target) {
        super(ok);
        this.trackingTarget = target;
    }

    public static TrackingTargetCreateResponse from(TrackingTarget savedTarget, TrackingSchedulerResponse trackingResponse) {
        return new TrackingTargetCreateResponse(PriceTrackingResponseStatus.OK, savedTarget);
    }
}
