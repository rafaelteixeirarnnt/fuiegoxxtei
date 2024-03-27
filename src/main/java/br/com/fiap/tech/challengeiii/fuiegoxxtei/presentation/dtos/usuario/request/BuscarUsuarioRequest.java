package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
public record BuscarUsuarioRequest(@NotNull String id) {
}
