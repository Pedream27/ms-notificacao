package dev.phsaraiva.com.br.ms_agendamento.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import dev.phsaraiva.com.br.ms_agendamento.dto.Whatsapp;

public class WhatsappService extends TwiloConfig{

    public void sendMessage(Whatsapp whatsapp) {
        Twilio.init(this.getAccountSid(), this.getAuthToken());

        Message.creator(
                new PhoneNumber("whatsapp:" + whatsapp.to()),
                new PhoneNumber("whatsapp:" + this.getPhoneNumber()),
                whatsapp.message()
        ).create();
    }

}
