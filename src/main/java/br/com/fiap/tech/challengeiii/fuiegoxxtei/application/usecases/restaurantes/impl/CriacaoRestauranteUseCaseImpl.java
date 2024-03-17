package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.impl;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante.CriacaoRestauranteGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.CriacaoRestauranteUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.CriacaoRestauranteRequestDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.CriacaoRestauranteResponseDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.restaurantes.CriacaoRestauranteMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriacaoRestauranteUseCaseImpl implements CriacaoRestauranteUseCase {

    private final CriacaoRestauranteGateway gateway;
    private final CriacaoRestauranteMapper mapper;

    @Override
    public CriacaoRestauranteResponseDTO salvar(CriacaoRestauranteRequestDTO request) {
        var restaurante = this.mapper.criacaoRestauranteToRestaurante(request);
        restaurante.setTipoCozinha(request.tipoCozinhaEnum().getDescricao());

//        if (restaurante.getHrFimAtendimento().isBefore(restaurante.getHrInicioAtendimento())) {
//            throw new ApplicationException("A hora de fechamento do estabelecimento não pode ser menor que a data de abertura");
//        }

        var restauranteDb = this.gateway.salvar(restaurante);
        return new CriacaoRestauranteResponseDTO(restauranteDb.getId());
    }
}
