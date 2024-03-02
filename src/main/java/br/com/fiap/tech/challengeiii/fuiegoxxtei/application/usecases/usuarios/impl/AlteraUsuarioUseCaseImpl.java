package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.impl;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.AlteracaoUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.AlteraUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.AlteracaoUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.response.AlteracaoUsuarioResponse;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios.AlteracaoUsuarioRequestMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios.AlteracaoUsuarioResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class AlteraUsuarioUseCaseImpl implements AlteraUsuarioUseCase {

    private final AlteracaoUsuarioGateway gateway;
    private final AlteracaoUsuarioRequestMapper mapper;
    private final AlteracaoUsuarioResponseMapper alteracaoUsuarioResponseMapper;

    @Override
    @Transactional
    public AlteracaoUsuarioResponse alterar(AlteracaoUsuarioRequest request) {
        var usuario = this.mapper.alteracaoUsuarioRequestToUsuario(request);
        var usuarioAlterado = this.gateway.alterar(usuario);
        return this.alteracaoUsuarioResponseMapper.criacaoUsuarioRequestToUsuario(usuarioAlterado);
    }
}
