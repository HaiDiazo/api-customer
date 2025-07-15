package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
public class CustomersOrders {
    @Id
    private UUID id;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "product_id")
    private UUID productId;

    private Date orderDate;
    private int totalAmount;
    private String status;
    private String username;
    private String name;

    @Column(name = "product_name")
    private String nameProduct;
}
