package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.AlteracaoUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.response.AlteracaoUsuarioResponse;

public interface AlteraUsuarioUseCase {

    AlteracaoUsuarioResponse alterar(AlteracaoUsuarioRequest request);
}
