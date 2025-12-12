package com.aayush.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final UUID ticketId;
    private final String licencePlate;
    private final String spotId;
    private final LocalDateTime entryTime;
    public Ticket(String licencePlate , String spotId){
        ticketId = UUID.randomUUID();
        entryTime = LocalDateTime.now();
        this.licencePlate = licencePlate;
        this.spotId =spotId;
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
}
