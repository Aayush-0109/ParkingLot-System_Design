package com.aayush.dto;

import com.aayush.model.Ticket;

public class ExitResponse {
    private final Ticket ticket;
    private final Bill bill;
    private final PaymentReceipt paymentReceipt;

    public ExitResponse(Ticket ticket, Bill bill, PaymentReceipt paymentReceipt) {
        this.paymentReceipt = paymentReceipt;
        this.bill = bill;
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Bill getBill() {
        return bill;
    }

    public PaymentReceipt getPaymentReceipt() {
        return paymentReceipt;
    }
}
