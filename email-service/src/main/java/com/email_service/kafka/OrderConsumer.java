package com.email_service.kafka;


import com.base_service.dto.OrderEvent;
import com.email_service.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderConsumer {
    private final EmailService emailService;

    /**
     * This method listens to the Kafka topic and consumes OrderEvent messages.
     */
    @KafkaListener(
            topics = "${app.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent orderEvent) {
        log.info("📦 Received OrderEvent in email-service: {}", orderEvent);

        String productId = orderEvent.getOrder().getProductId();
        int quantity = orderEvent.getOrder().getQuantity();

        log.info("📦 Received OrderEvent in stock-service: {}", orderEvent);
        emailService.sendEmail(orderEvent);
    }


}
