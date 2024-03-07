package br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante {

    private String id;
    private String cnpj;
    private String nomeEstabelecimento;
    private String tipoCozinha;
    private LocalTime hrInicioAtendimento;
    private LocalTime hrFimAtendimento;
    private Integer capacidade;
    private String email;
    private String telefone;

    private Usuario usuario;
    private Endereco endereco;
}
