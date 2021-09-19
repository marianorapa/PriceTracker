package com.mrapaport.pricetracking.tracker.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "target_price")
@Data
public class TargetPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tracking_target_id", referencedColumnName = "id", nullable = false)
    private TrackingTarget trackingTarget;

    @Column(name = "fetched_at", nullable = false)
    private LocalDateTime fetchedAt;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
}