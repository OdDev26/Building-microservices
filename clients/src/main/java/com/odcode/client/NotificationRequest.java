package com.odcode.client;

import java.time.LocalDateTime;

public record NotificationRequest(
                    Integer toCustomerId,
                    String toCustomerEmail,
                    String message) {
}
