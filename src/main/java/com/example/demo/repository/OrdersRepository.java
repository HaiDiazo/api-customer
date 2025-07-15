package com.example.demo.repository;

import com.example.demo.entity.CustomersOrders;
import com.example.demo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query(
        value = "SELECT c.id, o.customer_id, o.product_id," +
        "order_date, total_amount, status, c.username, " +
        "c.name, p.name AS product_name " +
        "FROM customers c " +
        "JOIN orders o ON c.id = o.customer_id " +
        "JOIN products p ON o.product_id = p.id " +
        "WHERE c.id = :customer_id",
        nativeQuery = true
    )
    List<CustomersOrders> customerOrdersDetail(@Param("customer_id") UUID customerId);

    @Query(
        value = "SELECT * FROM orders o WHERE o.customer_id = :customer_id",
        nativeQuery = true
    )
    List<Orders> customerOrdersAll(@Param("customer_id") UUID customerId);
}
