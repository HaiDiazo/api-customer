package com.example.demo.repository;

import com.example.demo.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customers, UUID> {
}
