package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.controllers.dtos.request;

import java.time.LocalDate;

public record CriacaoUsuarioRequest(String cpf,
                                    String nome,
                                    LocalDate dtNascimento,
                                    String telefone,
                                    Boolean responsavelRestaurante,
                                    String email,
                                    String cep,
                                    String logradouro,
                                    String numero,
                                    String complemento) {
}
