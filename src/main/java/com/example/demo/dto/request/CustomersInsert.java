package com.example.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomersInsert {
    private String username;
    private String name;
    private String email;
    private String phone;
}
