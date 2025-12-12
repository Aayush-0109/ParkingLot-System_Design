package com.aayush.service;

import com.aayush.dto.Bill;
import com.aayush.model.Ticket;
import com.aayush.strategy.billing.BillingStrategy;

import java.time.LocalDateTime;

public class BillingService {
    private BillingStrategy strategy;

    public void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    public Bill generateBill(Ticket ticket, LocalDateTime exitTime) {
        double amount = getBillAmount(ticket, exitTime);
        return new Bill(ticket.getTicketId(), ticket.getEntryTime(), exitTime, amount);
    }

    private double getBillAmount(Ticket ticket, LocalDateTime exitTime) {
        if (strategy == null) throw new IllegalStateException("Billing strategy not set");
        return strategy.calculatePrice(ticket, exitTime);
    }
}
