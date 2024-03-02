package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios;


import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.response.CriacaoUsuarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CriacaoUsuarioResponseMapper {

    @Mapping(target = "id", source = "id")
    CriacaoUsuarioResponse usuarioToCriacaoUsuarioResponse(Usuario usuario);

}
