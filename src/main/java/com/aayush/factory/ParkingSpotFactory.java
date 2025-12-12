package com.aayush.factory;

import com.aayush.model.ParkingSpot;
import com.aayush.model.SpotType;

public class ParkingSpotFactory {
   public static ParkingSpot createSpot(String spotId  , SpotType type){
        return new ParkingSpot(spotId, type);
    }
}
