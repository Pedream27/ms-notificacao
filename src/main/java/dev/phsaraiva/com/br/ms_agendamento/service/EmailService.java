package dev.phsaraiva.com.br.ms_agendamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import dev.phsaraiva.com.br.ms_agendamento.dto.Email;
@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(Email email){
        var message = new SimpleMailMessage();
        message.setFrom("teste@email.com");
        message.setTo(email.to());
        message.setSubject(email.subject());
        message.setText(email.body());
        mailSender.send(message);
    }
}
