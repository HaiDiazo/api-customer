package com.example.demo.controller;

import com.example.demo.dto.CustomerOrderDTO;
import com.example.demo.dto.request.OrdersInsert;
import com.example.demo.dto.request.TbOrderInsert;
import com.example.demo.dto.response.ResponseApi;
import com.example.demo.entity.Orders;
import com.example.demo.entity.TbOrders;
import com.example.demo.service.OrderCustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/orders")
@Tag(name = "Orders Data By Customer Endpoint", description = "Operations related to Order Customer")
public class OrderController {

    private final OrderCustomerService orderCustomerService;

    public OrderController (OrderCustomerService orderCustomerService) {
        this.orderCustomerService = orderCustomerService;
    }

    @GetMapping("/")
    @Operation(summary = "Access data orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully processed data",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseApi.class)))
    })
    public ResponseEntity<?> getTbOrder(
            @RequestParam String status,
            @RequestParam @DateTimeFormat LocalDateTime startDate,
            @RequestParam @DateTimeFormat LocalDateTime endDate
    ) {
        long start = System.currentTimeMillis();
        ZoneId zoneId = ZoneId.of("Asia/Jakarta");

        List<CustomerOrderDTO> results = orderCustomerService.findByStatusAndCreatedDateBetween(
            status,
            Date.from(startDate.atZone(zoneId).toInstant()),
            Date.from(endDate.atZone(zoneId).toInstant())
        );
        double timeExecution = (System.currentTimeMillis() - start) / 1000.0;

        ResponseApi<List<CustomerOrderDTO>> response = new ResponseApi<>(
            HttpStatus.OK.value(),
            timeExecution,
            results
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    @Operation(summary = "Insert Order Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully processed data",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseApi.class)))
    })
    public ResponseEntity<?> insertTbOrder(
        @RequestBody TbOrderInsert tbOrderInsert
    ) {
        long start = System.currentTimeMillis();
        TbOrders result = orderCustomerService.insertTbOrder(tbOrderInsert);
        double timeExecution = (System.currentTimeMillis() - start) / 1000.0;

        ResponseApi<TbOrders> response = new ResponseApi<>(
            HttpStatus.OK.value(),
            timeExecution,
            result
        );
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/insert")
//    @Operation(summary = "Insert Order Customer")
    public ResponseEntity<?> insertOrder(
        @RequestBody List<OrdersInsert> ordersInserts
    ) {
        long start = System.currentTimeMillis();
        List<Orders> results = orderCustomerService.insertOrder(ordersInserts);
        double timeExecution = (System.currentTimeMillis() - start) / 1000.0;

        ResponseApi<List<Orders>> response = new ResponseApi<>(
                HttpStatus.OK.value(),
                timeExecution,
                results
        );
        return ResponseEntity.ok(response);
    }


//    @GetMapping("/{customerId}")
//    @Operation(summary = "Get Order By Customer Id")
    public ResponseEntity<?> getIOrderCustomerId(
            @PathVariable UUID customerId
    ) {

        long start = System.currentTimeMillis();
        List<CustomerOrderDTO> results = orderCustomerService.getCustomerOrderById(customerId);
        double timeExecution = (System.currentTimeMillis() - start) / 1000.0;

        ResponseApi<List<CustomerOrderDTO>> response = new ResponseApi<>(
                HttpStatus.OK.value(),
                timeExecution,
                results
        );
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/detail/{customerId}")
//    @Operation(summary = "Get Order By Customer Id")
    public ResponseEntity<?> getIOrderCustomerDetailId(
            @PathVariable UUID customerId
    ) {
        long start = System.currentTimeMillis();
        List<CustomerOrderDTO> results = orderCustomerService.getCustomerOrderDetailById(customerId);
        double timeExecution = (System.currentTimeMillis() - start) / 1000.0;

        ResponseApi<List<CustomerOrderDTO>> response = new ResponseApi<>(
                HttpStatus.OK.value(),
                timeExecution,
                results
        );
        return ResponseEntity.ok(response);
    }
}
