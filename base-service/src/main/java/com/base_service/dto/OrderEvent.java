package com.base_service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrderEvent {
    private String message;
    private String status;
    private OrderDTO order;
}
