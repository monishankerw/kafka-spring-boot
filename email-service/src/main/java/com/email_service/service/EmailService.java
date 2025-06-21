package com.email_service.service;

import com.base_service.dto.OrderEvent;

public interface EmailService {
    public void sendEmail(OrderEvent orderEvent);
}
