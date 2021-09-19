package com.mrapaport.pricetracking.tracker.service;

import com.mrapaport.pricetracking.tracker.model.TrackingTarget;
import com.mrapaport.pricetracking.tracker.model.exchange.TrackingSchedulerResponse;
import com.mrapaport.pricetracking.tracker.model.exchange.request.TrackingTargetCreateRequest;
import com.mrapaport.pricetracking.tracker.model.exchange.response.TrackingTargetCreateResponse;
import com.mrapaport.pricetracking.tracker.repository.TrackingTargetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrackingTargetService {

    @Autowired
    TrackingTargetRepository repository;

    @Autowired
    TrackingSchedulerService trackingService;

    Logger logger = LoggerFactory.getLogger(TrackingTargetService.class);

    public TrackingTargetCreateResponse save(TrackingTargetCreateRequest request) {

        TrackingTarget trackingTarget = new TrackingTarget();
        trackingTarget.setLink(request.getLink());
        trackingTarget.setAddedAt(LocalDateTime.now());
        TrackingTarget savedTarget = repository.save(trackingTarget);

        TrackingSchedulerResponse trackingResponse = trackingService.track(savedTarget);

        return TrackingTargetCreateResponse.from(savedTarget, trackingResponse);
    }

    public List<TrackingTarget> getActiveTargets() {
        return repository.findAllActiveTargets();
    }
}
