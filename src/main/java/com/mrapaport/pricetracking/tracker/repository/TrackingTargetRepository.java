package com.mrapaport.pricetracking.tracker.repository;

import com.mrapaport.pricetracking.tracker.model.TrackingTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingTargetRepository extends JpaRepository<TrackingTarget, Long> {

    @Query(value = "select t from TrackingTarget t where t.removedAt is null")
    List<TrackingTarget> findAllActiveTargets();

}
