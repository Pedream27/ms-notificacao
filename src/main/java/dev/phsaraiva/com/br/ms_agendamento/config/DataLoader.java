package dev.phsaraiva.com.br.ms_agendamento.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import dev.phsaraiva.com.br.ms_agendamento.entity.Channel;
import dev.phsaraiva.com.br.ms_agendamento.entity.Status;
import dev.phsaraiva.com.br.ms_agendamento.repository.ChannelRepository;
import dev.phsaraiva.com.br.ms_agendamento.repository.StatusRepository;
@Configuration
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;
    private final StatusRepository statusRepository;

    public DataLoader(ChannelRepository channelRepository, StatusRepository statusRepository) {
        this.channelRepository = channelRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       Arrays.stream(Channel.Values.values())
       .map(Channel.Values::toChannel)
       .forEach(channelRepository::save);

        Arrays.stream(Status.Values.values())
        .map(Status.Values::toStatus)
        .forEach(statusRepository::save);


    }

}
