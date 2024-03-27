package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;


@Builder
public record CriacaoUsuarioRequest(@CPF
                                    @NotNull
                                    String cpf,
                                    @Length(min = 2, max = 50)
                                    @NotNull
                                    String nome,
                                    @Past
                                    @NotNull
                                    LocalDate dtNascimento,
                                    @NotNull
                                    @Length(min = 10, max = 11)
                                    @Schema(name = "telefone", description = "Telefone do usuário", type = "string", example = "11111111111 ou 1111111111")
                                    String telefone,
                                    @NotNull
                                    Boolean responsavelRestaurante,
                                    @Email
                                    @NotNull
                                    @Schema(name = "email", description = "Email do usuário", type = "string", example = "teste@teste.com")
                                    String email,
                                    @Length(min = 8, max = 8)
                                    @NotNull
                                    @Schema(name = "cep", description = "Cep do usuário", type = "string", example = "48370000")
                                    String cep,
                                    @NotNull
                                    String logradouro,
                                    String numero,
                                    String complemento) {
}
