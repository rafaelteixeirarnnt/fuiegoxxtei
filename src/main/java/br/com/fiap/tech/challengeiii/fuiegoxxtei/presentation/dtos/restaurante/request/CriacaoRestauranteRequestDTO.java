package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.enums.TipoCozinhaEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

public record CriacaoRestauranteRequestDTO(@NotNull
                                           @NotBlank
                                           String idUsuario,
                                           @CNPJ
                                           @NotNull
                                           @Schema(description = "CNPJ", type = "string", name = "cnpj")
                                           String cnpj,
                                           @NotNull
                                           String nome,
                                           @NotNull
                                           @Schema(name = "tipoCozinha", type = "string", description = "Tipos de cozinha que o sistema permite atualmente", example = "BRASILEIRA ou ITALIANA ou ARABE ou JAPONESA ou VEGETARIANA")
                                           TipoCozinhaEnum tipoCozinhaEnum,
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
                                           @Schema(name = "telefone", description = "Telefone do usuário", type = "string", example = "11111111111 ou 1111111111")
                                           String telefone,
                                           @Email
                                           @NotNull
                                           @Schema(name = "email", description = "Email do usuário", type = "string", example = "teste@teste.com")
                                           String email,
                                           @Length(min = 8, max = 8)
                                           @NotNull
                                           @Schema(name = "cep", description = "Cep do restaurante", type = "string", example = "48370000")
                                           String cep,
                                           @NotNull
                                           String logradouro,
                                           String numero,
                                           String complemento) {
}
