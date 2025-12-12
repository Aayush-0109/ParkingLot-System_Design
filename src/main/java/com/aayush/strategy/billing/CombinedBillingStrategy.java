package com.aayush.strategy.billing;

import com.aayush.dto.SpotRateTable;
import com.aayush.dto.VehicleRateTable;
import com.aayush.model.Ticket;

import java.time.LocalDateTime;

public class CombinedBillingStrategy extends BillingStrategy {
    public CombinedBillingStrategy(VehicleRateTable vrt, SpotRateTable srt, double MINIMUM_ALLOWED) {
        super(vrt, srt, MINIMUM_ALLOWED);
    }

    @Override
    public double calculatePrice(Ticket ticket, LocalDateTime exitTime) {
        double durationHours = this.calculateDurationHours(ticket.getEntryTime(), exitTime);
        double vehicleBaseRate = vehicleRateTable.getRate(ticket.getVehicleType());
        double spotMultiplier = spotRateTable.getMultiplier(ticket.getSpotType());
        double cost = durationHours * spotMultiplier * vehicleBaseRate;
        return Math.max(cost, MINIMUM_ALLOWED);
    }
}
