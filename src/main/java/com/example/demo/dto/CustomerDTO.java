package com.example.demo.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CustomerDTO {
    private final UUID id;
    private final String name;
    private final String username;
    private final String email;
    private final String phone;

    public CustomerDTO(UUID id, String name, String username, String email, String phone) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }
}
