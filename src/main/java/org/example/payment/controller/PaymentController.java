package org.example.payment.controller;

import org.example.payment.factory.PaymentFactory;
import org.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentFactory paymentFactory;

    @GetMapping("/pay")
    public String pay(@RequestParam String type, @RequestParam double amount) {
        PaymentService paymentService = paymentFactory.createPaymentService(type);
        paymentService.processPayment(amount);
        return "Payment processed using "+type + "!";
    }
}
