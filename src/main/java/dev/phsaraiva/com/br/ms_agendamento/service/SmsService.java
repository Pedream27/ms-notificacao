package dev.phsaraiva.com.br.ms_agendamento.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import dev.phsaraiva.com.br.ms_agendamento.dto.Sms;

@Service
public class SmsService extends TwiloConfig {


    public void sendSMS(Sms sms) {
        Twilio.init(this.getAccountSid(), this.getAuthToken());

        Message.creator(
                new PhoneNumber(sms.to()),
                new PhoneNumber(this.getPhoneNumber()),
                sms.message()
        ).create();
    }

}
