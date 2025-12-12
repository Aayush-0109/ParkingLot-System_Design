package com.aayush.strategy.allocation;

import com.aayush.model.SpotType;

import java.util.Map;
import java.util.Set;

public class LargestSpotStrategy implements AllocationStrategy {
    @Override
    public String findSpot(Set<SpotType> allowedSpotTypes,
                           Map<SpotType, Set<String>> availableSpots) {
        String allocatedSpot = null;
        int maxPriorityFound = -1;
        for (SpotType spotType : allowedSpotTypes) {
            int priority = spotType.getPriority();
            if (priority > maxPriorityFound
                    && availableSpots.containsKey(spotType)
                    && !availableSpots.get(spotType).isEmpty()) {
                allocatedSpot = availableSpots.get(spotType).iterator().next();
                maxPriorityFound = priority;
            }
        }
        return allocatedSpot;
    }
}
