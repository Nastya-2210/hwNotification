package com.example.demo.notify;

import com.example.demo.notify.NotificationService;
import com.example.demo.notify.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationSender {

    private final NotificationService emailService;
    private final NotificationService smsService;
    private NotificationService currentService;

    @Autowired
    public NotificationSender(
            @Qualifier("email") NotificationService emailService,
            @Qualifier("sms") NotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
        this.currentService = smsService; // По умолчанию sms
    }

    public void setNotificationType(NotificationType type) {
        switch (type) {
            case EMAIL:
                this.currentService = emailService;
                break;
            case SMS:
                this.currentService = smsService;
                break;
            default:
                throw new IllegalArgumentException("Неизвестный тип нотификации: " + type);
        }
    }

    public void send(String message) {
            currentService.send(message);
        }
    }