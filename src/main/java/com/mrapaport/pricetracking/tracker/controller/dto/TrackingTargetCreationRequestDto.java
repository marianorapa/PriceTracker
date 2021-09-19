package com.mrapaport.pricetracking.tracker.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mrapaport.pricetracking.tracker.model.exchange.request.TrackingTargetCreateRequest;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TrackingTargetCreationRequestDto {

    @JsonProperty(value = "link", required = true)
    private String link;

    public TrackingTargetCreateRequest toServiceRequest() {
        return new TrackingTargetCreateRequest(link);
    }
}
