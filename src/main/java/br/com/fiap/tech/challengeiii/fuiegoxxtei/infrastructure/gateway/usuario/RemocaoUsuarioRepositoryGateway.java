package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.RemocaoUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.usuario.UsuarioEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class RemocaoUsuarioRepositoryGateway implements RemocaoUsuarioGateway {

   public RemocaoUsuarioRepositoryGateway(UsuarioEntityRepository usuarioEntityRepository, UsuarioEntityMapper mapper, EnderecoEntityRepository enderecoEntityRepository) {
   }

   @Override
   @Transactional
   public Usuario remover(Usuario entity) {
      return null;
   }
}
