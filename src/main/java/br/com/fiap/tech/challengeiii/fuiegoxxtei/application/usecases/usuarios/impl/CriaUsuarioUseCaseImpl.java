package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.impl;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.CriacaoUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.CriaUsuarioUseCase;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.CriacaoUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios.CriacaoUsuarioRequestMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriaUsuarioUseCaseImpl implements CriaUsuarioUseCase {

    private final CriacaoUsuarioGateway criacaoUsuarioGateway;
    private final CriacaoUsuarioRequestMapper criacaoUsuarioRequestMapper;

    @Override
    public Usuario salvar(CriacaoUsuarioRequest request) {
        var usuario = criacaoUsuarioRequestMapper.criacaoUsuarioRequestToUsuario(request);
        return this.criacaoUsuarioGateway.salvar(usuario);
    }
}
