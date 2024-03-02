package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record AlteracaoUsuarioRequest(@NotNull
                                      String id,
                                      @NotNull
                                      String nome,
                                      @NotNull
                                      @Length(min = 10, max = 11)
                                      String telefone,
                                      @NotNull
                                      Boolean responsavelRestaurante,
                                      @Email
                                      @NotNull
                                      String email,
                                      @Length(min = 8, max = 8)
                                      @NotNull
                                      String cep,
                                      @NotNull
                                      String logradouro,
                                      @NotNull
                                      Boolean situacao,
                                      String numero,
                                      String complemento) {
}
