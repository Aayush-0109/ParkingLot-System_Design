package com.aayush.strategy.billing;

import com.aayush.dto.SpotRateTable;
import com.aayush.dto.VehicleRateTable;
import com.aayush.model.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class BillingStrategy {

    protected final double MINIMUM_ALLOWED;
    protected final VehicleRateTable vehicleRateTable;
    protected final SpotRateTable spotRateTable;

    protected BillingStrategy(VehicleRateTable vTable, SpotRateTable sTable, double MINIMUM_ALLOWED) {
        this.vehicleRateTable = vTable;
        this.spotRateTable = sTable;
        this.MINIMUM_ALLOWED = MINIMUM_ALLOWED;
    }

    public abstract double calculatePrice(Ticket ticket, LocalDateTime exitTime);

    protected double calculateDurationHours(LocalDateTime entry, LocalDateTime exit) {
        long minutes = Duration.between(entry, exit).toMinutes();
        return minutes / 60.0;
    }
}

