package com.aayush.service;

import com.aayush.model.SpotType;
import com.aayush.strategy.allocation.AllocationStrategy;

import java.util.Map;
import java.util.Set;

public class SpotFinder {
    private AllocationStrategy strategy;

    public void setStrategy(AllocationStrategy strategy) {
        this.strategy = strategy;
    }

    public String findSpot(Set<SpotType> allowedSpotTypes,
                           Map<SpotType, Set<String>> availableSpots) {
        if (strategy == null) throw new IllegalStateException("Strategy not set");
        return strategy.findSpot(allowedSpotTypes, availableSpots);
    }


}
