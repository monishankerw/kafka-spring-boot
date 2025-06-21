package com.order_service.controller;

import com.base_service.dto.OrderDTO;
import com.base_service.dto.OrderEvent;
import com.order_service.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<String> publishOrder(@RequestBody OrderDTO orderDTO) {
        orderService.OrderDetails(orderDTO);
        return ResponseEntity.ok("Order placed successfully!");
    }
}
