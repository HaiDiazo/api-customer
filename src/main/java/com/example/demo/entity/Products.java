package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Products {
    @Id
    private UUID id;
    private String name;
    private Timestamp created_at;
    private Timestamp updated_at;
}
