package com.aayush.strategy.payment;

import com.aayush.dto.Bill;
import com.aayush.dto.PaymentReceipt;
import com.aayush.model.PaymentMethod;
import com.aayush.model.PaymentStatus;

public class CashPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentReceipt pay(Bill bill) {
        return new PaymentReceipt(
                bill.getBillId(),
                bill.getAmount(),
                PaymentMethod.CASH,
                PaymentStatus.SUCCESS
        );
    }
}

