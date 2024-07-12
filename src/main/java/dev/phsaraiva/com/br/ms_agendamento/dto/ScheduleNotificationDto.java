package dev.phsaraiva.com.br.ms_agendamento.dto;

import java.time.LocalDateTime;



import dev.phsaraiva.com.br.ms_agendamento.entity.Channel;
import dev.phsaraiva.com.br.ms_agendamento.entity.Notification;
import dev.phsaraiva.com.br.ms_agendamento.entity.Status;
import dev.phsaraiva.com.br.ms_agendamento.entity.User;

public record ScheduleNotificationDto(
    LocalDateTime dateTime,
    String destination,
    String message,
    Channel.Values channel,
    User user
) {


    public Notification toNotification(){
        return new Notification(
           this.dateTime,
           this.destination,
           this.message,
            channel.toChannel(),
           Status.Values.PENDING.toStatus(),
           this.user

        );
    }
}
