package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.restaurantes;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Restaurante;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.CriacaoRestauranteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CriacaoRestauranteMapper {

    @Mapping(target = "nomeEstabelecimento", source = "nome")
    @Mapping(target = "cnpj", source = "cnpj")
    @Mapping(target = "hrInicioAtendimento", source = "hrInicioAtendimento")
    @Mapping(target = "hrFimAtendimento", source = "hrFimAtendimento")
    @Mapping(target = "capacidade", source = "capacidade")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "usuario.id", source = "idUsuario")
    @Mapping(target = "endereco.cep", source = "cep")
    @Mapping(target = "endereco.logradouro", source = "logradouro")
    @Mapping(target = "endereco.numero", source = "numero")
    @Mapping(target = "endereco.complemento", source = "complemento")
    Restaurante criacaoRestauranteToRestaurante(CriacaoRestauranteRequest request);

}
