package com.aayush.strategy.allocation;

import com.aayush.model.SpotType;


import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public interface AllocationStrategy {
    public String findSpot(Set<SpotType> allowedSpotTypes , Map<SpotType, Set<String>> availableSpots);
}
