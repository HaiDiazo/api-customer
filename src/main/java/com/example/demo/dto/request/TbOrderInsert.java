package com.example.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class TbOrderInsert {
    private UUID customerId;
    private String orderName;
    private int totalAmount;
    private String status;
}
