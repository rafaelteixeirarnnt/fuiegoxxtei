package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.response;

import java.time.LocalDate;

public record AlteracaoUsuarioResponse(String id,
                                       String cpf,
                                       String nome,
                                       LocalDate dtNascimento,
                                       String telefone,
                                       Boolean responsavelRestaurante,
                                       String email,
                                       Boolean situacao,
                                       String cep,
                                       String logradouro,
                                       String numero,
                                       String complemento) {
}
