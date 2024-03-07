package br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;

}
