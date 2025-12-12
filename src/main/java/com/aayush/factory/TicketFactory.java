package com.aayush.factory;

import com.aayush.model.Ticket;

public class TicketFactory {
    public static Ticket createTicket(String licencePlate , String spotId){
        return new Ticket(licencePlate,spotId);
    }
}
