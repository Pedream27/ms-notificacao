package dev.phsaraiva.com.br.ms_agendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MsAgendamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAgendamentoApplication.class, args);
	}

}
