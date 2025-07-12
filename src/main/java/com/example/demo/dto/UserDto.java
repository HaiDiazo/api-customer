package com.example.demo.dto;

import lombok.Getter;

@Getter
public class UserDto {
    private String name;
    private String email;
    private boolean active;

    public UserDto(String name, String email, boolean active) {
        this.name = name;
        this.email = email;
        this.active = active;
    }
}
