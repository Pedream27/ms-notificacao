package dev.phsaraiva.com.br.ms_agendamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.phsaraiva.com.br.ms_agendamento.entity.Status;

public interface StatusRepository extends JpaRepository<Status , Long> {

}
