package com.example.demo.notify;

import lombok.Getter;

@Getter
public enum NotificationType {
    EMAIL("email"),
    SMS("sms");

    private final String typeName;

    NotificationType(String typeName) {
        this.typeName = typeName;
    }

    public static NotificationType fromString (String text) {
        for (NotificationType type : NotificationType.values()) {
            if (type.typeName.equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Неизвестный тип нотификации: " + text);
    }
}
