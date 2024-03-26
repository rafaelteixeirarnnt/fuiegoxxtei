package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.impl;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.RemocaoUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.BuscaUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.RemocaoUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios.RemocaoUsuarioRequestMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscaUsuarioUseCaseImpl implements BuscaUsuarioUseCase {
   private final RemocaoUsuarioGateway remocaoUsuarioGateway;
   private final RemocaoUsuarioRequestMapper remocaoUsuarioRequestMapper;

   @Override
   public Usuario remove(RemocaoUsuarioRequest request) {
      var usuario = remocaoUsuarioRequestMapper.removeUsuarioRequestToUsuario(request);
      return this.remocaoUsuarioGateway.remover(usuario);
   }
}
