package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.request.AlteracaoUsuarioRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlteracaoUsuarioRequestMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "situacao", source = "situacao")
    @Mapping(target = "responsavelRestaurante", source = "responsavelRestaurante")
    @Mapping(target = "endereco.cep", source = "cep")
    @Mapping(target = "endereco.logradouro", source = "logradouro")
    @Mapping(target = "endereco.numero", source = "numero")
    @Mapping(target = "endereco.complemento", source = "complemento")
    Usuario alteracaoUsuarioRequestToUsuario(AlteracaoUsuarioRequest request);

}
