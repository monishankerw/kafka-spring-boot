package com.stock_service.kafka;


import com.base_service.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderConsumer {

    /**
     * This method listens to the Kafka topic and consumes OrderEvent messages.
     */
    @KafkaListener(
            topics = "${app.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent orderEvent) {
        log.info("📦 Received OrderEvent in stock-service: {}", orderEvent);

        String productId = orderEvent.getOrder().getProductId();
        int quantity = orderEvent.getOrder().getQuantity();

        log.info("🔄 Updating stock for productId: {} by quantity: {}", productId, quantity);
    }

}
