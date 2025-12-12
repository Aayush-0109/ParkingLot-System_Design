package com.aayush.model;

public class ParkingSpot {
    private final String spotId;
    private final SpotType spotType;

    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotType = spotType;
        this.spotId = spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public String getSpotId() {
        return spotId;
    }
}
