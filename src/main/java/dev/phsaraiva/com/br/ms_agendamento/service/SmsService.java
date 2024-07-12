package dev.phsaraiva.com.br.ms_agendamento.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import dev.phsaraiva.com.br.ms_agendamento.entity.Sms;

@Service
public class SmsService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String phoneNumber;

    public void sendSMS(Sms sms) {
        Twilio.init(accountSid, authToken);

        Message.creator(
                new PhoneNumber(sms.to()),
                new PhoneNumber(phoneNumber),
                sms.message()
        ).create();
    }

}
