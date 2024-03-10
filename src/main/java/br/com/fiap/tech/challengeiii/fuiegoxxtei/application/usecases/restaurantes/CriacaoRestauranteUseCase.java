package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.CriacaoRestauranteRequestDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.CriacaoRestauranteResponse;

public interface CriacaoRestauranteUseCase {

    CriacaoRestauranteResponse salvar(CriacaoRestauranteRequestDTO request);
}
