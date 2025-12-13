package com.aayush.strategy.payment;

import com.aayush.dto.Bill;
import com.aayush.dto.PaymentReceipt;

public interface PaymentStrategy {
    PaymentReceipt pay(Bill bill);
}
