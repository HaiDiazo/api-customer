package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.response.ResponseApi;
import com.example.demo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Tag(name = "Product Endpoint", description = "Operation Product Data")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all data product")
    public ResponseEntity<?> getAll() {

        long start = System.currentTimeMillis();
        List<ProductDTO> results = productService.getAll();
        double timeExecution = (System.currentTimeMillis() - start) / 1000.0;

        ResponseApi<List<ProductDTO>> response = new ResponseApi<>(
            HttpStatus.OK.value(),
            timeExecution,
            results
        );
        return ResponseEntity.ok(response);
    }
}
