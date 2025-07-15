package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.CustomerOrderDTO;
import com.example.demo.dto.request.CustomersInsert;
import com.example.demo.entity.Customers;
import com.example.demo.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAll() {
        return customerRepository.findAll().stream()
                .map(customers -> new CustomerDTO(
                    customers.getId(),
                    customers.getName(),
                    customers.getUsername(),
                    customers.getEmail(),
                    customers.getPhone()
                )).collect(Collectors.toList());
    }

    public CustomerDTO getDetail(UUID customerId) {
        return customerRepository.findById(customerId)
                .map(customers -> new CustomerDTO(
                        customers.getId(),
                        customers.getName(),
                        customers.getUsername(),
                        customers.getEmail(),
                        customers.getPhone()
                )).orElseThrow(() -> new EntityNotFoundException("Customer id not found:" + customerId));
    }

    public Customers insert(CustomersInsert customersInsert) {
        UUID idCustomer = UUID.nameUUIDFromBytes(customersInsert.getUsername().getBytes());
        Customers customers = new Customers();
        customers.setId(idCustomer);
        customers.setName(customersInsert.getName());
        customers.setUsername(customersInsert.getUsername());
        customers.setPhone(customersInsert.getPhone());
        customers.setEmail(customersInsert.getEmail());
        return customerRepository.save(customers);
    }

    public Customers update(UUID customerId, CustomersInsert customersInsert) {
        Customers customers = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("ID Customers Not Found"));
        customers.setName(customersInsert.getName());
        customers.setUsername(customersInsert.getUsername());
        customers.setPhone(customersInsert.getPhone());
        customers.setEmail(customersInsert.getEmail());
        return customerRepository.save(customers);
    }
}
