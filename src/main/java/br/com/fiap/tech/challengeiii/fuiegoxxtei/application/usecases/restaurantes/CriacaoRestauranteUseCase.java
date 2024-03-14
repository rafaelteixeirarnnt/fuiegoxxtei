package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.CriacaoRestauranteRequestDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.CriacaoRestauranteResponseDTO;

public interface CriacaoRestauranteUseCase {

    CriacaoRestauranteResponseDTO salvar(CriacaoRestauranteRequestDTO request);
}
