package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public record RemocaoUsuarioRequest(@NotNull String id) {
}
