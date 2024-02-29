package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.impl;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.AlteracaoUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.AlteraUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.request.AlteracaoUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.AlteracaoUsuarioRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class AlteraUsuarioUseCaseImpl implements AlteraUsuarioUseCase {

    private final AlteracaoUsuarioGateway gateway;
    private final AlteracaoUsuarioRequestMapper mapper;

    @Override
    @Transactional
    public void alterar(AlteracaoUsuarioRequest request) {
        var usuario = this.mapper.alteracaoUsuarioRequestToUsuario(request);
        this.gateway.alterar(usuario);
    }
}
