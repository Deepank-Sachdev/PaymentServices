package com.example.paymentservice.Services;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGatewaySelector paymentGatewaySelector;
    public PaymentService(PaymentGatewaySelector paymentGatewaySelector) {
        this.paymentGatewaySelector = paymentGatewaySelector;
    }
    public String generatePaymentLink() {
        return paymentGatewaySelector.getPaymentGateway().GeneratePaymentLink();
    }
}
