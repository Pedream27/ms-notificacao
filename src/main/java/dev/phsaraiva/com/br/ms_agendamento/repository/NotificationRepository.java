package dev.phsaraiva.com.br.ms_agendamento.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.phsaraiva.com.br.ms_agendamento.entity.Notification;
import dev.phsaraiva.com.br.ms_agendamento.entity.Status;

public interface NotificationRepository extends JpaRepository<Notification , Long>{

    List<Notification> findByStatusInAndDateTimeBefore(List<Status> of, LocalDateTime dateTime);
     
}
