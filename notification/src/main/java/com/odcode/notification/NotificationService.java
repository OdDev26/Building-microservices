package com.odcode.notification;

import com.odcode.client.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {
    private NotificationRepository repository;

    public void register(NotificationRequest request) {

        repository.save
                (Notification.builder().
                        toCustomerId(request.toCustomerId())
                        .sender("Michael")
                        .sentAt(LocalDateTime.now()).
                                message(request.message()).
                        toCustomerEmail(request.toCustomerEmail())
                        .build());
    }

}
