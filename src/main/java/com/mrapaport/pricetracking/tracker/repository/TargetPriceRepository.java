package com.mrapaport.pricetracking.tracker.repository;

import com.mrapaport.pricetracking.tracker.model.TargetPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetPriceRepository extends JpaRepository<TargetPrice, Long> {
}
