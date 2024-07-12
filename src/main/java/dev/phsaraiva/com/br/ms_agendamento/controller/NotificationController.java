package dev.phsaraiva.com.br.ms_agendamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.phsaraiva.com.br.ms_agendamento.dto.ScheduleNotificationDto;
import dev.phsaraiva.com.br.ms_agendamento.entity.Notification;
import dev.phsaraiva.com.br.ms_agendamento.service.NotificationService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDto dto) {
       service.scheduleNotification(dto);
        
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationID}")
    public ResponseEntity<Notification> getNotification(@PathVariable("notificationID") Long notificationId) {

      var notification = service.getNotification(notificationId);

      if (notification.isEmpty()) {
        return ResponseEntity.notFound().build();
      }

      return ResponseEntity.ok(notification.get());

    }
    
    @DeleteMapping("/{notificationID}")
    public ResponseEntity<Void> deleteNotification(@PathVariable("notificationID") Long notificationID){
        service.cancelNotification(notificationID);
        return ResponseEntity.noContent().build();

    }

}
