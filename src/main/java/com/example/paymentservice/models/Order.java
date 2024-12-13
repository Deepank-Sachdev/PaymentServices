package com.example.paymentservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private Long id;
    private String orderId;
    private String userId;
    private long amount;
    private String status;
}
