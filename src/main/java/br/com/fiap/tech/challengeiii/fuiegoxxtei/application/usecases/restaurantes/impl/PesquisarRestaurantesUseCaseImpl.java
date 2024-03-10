package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.impl;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante.PesquisaRestauranteGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.PesquisaRestaurantesUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.PesquisaRestauranteRequestDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PesquisarRestaurantesUseCaseImpl implements PesquisaRestaurantesUseCase {

    private final PesquisaRestauranteGateway gateway;

    @Override
    public void pesquisar(PesquisaRestauranteRequestDTO request) {
        this.gateway.pesquisar(request.getNome(), request.getTipoCozinha(), request.getCep(), request.getLogradouro(),
                request.getPagina(), request.getTamanhoPagina());
    }
}
