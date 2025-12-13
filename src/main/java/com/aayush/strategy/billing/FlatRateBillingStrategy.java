package com.aayush.strategy.billing;

import com.aayush.dto.SpotRateTable;
import com.aayush.dto.VehicleRateTable;
import com.aayush.model.Ticket;

import java.time.LocalDateTime;

public class FlatRateBillingStrategy extends BillingStrategy {
    public FlatRateBillingStrategy(VehicleRateTable vrt, SpotRateTable srt , double MINIMUN_ALLOWED) {
        super(vrt, srt,MINIMUN_ALLOWED);
    }

    @Override
    public double calculatePrice(Ticket ticket, LocalDateTime exitTime) {
        double durationHours = this.calculateDurationHours(ticket.getEntryTime(), exitTime);
        double cost = 10 * durationHours;
        cost = Math.max(cost, MINIMUM_ALLOWED);
        return  cost;
    }
}
