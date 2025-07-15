package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_orders")
@Setter
public class TbOrders {
    @Id
    private UUID id;

    @ManyToOne
    @Getter
    @JoinColumn(name = "customer_id")
    private Customers customers;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_amount")
    private Integer totalAmount;

    private String status;
}
