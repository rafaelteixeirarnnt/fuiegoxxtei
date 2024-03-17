package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.impl;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante.PesquisaRestauranteGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.PesquisaRestaurantesUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.PesquisaRestauranteRequestDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.PesquisaRestauranteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
public class PesquisarRestaurantesUseCaseImpl implements PesquisaRestaurantesUseCase {

    private final PesquisaRestauranteGateway gateway;

    @Override
    public Page<PesquisaRestauranteResponseDTO> pesquisar(PesquisaRestauranteRequestDTO request) {
        return this.gateway.pesquisar(request.getNome(), request.getTipoCozinha(), request.getCep(), request.getLogradouro(),
                request.getPagina(), request.getTamanhoPagina());
    }
}
