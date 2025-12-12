package com.aayush.factory;

import com.aayush.model.Vehicle;

public interface VehicleFactory {
    Vehicle createVehicle(String licencePlate);
    }
