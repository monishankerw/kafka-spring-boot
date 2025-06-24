package com.order_service.controller;

import com.aop_service.annotations.LogExecutionTime;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SampleController {

    @GetMapping("/demo")
    @LogExecutionTime
    public String sample() {
        // Simulate delay
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {}
        return "Response from /demo";
    }
}
