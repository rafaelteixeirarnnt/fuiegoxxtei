package br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.EnderecoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private String id;
    private String cpf;
    private String nome;
    private LocalDate dtNascimento;
    private String telefone;
    private Boolean responsavelRestaurante;
    private String email;
    private Boolean situacao;

    private EnderecoEntity endereco;

}
