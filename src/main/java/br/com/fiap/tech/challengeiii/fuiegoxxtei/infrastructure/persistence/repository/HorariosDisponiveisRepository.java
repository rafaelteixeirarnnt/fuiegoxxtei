package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.HorarioDisponiveisEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariosDisponiveisRepository extends MongoRepository<HorarioDisponiveisEntity, String> {
}
