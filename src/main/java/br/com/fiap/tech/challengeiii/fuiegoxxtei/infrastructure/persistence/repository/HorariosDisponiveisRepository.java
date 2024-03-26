package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.HorarioDisponivelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface HorariosDisponiveisRepository extends MongoRepository<HorarioDisponivelEntity, String> {

    List<HorarioDisponivelEntity> findByRestaurante_Id(String idRestaurante);
    List<HorarioDisponivelEntity> findByRestaurante_IdAndHorario(String idRestaurante, LocalTime horario);

}
