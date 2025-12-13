package com.aayush.dto;

import com.aayush.model.PaymentMethod;
import com.aayush.model.PaymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentReceipt {
    private final UUID paymentId;
    private final UUID billId;
    private final double amount;
    private final PaymentMethod paymentMethod;
    private final PaymentStatus paymentStatus;
    private final LocalDateTime timeStamp;

    public PaymentReceipt(UUID billId, double amount,
                          PaymentMethod paymentMethod, PaymentStatus paymentStatus
            ) {
        paymentId = UUID.randomUUID();
        this.billId = billId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.timeStamp = LocalDateTime.now();
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public UUID getBillId() {
        return billId;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
