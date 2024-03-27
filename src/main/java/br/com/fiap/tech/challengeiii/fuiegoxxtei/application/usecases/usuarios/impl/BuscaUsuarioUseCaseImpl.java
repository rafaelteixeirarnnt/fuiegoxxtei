package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.impl;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.BuscarUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.RemocaoUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.BuscaUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.BuscarUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.RemocaoUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios.BuscarUsuarioRequestMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios.RemocaoUsuarioRequestMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscaUsuarioUseCaseImpl implements BuscaUsuarioUseCase {
   private final BuscarUsuarioGateway buscarUsuarioGateway;
   private final BuscarUsuarioRequestMapper buscarUsuarioRequestMapper;

   @Override
   public Usuario buscar(BuscarUsuarioRequest request) {
      var usuario = buscarUsuarioRequestMapper.buscarUsuarioRequestToUsuario(request);
      return this.buscarUsuarioGateway.buscar(usuario);
   }
}
