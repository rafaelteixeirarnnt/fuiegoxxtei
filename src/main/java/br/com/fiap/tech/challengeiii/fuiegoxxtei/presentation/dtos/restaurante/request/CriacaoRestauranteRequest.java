package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request;

import java.time.LocalTime;

public record CriacaoRestauranteRequest(String nome,
                                        String tipoCozinha,
                                        LocalTime hrFuncionamento,
                                        Integer capacidade) {
}
