package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class Order {
    private UUID id;

    @Column(name = "customer_id")
    private UUID customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "order_name")
    private String orderName;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "total_amount")
    private int totalAmount;
    private String status;

    public Order(
            UUID id,
            UUID customerId,
            String customerName,
            String orderName,
            Date orderDate,
            int totalAmount,
            String status
    ) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderName = orderName;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }
}
