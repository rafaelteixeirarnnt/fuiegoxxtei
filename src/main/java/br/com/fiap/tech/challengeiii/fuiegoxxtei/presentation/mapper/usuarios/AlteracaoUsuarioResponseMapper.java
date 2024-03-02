package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.response.AlteracaoUsuarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlteracaoUsuarioResponseMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "situacao", source = "situacao")
    @Mapping(target = "responsavelRestaurante", source = "responsavelRestaurante")
    @Mapping(target = "cep", source = "endereco.cep")
    @Mapping(target = "logradouro", source = "endereco.logradouro")
    @Mapping(target = "numero", source = "endereco.numero")
    @Mapping(target = "complemento", source = "endereco.complemento")
    AlteracaoUsuarioResponse criacaoUsuarioRequestToUsuario(Usuario usuario);

}
