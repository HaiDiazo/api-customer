package com.example.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class OrdersInsert {
    private UUID productId;
    private UUID customerId;
    private int totalAmount;
    private String status;
}
