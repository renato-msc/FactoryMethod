package org.example.payment.service.impl;

import org.example.payment.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class CreditCardPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of: $" + amount);
    }
}
