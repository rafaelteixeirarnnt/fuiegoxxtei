package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.RemocaoUsuarioRequest;

public interface RemoveUsuarioUseCase {
   Usuario remover(RemocaoUsuarioRequest request);
}
