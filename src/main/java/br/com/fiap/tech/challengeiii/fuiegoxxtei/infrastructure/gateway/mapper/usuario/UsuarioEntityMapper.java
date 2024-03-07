package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {

    UsuarioEntity usuarioEntity(Usuario usuario);
    Usuario usuario(UsuarioEntity entity);

}
