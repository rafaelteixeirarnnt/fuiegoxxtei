package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record CriacaoUsuarioRequest(@CPF
                                    @NotNull
                                    String cpf,
                                    @Length(min = 2, max = 50)
                                    @NotNull
                                    String nome,
                                    @NotNull
                                    LocalDate dtNascimento,
                                    @NotNull
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
                                    String numero,
                                    String complemento) {
}
