package com.aayush.dto;

import com.aayush.model.VehicleType;

import java.util.Map;

public class VehicleRateTable {
    private final Map<VehicleType, Double> baseRates;

    public VehicleRateTable(Map<VehicleType, Double> baseRates) {
        this.baseRates = baseRates;
    }

    public double getRate(VehicleType type) {
        return baseRates.get(type);
    }
}