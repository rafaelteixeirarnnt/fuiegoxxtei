package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.ReservaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservaEntityRepository extends MongoRepository<ReservaEntity, String> {

    List<ReservaEntity> findByRestaurante_IdAndData(String idRestaurante, LocalDate data);
    List<ReservaEntity> findByHorarioDisponivel_HorarioAndData(LocalTime horario, LocalDate data);;

}
