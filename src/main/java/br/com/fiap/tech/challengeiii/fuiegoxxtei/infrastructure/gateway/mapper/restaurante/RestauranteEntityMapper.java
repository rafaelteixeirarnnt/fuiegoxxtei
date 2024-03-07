package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Restaurante;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.RestauranteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestauranteEntityMapper {

    RestauranteEntity restauranteToRestaurante(Restaurante restaurante);

    Restaurante entityToRestaurante(RestauranteEntity entity);

}
