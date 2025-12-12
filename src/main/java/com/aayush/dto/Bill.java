package com.aayush.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class Bill {
    private final UUID billId;
    private final UUID ticketId;
    private final LocalDateTime entryTime;
    private final LocalDateTime exitTime;
    private final double amount;

    public Bill(UUID ticketId, LocalDateTime entryTime, LocalDateTime exitTime, double amount) {
        billId = UUID.randomUUID();
        this.amount = amount;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.ticketId = ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public UUID getBillId() {
        return billId;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public double getAmount() {
        return amount;
    }

}
