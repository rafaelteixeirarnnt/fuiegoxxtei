package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.PesquisaRestauranteRequestDTO;

public interface PesquisaRestaurantesUseCase {

    void pesquisar(PesquisaRestauranteRequestDTO request);

}
