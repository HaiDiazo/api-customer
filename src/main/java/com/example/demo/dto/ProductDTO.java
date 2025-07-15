package com.example.demo.dto;

import lombok.Getter;

import java.util.UUID;


@Getter
public class ProductDTO {
    private UUID id;
    private String name;

    public ProductDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
