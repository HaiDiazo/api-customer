package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(products -> new ProductDTO(
                    products.getId(),
                    products.getName()
                )).collect(Collectors.toList());
    }
}
