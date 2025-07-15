package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Orders {

    @Id
    private UUID id;

    @ManyToOne
    @Getter
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @ManyToOne
    @Getter
    @JoinColumn(name = "product_id")
    private Products product;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_amount")
    private Integer totalAmount;

    private String status;

}
