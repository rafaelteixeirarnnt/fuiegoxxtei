package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.response.RemocaoUsuarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RemocaoUsuarioResponseMapper {
   @Mapping(target = "id", source = "id")
   RemocaoUsuarioResponse usuarioToRemoveUsuarioResponse(Usuario usuario);
}
