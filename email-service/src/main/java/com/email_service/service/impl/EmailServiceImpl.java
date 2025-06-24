package com.email_service.service.impl;

import com.aop_service.annotations.LogExecutionTime;
import com.base_service.dto.OrderDTO;
import com.base_service.dto.OrderEvent;
import com.email_service.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Override
    @LogExecutionTime
    public void sendEmail(OrderEvent orderEvent) {
        OrderDTO order = orderEvent.getOrder();
        String to = order.getCustomerId() + "@example.com"; // or from a customer profile table

        String subject = "🧾 Order Confirmation: " + order.getOrderId();
        String body = """
                Hello,
                
                Your order has been received and is being processed.

                📦 Order ID: %s
                🛒 Product ID: %s
                🔢 Quantity: %d
                💰 Total: ₹%.2f
                🕒 Date: %s
                📌 Status: %s

                Thank you for shopping with us!
                """.formatted(
                order.getOrderId(),
                order.getProductId(),
                order.getQuantity(),
                order.getTotalAmount(),
                order.getOrderDate(),
                orderEvent.getStatus()
        );

        // Mock email logic (for now)
        log.info("📧 Sending email to: {}", to);
        log.info("Subject: {}", subject);
        log.info("Body:\n{}", body);

        // TODO: Integrate JavaMailSender or an email API provider like SendGrid, SES, etc.
    }
}

