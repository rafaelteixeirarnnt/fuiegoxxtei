package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.impl;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.UsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.CriaUsuarioUseCase;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.request.CriacaoUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.CriacaoUsuarioRequestMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriaUsuarioUseCaseImpl implements CriaUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;
    private final CriacaoUsuarioRequestMapper criacaoUsuarioRequestMapper;

    @Override
    public Usuario salvar(CriacaoUsuarioRequest request) {
        var usuario = criacaoUsuarioRequestMapper.criacaoUsuarioRequestToUsuario(request);
        return this.usuarioGateway.salvar(usuario);
    }
}
