package com.order_service.services;

import com.base_service.dto.OrderDTO;
import com.base_service.dto.OrderEvent;

public interface OrderService {
    void OrderDetails(OrderDTO orderDTO);
}
