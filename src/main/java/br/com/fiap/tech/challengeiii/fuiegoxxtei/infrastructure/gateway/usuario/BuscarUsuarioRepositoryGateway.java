package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.BuscarUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.usuario.UsuarioEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;

public class BuscarUsuarioRepositoryGateway implements BuscarUsuarioGateway {
   public BuscarUsuarioRepositoryGateway(UsuarioEntityRepository usuarioEntityRepository, UsuarioEntityMapper mapper, EnderecoEntityRepository enderecoEntityRepository) {
   }

   @Override
   public Usuario buscar(Usuario entity) {
      return null;
   }
}
