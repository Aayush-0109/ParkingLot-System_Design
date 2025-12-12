package com.aayush.factory;

import com.aayush.model.Bike;
import com.aayush.model.Vehicle;

public class BikeFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String licencePlate) {
        return new Bike(licencePlate);
    }
}
