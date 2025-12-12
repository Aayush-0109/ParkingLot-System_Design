package com.aayush.model;

import java.util.HashSet;
import java.util.Set;

public class Car extends Vehicle{
    public Car(String licencePlate){
        super(licencePlate , Set.of(SpotType.MEDIUM ,SpotType.LARGE ),"Car");
    }

}
