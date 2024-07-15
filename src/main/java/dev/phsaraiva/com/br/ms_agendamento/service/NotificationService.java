package dev.phsaraiva.com.br.ms_agendamento.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.phsaraiva.com.br.ms_agendamento.dto.Email;
import dev.phsaraiva.com.br.ms_agendamento.dto.ScheduleNotificationDto;
import dev.phsaraiva.com.br.ms_agendamento.dto.Sms;
import dev.phsaraiva.com.br.ms_agendamento.dto.Whatsapp;
import dev.phsaraiva.com.br.ms_agendamento.entity.Notification;
import dev.phsaraiva.com.br.ms_agendamento.entity.Status;
import dev.phsaraiva.com.br.ms_agendamento.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private SmsService smsService;
    @Autowired
    private WhatsappService whatsappService;

    public void scheduleNotification(ScheduleNotificationDto scheduleNotificationDto) {

        repository.save(scheduleNotificationDto.toNotification());
    }

    public Optional<Notification> getNotification(Long notificationId) {
        return repository.findById(notificationId);
    }

    public void cancelNotification(Long notificationID) {
        var notification = repository.findById(notificationID);

        if (notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            repository.save(notification.get());
        }

    }

    public void checkAndSend(LocalDateTime dateTime) {
        var notifications = repository.findByStatusInAndDateTimeBefore(List.of(
                Status.Values.PENDING.toStatus(),
                Status.Values.ERROR.toStatus()), dateTime);

        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return n -> {
            String channelString = n.getChannel().getDescription();

            switch (channelString) {
                case "email":
                    emailService.sendEmail(
                            new Email(n.getUser().getEmail(), "Notificação Padrão ........", n.getMessage()));
                    break;

                case "sms":
                    smsService.sendSMS(new Sms(n.getUser().getNumber(), n.getMessage()));
                    break;

                case "whatsapp":
                    whatsappService.sendMessage(new Whatsapp(n.getUser().getNumber(), n.getMessage()));
                    break;

            }

            n.setStatus(Status.Values.SUCCESS.toStatus());
            repository.save(n);
        };
    }

}
