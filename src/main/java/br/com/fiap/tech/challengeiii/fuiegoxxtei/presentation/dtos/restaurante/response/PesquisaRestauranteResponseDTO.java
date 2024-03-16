package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.enums.TipoCozinhaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class PesquisaRestauranteResponseDTO {

    private String id;
    private String nome;
    private TipoCozinhaEnum tipoCozinha;
    private String cep;
    private String logradouro;

    public PesquisaRestauranteResponseDTO(String id, String nome, String tipoCozinha, String cep, String logradouro) {
        this.id = id;
        this.nome = nome;
        this.tipoCozinha = TipoCozinhaEnum.obterPorDescricao(tipoCozinha);
        this.cep = cep;
        this.logradouro = logradouro;
    }
}
