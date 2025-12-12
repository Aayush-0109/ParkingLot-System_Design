package com.aayush.model;

import java.util.Set;

public class Truck extends Vehicle {
    public Truck(String licencePlate) {
        super(licencePlate, Set.of(SpotType.LARGE), VehicleType.TRUCK);

    }
}
