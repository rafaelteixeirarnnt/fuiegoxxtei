package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.response.BuscarUsuarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BuscarUsuarioResponseMapper {
   @Mapping(target = "id", source = "id")
   BuscarUsuarioResponse buscarUsuarioRequestToUsuario(Usuario usuario);
}
