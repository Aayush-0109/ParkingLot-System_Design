package com.aayush.factory;

import com.aayush.model.Floor;
import com.aayush.model.SpotType;
import com.aayush.model.Ticket;
import com.aayush.model.VehicleType;

public class TicketFactory {
    public static Ticket createTicket(String licencePlate, VehicleType vehicleType, Floor floor, String spotId, SpotType spotType) {
        return new Ticket(licencePlate, vehicleType, floor, spotId, spotType);
    }
}
