package com.mrapaport.pricetracking.tracker.controller;

import com.mrapaport.pricetracking.tracker.controller.dto.TrackingTargetCreationRequestDto;
import com.mrapaport.pricetracking.tracker.controller.dto.TrackingTargetCreationResponseDto;
import com.mrapaport.pricetracking.tracker.model.exchange.response.TrackingTargetCreateResponse;
import com.mrapaport.pricetracking.tracker.service.TrackingTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/target")
public class TrackingTargetController {

    @Autowired
    TrackingTargetService service;

    @PostMapping
    public TrackingTargetCreationResponseDto createTrackingTarget(@RequestBody TrackingTargetCreationRequestDto request) {
        TrackingTargetCreateResponse serviceResponse = service.save(request.toServiceRequest());
        return TrackingTargetCreationResponseDto.from(serviceResponse);
    }

}