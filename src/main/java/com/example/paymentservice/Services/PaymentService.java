package com.example.paymentservice.Services;

import com.example.paymentservice.models.Order;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGatewaySelector paymentGatewaySelector;
    public PaymentService(PaymentGatewaySelector paymentGatewaySelector) {
        this.paymentGatewaySelector = paymentGatewaySelector;
    }
    public String generatePaymentLink(Long id, String orderId, String userId, long amount, String status) {
        Order order = new Order();
        order.setId(id);
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setAmount(amount);
        order.setStatus(status);
        return paymentGatewaySelector.getPaymentGateway().GeneratePaymentLink(order);
    }
}
