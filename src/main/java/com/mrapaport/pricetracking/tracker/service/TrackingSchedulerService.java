package com.mrapaport.pricetracking.tracker.service;

import com.mrapaport.pricetracking.tracker.model.TrackingTarget;
import com.mrapaport.pricetracking.tracker.model.exchange.TrackingSchedulerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class TrackingSchedulerService {

    public static final int INITIAL_DELAY = 5000;
    public static final int DELAY_PERIOD = 60000;

    List<TrackingTarget> targets;

    @Autowired
    TrackingTargetService trackingTargetService;

    @Autowired
    CurrentPricingService currentPricingService;

    @PostConstruct
    private void setupTracking() {
        this.targets = trackingTargetService.getActiveTargets();
        this.scheduleTracking();
    }

    private void scheduleTracking() {
        TimerTask scheduledTask = new TimerTask() {
            @Override
            public void run() {
                targets.parallelStream().forEach(currentPricingService::checkCurrentPrice);
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(scheduledTask, INITIAL_DELAY, DELAY_PERIOD);
    }

    public TrackingSchedulerResponse track(TrackingTarget savedTarget) {
        currentPricingService.checkCurrentPrice(savedTarget);
        this.targets.add(savedTarget);
        return new TrackingSchedulerResponse();
    }

}
