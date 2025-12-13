package com.aayush.strategy.payment;

import com.aayush.dto.Bill;
import com.aayush.dto.PaymentReceipt;
import com.aayush.model.PaymentMethod;
import com.aayush.model.PaymentStatus;

import java.util.Random;

public class UPIPaymentStrategy implements PaymentStrategy {

    private final Random random = new Random();

    @Override
    public PaymentReceipt pay(Bill bill) {
        boolean success = random.nextBoolean(); // simulate gateway response

        return new PaymentReceipt(
                bill.getBillId(),
                bill.getAmount(),
                PaymentMethod.UPI,
                success ? PaymentStatus.SUCCESS : PaymentStatus.FAILED
        );
    }
}
