package com.aayush.factory;

import com.aayush.model.Floor;

public class FloorFactory {
    public static Floor createFloor(String floorId){
        return new Floor(floorId);
    }
}
