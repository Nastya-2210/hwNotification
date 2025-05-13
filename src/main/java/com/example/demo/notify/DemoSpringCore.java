package com.example.demo.notify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringCore {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DemoSpringCore.class, args);

        NotificationSender sender = ctx.getBean(NotificationSender.class);
        sender.setNotificationType(NotificationType.EMAIL);
        sender.send("Hello");
    }

}
