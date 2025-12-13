package com.aayush.service;

import com.aayush.dto.Bill;
import com.aayush.dto.PaymentReceipt;
import com.aayush.strategy.payment.PaymentStrategy;

public class PaymentService {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public PaymentReceipt payBill(Bill bill) {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        return this.strategy.pay(bill);
    }
}
