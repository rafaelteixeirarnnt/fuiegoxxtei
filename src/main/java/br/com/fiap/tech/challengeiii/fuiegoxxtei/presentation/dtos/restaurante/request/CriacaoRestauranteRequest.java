package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

public record CriacaoRestauranteRequest(@NotNull
                                        @NotBlank
                                        String idUsuario,
                                        @CNPJ
                                        @NotNull
                                        @Schema(description = "CNPJ", type = "string", name = "cnpj")
                                        String cnpj,
                                        @NotNull
                                        String nome,
                                        @NotNull
                                        String tipoCozinha,
                                        @NotNull
                                        @JsonFormat(pattern = "HH:mm:ss")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
                                        @Schema(description = "Hora de abertura do estabelecimento",
                                                type = "string",
                                                example = "00:00:00",
                                                name = "hrInicioAtendimento",
                                                defaultValue = "00:00:00")
                                        LocalTime hrInicioAtendimento,
                                        @NotNull
                                        @JsonFormat(pattern = "HH:mm:ss")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
                                        @Schema(description = "Hora de encerramento do estabelecimento",
                                                type = "string",
                                                example = "23:59:59",
                                                name = "hrFimAtendimento",
                                                defaultValue = "23:59:59")
                                        LocalTime hrFimAtendimento,
                                        Integer capacidade,
                                        @NotNull
                                        String telefone,
                                        @Email
                                        @NotNull
                                        String email,
                                        @Length(min = 8, max = 8)
                                        @NotNull
                                        String cep,
                                        @NotNull
                                        String logradouro,
                                        String numero,
                                        String complemento) {
}
