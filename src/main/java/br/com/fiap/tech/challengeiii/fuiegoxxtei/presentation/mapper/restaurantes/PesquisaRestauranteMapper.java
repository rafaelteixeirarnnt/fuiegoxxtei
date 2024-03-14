package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.restaurantes;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Restaurante;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.PesquisaRestauranteResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PesquisaRestauranteMapper {

    @Mapping(target = "nome", source = "nomeEstabelecimento")
    @Mapping(target = "tipoCozinha", source = "tipoCozinha", ignore = true)
    @Mapping(target = "cep", source = "endereco.cep")
    @Mapping(target = "logradouro", source = "endereco.logradouro")
    PesquisaRestauranteResponseDTO restauranteToPesquisaRestauranteDTO(Restaurante restaurante);

}
