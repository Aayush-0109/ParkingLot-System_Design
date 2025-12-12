package com.aayush.model;

import com.aayush.factory.ParkingSpotFactory;

import java.util.*;

public class Floor {
    private  int count =0;
    private final String floorId;
    private final Map<String, ParkingSpot> spotById;
    private final Map<SpotType, LinkedHashSet<String>> availableSpots;
    private final Set<String> occupiedSpots;

  public  Floor(String floorId) {
        spotById = new HashMap<>();
        availableSpots = new HashMap<>();
        occupiedSpots = new HashSet<>();
        this.floorId = floorId;
    }

    public void addSpot(SpotType type) {

//            if( type == null) throw exception
            String spotId = floorId +"-"+ String.valueOf(++count);
            if (!availableSpots.containsKey(type)) {
                availableSpots.put(type, new LinkedHashSet<>());
            }
            if (!spotById.containsKey(spotId)) {
                ParkingSpot spot = ParkingSpotFactory.createSpot(spotId,type);
                spotById.put(spot.getSpotId(), spot);
                availableSpots.get(type).addLast(spotId);
            }


    }

    public void markOccupied(String spotId) {
        try {

//            if(spotId==null) throw exception
//            if(!spotById.containsKey(spotId)) throw exception
            ParkingSpot toOccupy = spotById.get(spotId);
            synchronized (this) {
                if (!occupiedSpots.contains(spotId)) {
                    availableSpots.get(toOccupy.getSpotType()).remove(spotId);
                    occupiedSpots.add(spotId);
                } else {
                    System.out.println("Spot not available");
                }
            }
        } catch (RuntimeException e) {
            // handle exception
//            throw new RuntimeException(e);
        }

    }

    public void markAvailable(String spotId) {
        try {
//            if(spotId== null) throw exception
//            if(!spotById.contains(spotId)) throw exception
            ParkingSpot toFree = spotById.get(spotId);
            synchronized (this) {
                if (occupiedSpots.contains(spotId)) {
                    occupiedSpots.remove(spotId);
                    availableSpots.get(toFree.getSpotType()).addLast(spotId);
                } else {
                    // throw custom exception
                    System.out.println("Spot not occupied");
                }
            }

        } catch (RuntimeException e) {
            // manage exception
//            throw new RuntimeException(e);
        }

    }

    public String getFloorId() {
        return this.floorId;
    }

    public Map<SpotType, LinkedHashSet<String>> getAvailableSpots() {
        return availableSpots;
    }

    public ParkingSpot getSpotById(String spotId) {
        if (spotById.containsKey(spotId)) {
            return spotById.get(spotId);
        }
        return null; // throw exception instead of returning null but we still have to make out exceptions so we will do it later
    }
}
