package com.mrapaport.pricetracking.tracker.model.exchange.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PriceTrackingResponse {

    private PriceTrackingResponseStatus status;

    private String errors;

    public PriceTrackingResponse(PriceTrackingResponseStatus status) {
        this.status = status;
    }

    public enum PriceTrackingResponseStatus {
        OK, CLIENT_ERROR, SERVER_ERROR
    }
}
