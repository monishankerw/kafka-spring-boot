package com.stock_service.controller;

import com.stock_service.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
@Slf4j
public class StockController {

    private final StockService stockService;

    @GetMapping("/check/{productId}")
    public ResponseEntity<Boolean> isStockAvailable(@PathVariable String productId) {
        log.info("🔍 Checking stock for productId: {}", productId);
        boolean isAvailable = stockService.checkStock(productId);
        return ResponseEntity.ok(isAvailable);
    }
}
