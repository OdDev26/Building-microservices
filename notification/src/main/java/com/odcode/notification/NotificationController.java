package com.odcode.notification;

import com.odcode.client.NotificationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {
    private NotificationService notificationService;

    @PostMapping()
    public void registerNotification(@RequestBody NotificationRequest notificationRequest){
        notificationService.register(notificationRequest);
    }
}
