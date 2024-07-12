package dev.phsaraiva.com.br.ms_agendamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.phsaraiva.com.br.ms_agendamento.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
