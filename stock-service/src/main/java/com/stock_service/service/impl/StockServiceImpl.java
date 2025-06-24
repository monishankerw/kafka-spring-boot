package com.stock_service.service.impl;

import com.stock_service.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class StockServiceImpl implements StockService {

    private static final Map<String, Integer> inventory = new HashMap<>();

    static {
        inventory.put("prod-001", 10);
        inventory.put("prod-002", 0);
        inventory.put("prod-003", 25);
    }

    @Override
    public boolean checkStock(String productId) {
        int availableQty = inventory.getOrDefault(productId, 0);
        log.info("Available quantity for {}: {}", productId, availableQty);
        return availableQty > 0;
    }
}
