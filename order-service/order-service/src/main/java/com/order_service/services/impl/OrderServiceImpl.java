package com.order_service.services.impl;

import com.base_service.dto.OrderDTO;
import com.base_service.dto.OrderEvent;
import com.order_service.kafka.OrderProducer;
import com.order_service.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderProducer orderProducer;
    @Override
    public void OrderDetails(OrderDTO orderDTO) {
        orderDTO.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrder(orderDTO);
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order Status is PENDING");
        orderProducer.sendMessage(orderEvent);
    }

    }

