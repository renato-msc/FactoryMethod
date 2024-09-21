package org.example.payment.factory;

import org.example.payment.service.PaymentService;
import org.example.payment.service.impl.CreditCardPaymentService;
import org.example.payment.service.impl.PayPalPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {
    @Autowired
    private CreditCardPaymentService creditCardPaymentService;

    @Autowired
    private PayPalPaymentService payPalPaymentService;

    public PaymentService createPaymentService(String type) {
        if ("CREDIT_CARD".equalsIgnoreCase(type)) {
            return creditCardPaymentService;
        } else if ("PAYPAL".equalsIgnoreCase(type)) {
            return payPalPaymentService;
        }
        throw new IllegalArgumentException("Unknown payment service type");
    }
}
