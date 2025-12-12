package com.aayush.strategy.allocation;

import com.aayush.model.SpotType;

import java.util.Map;
import java.util.Set;

public class NearestSpotStrategy implements AllocationStrategy {
    @Override
    public String findSpot(Set<SpotType> allowedSpotTypes,
                           Map<SpotType, Set<String>> availableSpots) {
        String allotedSlot = null;
        for (SpotType spotType : allowedSpotTypes) {
            if (availableSpots.containsKey(spotType)
                    && !availableSpots.get(spotType).isEmpty()) {
                allotedSlot = availableSpots.get(spotType).iterator().next();
                break;
            }
        }
        return allotedSlot;
    }
}
