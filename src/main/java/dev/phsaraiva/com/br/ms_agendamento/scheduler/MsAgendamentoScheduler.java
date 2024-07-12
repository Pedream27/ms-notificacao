package dev.phsaraiva.com.br.ms_agendamento.scheduler;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import dev.phsaraiva.com.br.ms_agendamento.service.NotificationService;

@Component
public class MsAgendamentoScheduler {

    Logger logger = LoggerFactory.getLogger(MsAgendamentoScheduler.class);
    @Autowired
    private NotificationService service;

    @Scheduled(fixedDelay = 1 , timeUnit = TimeUnit.MINUTES)
    public void checkTask(){
        var dateTime = LocalDateTime.now();
        logger.info("rodando at {}", dateTime);
        service.checkAndSend(dateTime);

    }

}
