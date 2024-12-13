package com.example.paymentservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    private Long id;
    private String orderId;
    private String userId;
    private long amount;
    private String status;

}
