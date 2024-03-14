package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.enums.TipoCozinhaEnum;

public record PesquisaRestauranteResponseDTO(String nome,
                                             TipoCozinhaEnum tipoCozinha,
                                             String cep,
                                             String logradouro) {
}
