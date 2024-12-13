package com.example.paymentservice.Services;

import com.example.paymentservice.models.Order;

public interface PaymentGateway {
    public String GeneratePaymentLink(Order order);
}
