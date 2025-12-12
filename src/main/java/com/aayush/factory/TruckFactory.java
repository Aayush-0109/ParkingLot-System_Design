package com.aayush.factory;

import com.aayush.model.Truck;
import com.aayush.model.Vehicle;

public class TruckFactory implements  VehicleFactory{
    @Override
    public Vehicle createVehicle(String licencePlate) {
        return new Truck(licencePlate);
    }
}
