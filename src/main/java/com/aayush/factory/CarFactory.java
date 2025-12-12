package com.aayush.factory;

import com.aayush.model.Car;
import com.aayush.model.Vehicle;

public class CarFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String licencePlate) {
        return new Car(licencePlate);
    }
}
