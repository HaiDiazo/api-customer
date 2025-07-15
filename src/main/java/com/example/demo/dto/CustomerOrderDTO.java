package com.example.demo.dto;

import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class CustomerOrderDTO {
    private UUID id;
    private String customerName;
    private String productName;
    private Date orderDate;
    private String status;
    private int totalAmount;

    public CustomerOrderDTO(
        UUID id,
        String customerName,
        String productName,
        Date orderDate,
        String status,
        int totalAmount
    ) {
        this.id = id;
        this.customerName = customerName;
        this.productName = productName;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }
}
