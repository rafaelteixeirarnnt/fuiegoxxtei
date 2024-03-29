package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Restaurante;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.RestauranteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestauranteEntityRepository extends MongoRepository<RestauranteEntity, String> {

    Optional<RestauranteEntity> findByCnpj(String cnpj);

    Page<Restaurante> findAllByOrderByDataCriacaoDesc(Pageable pageable);
}
