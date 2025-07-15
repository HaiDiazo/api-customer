package com.example.demo.repository;

import com.example.demo.dto.Order;
import com.example.demo.entity.TbOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TbOrdersRepository extends JpaRepository<TbOrders, UUID> {

    @Query(
            value = "SELECT o.id, o.customer_id, c.username AS customer_name," +
                    "order_name, order_date, total_amount, status " +
                    "FROM customers c " +
                    "JOIN tb_orders o ON c.id = o.customer_id " +
                    "WHERE created_at BETWEEN :start AND :end " +
                    "AND status = :status",
            nativeQuery = true
    )
    List<Order> findByStatusAndCreatedDateBetween(
            @Param("status") String status,
            @Param("start") Date start,
            @Param("end") Date end
    );
}
