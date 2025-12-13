package com.aayush.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final UUID ticketId;
    private final String licencePlate;
    private final Floor floor;
    private final String spotId;
    private final LocalDateTime entryTime;
    private final VehicleType vehicleType;
    private final SpotType spotType;
    public Ticket(String licencePlate,VehicleType vehicleType , Floor floor,String spotId ,SpotType spotType ){
        ticketId = UUID.randomUUID();
        entryTime = LocalDateTime.now();
        this.licencePlate = licencePlate;
        this.spotId =spotId;
        this.vehicleType =vehicleType;
        this.spotType = spotType;
        this.floor =floor;
    }

    public Floor getFloor() {
        return floor;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public String getSpotId() {
        return spotId;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
