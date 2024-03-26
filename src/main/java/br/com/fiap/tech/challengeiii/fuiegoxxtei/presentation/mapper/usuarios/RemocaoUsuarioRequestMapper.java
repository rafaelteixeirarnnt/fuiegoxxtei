package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.RemocaoUsuarioRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RemocaoUsuarioRequestMapper {
   @Mapping(target = "id", source = "id")
   Usuario removeUsuarioRequestToUsuario(RemocaoUsuarioRequest request);
}
