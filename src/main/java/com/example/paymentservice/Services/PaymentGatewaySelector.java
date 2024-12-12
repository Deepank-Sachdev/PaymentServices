package com.example.paymentservice.Services;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelector {
    private RazorPayPaymentGateway razorpayPaymentGateway;
    private StripePaymenGateway stripePaymenGateway;

    public PaymentGatewaySelector(
            RazorPayPaymentGateway razorpayPaymentGateway,
            StripePaymenGateway stripePaymenGateway) {
                    this.razorpayPaymentGateway = razorpayPaymentGateway;
                    this.stripePaymenGateway = stripePaymenGateway;
    }
    public PaymentGateway getPaymentGateway() {
        // Logic to select
        return razorpayPaymentGateway;
//        return stripePaymenGateway;
    }
}
