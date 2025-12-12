package com.aayush.model;
import java.util.Set;
import java.util.HashSet;

public class Bike extends Vehicle{
    public Bike(String licencePlate){
        super(licencePlate , Set.of(SpotType.SMALL,SpotType.MEDIUM ,SpotType.LARGE ),VehicleType.BIKE);
    }
}
