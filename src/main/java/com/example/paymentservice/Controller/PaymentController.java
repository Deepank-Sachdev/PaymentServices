package com.example.paymentservice.Controller;

import com.example.paymentservice.DTO.OrderRequestDTO;
import com.example.paymentservice.Services.PaymentService;
import com.example.paymentservice.models.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<String> initiatePayment(@RequestBody OrderRequestDTO requestDTO) {
        return ResponseEntity.ok(paymentService.generatePaymentLink(
                requestDTO.getId(),
                requestDTO.getOrderId(),
                requestDTO.getUserId(),
                requestDTO.getAmount(),
                requestDTO.getStatus()
        ));
//        return ResponseEntity.ok(order.toString());
    }
}
