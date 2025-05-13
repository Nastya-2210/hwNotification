package com.example.demo.notify;

import org.springframework.beans.factory.annotation.Autowired;

public class NotificationController {
    private final NotificationSender notificationSender;


    @Autowired
    public NotificationController(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void sendNotification(String message, String type) {
        NotificationType notificationType = NotificationType.fromString(type);
        notificationSender.setNotificationType(notificationType);
        notificationSender.send(message);
    }
}
