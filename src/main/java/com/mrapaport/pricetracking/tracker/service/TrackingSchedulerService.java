package com.mrapaport.pricetracking.tracker.service;

import com.mrapaport.pricetracking.tracker.model.TrackingTarget;
import com.mrapaport.pricetracking.tracker.model.exchange.TrackingSchedulerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class TrackingSchedulerService {

    public static final int INITIAL_DELAY = 5000;
    public static final int DELAY_PERIOD = 600000;

    List<TrackingTarget> targets;

    @Autowired
    TrackingTargetService trackingTargetService;

    @Autowired
    CurrentPricingService currentPricingService;

    Logger logger = LoggerFactory.getLogger(TrackingSchedulerService.class);

    @PostConstruct
    private void setupTracking() {
        this.targets = trackingTargetService.getActiveTargets();
        this.scheduleTracking();
    }

    private void scheduleTracking() {
        TimerTask scheduledTask = new TimerTask() {
            @Override
            public void run() {
                targets.parallelStream().forEach(TrackingSchedulerService.this::checkCurrentPrice);
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(scheduledTask, INITIAL_DELAY, DELAY_PERIOD);
    }

    public TrackingSchedulerResponse track(TrackingTarget savedTarget) {
        checkCurrentPrice(savedTarget);
        this.targets.add(savedTarget);
        return new TrackingSchedulerResponse();
    }

    private void checkCurrentPrice(TrackingTarget savedTarget) {
        try {
            currentPricingService.checkCurrentPrice(savedTarget);
        } catch (IOException e) {
            logger.error("Couldn't get price for target {}", savedTarget.getLink());
        }
    }

}
