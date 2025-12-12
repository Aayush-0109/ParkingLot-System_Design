package com.aayush.model;

import java.util.Set;

abstract public class Vehicle {
    private final String licencePlate;
    private final  Set<SpotType> allowedSpotTypes;
    private final VehicleType vehicleType;

    public Vehicle(String licencePlate , Set<SpotType> allowedSpotTypes,VehicleType vehicleType) {
        this.licencePlate = licencePlate;
        this.allowedSpotTypes = allowedSpotTypes;
        this.vehicleType =vehicleType;
    }

    public Set<SpotType> getAllowedSpotType() {
        return allowedSpotTypes;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
