package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.reserva.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

public record CriacaoReservaRequestDTO(@NotNull
                                       @NotBlank
                                       @NotEmpty
                                       String idRestaurante,
                                       @NotNull
                                       @NotBlank
                                       @NotEmpty
                                       String idUsuario,
                                       @NotNull
                                       @JsonFormat(pattern = "HH:mm:ss")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
                                       @Schema(description = "Horário da reserva",
                                               type = "string",
                                               example = "00:00:00",
                                               name = "horario",
                                               defaultValue = "12:00:00")
                                       LocalTime horario) {
}
