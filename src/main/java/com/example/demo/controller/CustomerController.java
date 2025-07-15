package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.request.CustomersInsert;
import com.example.demo.dto.response.ResponseApi;
import com.example.demo.entity.Customers;
import com.example.demo.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/customer")
@Tag(name = "Customer Endpoint", description = "Operations related to customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController (CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get All Customer Detail")
    public ResponseEntity<?> getAll() {
        long start = System.currentTimeMillis();

        List<CustomerDTO> results = customerService.getAll();

        long end = System.currentTimeMillis();
        double executionTime = (end - start) / 1000.0;

        ResponseApi<List<CustomerDTO>> response = new ResponseApi<>(
            HttpStatus.OK.value(),
            executionTime,
            results
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/detail/{customerId}")
    @Operation(summary = "Get Customer Detail By customerId")
    public ResponseEntity<?> getAll(
        @PathVariable UUID customerId
    ) {
        long start = System.currentTimeMillis();

        CustomerDTO results = customerService.getDetail(customerId);

        long end = System.currentTimeMillis();
        double executionTime = (end - start) / 1000.0;

        ResponseApi<CustomerDTO> response = new ResponseApi<>(
                HttpStatus.OK.value(),
                executionTime,
                results
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    @Operation(summary = "Insert Customer")
    public ResponseEntity<?> insert(
        @RequestBody @Valid CustomersInsert customersInsert
    ) {
        long start = System.currentTimeMillis();

        Customers results = customerService.insert(customersInsert);

        long end = System.currentTimeMillis();
        double executionTime = (end - start) / 1000.0;

        ResponseApi<Customers> response = new ResponseApi<>(
                HttpStatus.OK.value(),
                executionTime,
                results
        );

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{customerId}")
    @Operation(summary = "Update Detail Customer")
    public ResponseEntity<?> update(
        @PathVariable UUID customerId,
        @RequestBody @Valid CustomersInsert customersInsert
    ) {
        long start = System.currentTimeMillis();

        Customers results = customerService.update(customerId, customersInsert);

        long end = System.currentTimeMillis();
        double executionTime = (end - start) / 1000.0;

        ResponseApi<Customers> response = new ResponseApi<>(
                HttpStatus.OK.value(),
                executionTime,
                results
        );
        return ResponseEntity.ok(response);
    }
}
