package com.aayush.dto;

import com.aayush.model.SpotType;

import java.util.Map;

public class SpotRateTable {
    private final Map<SpotType, Double> multipliers;

    public SpotRateTable(Map<SpotType, Double> multipliers) {
        this.multipliers = multipliers;
    }

    public double getMultiplier(SpotType type) {
        return multipliers.get(type);
    }
}


