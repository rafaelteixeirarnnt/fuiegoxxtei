package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.CriacaoUsuarioRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CriacaoUsuarioRequestMapper {

    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "dtNascimento", source = "dtNascimento")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "responsavelRestaurante", source = "responsavelRestaurante")
    @Mapping(target = "endereco.cep", source = "cep")
    @Mapping(target = "endereco.logradouro", source = "logradouro")
    @Mapping(target = "endereco.numero", source = "numero")
    @Mapping(target = "endereco.complemento", source = "complemento")
    Usuario criacaoUsuarioRequestToUsuario(CriacaoUsuarioRequest request);

}
