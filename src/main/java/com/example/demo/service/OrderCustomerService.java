package com.example.demo.service;

import com.example.demo.dto.CustomerOrderDTO;
import com.example.demo.dto.Order;
import com.example.demo.dto.request.OrdersInsert;
import com.example.demo.dto.request.TbOrderInsert;
import com.example.demo.entity.*;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.repository.TbOrdersRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderCustomerService {

    private final OrdersRepository ordersRepository;
    private final TbOrdersRepository tbOrdersRepository;

    public OrderCustomerService(OrdersRepository ordersRepository, TbOrdersRepository tbOrdersRepository) {
        this.ordersRepository = ordersRepository;
        this.tbOrdersRepository = tbOrdersRepository;
    }

    public TbOrders insertTbOrder(TbOrderInsert tbOrderInserts) {
        List<Orders> orders = new ArrayList<>();
        LocalDate today = LocalDate.now();

        String generateId = String.format(
            "%s-%s-%s",
            tbOrderInserts.getCustomerId(),
            tbOrderInserts.getOrderName(),
            today
        );
        UUID idOrders = UUID.nameUUIDFromBytes(generateId.getBytes());

        Customers customers = new Customers();
        customers.setId(tbOrderInserts.getCustomerId());

        TbOrders tbOrders = new TbOrders();
        tbOrders.setId(idOrders);
        tbOrders.setCustomers(customers);
        tbOrders.setOrderName(tbOrderInserts.getOrderName());
        tbOrders.setOrderDate(new Date());
        tbOrders.setStatus(tbOrderInserts.getStatus());
        tbOrders.setTotalAmount(tbOrderInserts.getTotalAmount());

        return tbOrdersRepository.save(tbOrders);
    }

    public List<CustomerOrderDTO> findByStatusAndCreatedDateBetween(
        String status,
        Date start,
        Date end
    ) {
        return tbOrdersRepository.findByStatusAndCreatedDateBetween(status, start, end).stream()
                .map(order -> new CustomerOrderDTO(
                    order.getId(),
                    order.getCustomerName(),
                    order.getOrderName(),
                    order.getOrderDate(),
                    order.getStatus(),
                    order.getTotalAmount()
                )).collect(Collectors.toList());
    }

    public List<Orders> insertOrder(List<OrdersInsert> ordersInserts) {
        List<Orders> orders = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for (OrdersInsert ordersInsert: ordersInserts) {
            String generateId = String.format(
                "%s-%s-%s",
                ordersInsert.getCustomerId(),
                ordersInsert.getProductId(),
                today
            );
            UUID idOrders = UUID.nameUUIDFromBytes(generateId.getBytes());

            Customers customers = new Customers();
            customers.setId(ordersInsert.getCustomerId());

            Products products = new Products();
            products.setId(ordersInsert.getProductId());

            Orders order = new Orders();
            order.setId(idOrders);
            order.setCustomer(customers);
            order.setProduct(products);
            order.setOrderDate(new Date());
            order.setTotalAmount(ordersInsert.getTotalAmount());
            order.setStatus(ordersInsert.getStatus());

            orders.add(order);
        }
        return ordersRepository.saveAll(orders);
    }
    public List<CustomerOrderDTO> getCustomerOrderById(UUID customerId) {
        List<Orders> ordersResult = ordersRepository.customerOrdersAll(customerId);
        return ordersResult.stream()
                .map(customer -> new CustomerOrderDTO(
                    customer.getCustomer().getId(),
                    customer.getCustomer().getName(),
                    customer.getProduct().getName(),
                    customer.getOrderDate(),
                    customer.getStatus(),
                    customer.getTotalAmount()
                ))
                .collect(Collectors.toList()
        );
    }

    public List<CustomerOrderDTO> getCustomerOrderDetailById(UUID customerId) {
        List<CustomersOrders> ordersResult = ordersRepository.customerOrdersDetail(customerId);
        return ordersResult.stream()
                .map(customer -> new CustomerOrderDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getNameProduct(),
                        customer.getOrderDate(),
                        customer.getStatus(),
                        customer.getTotalAmount()
                ))
                .collect(Collectors.toList()
        );
    }
}
