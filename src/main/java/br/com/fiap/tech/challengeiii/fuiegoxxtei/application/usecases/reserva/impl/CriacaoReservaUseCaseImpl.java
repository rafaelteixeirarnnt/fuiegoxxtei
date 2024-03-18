package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.reserva.impl;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.reserva.CriacaoReservaGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.reserva.CriacaoReservaUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Reserva;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.reserva.request.CriacaoReservaRequestDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.reserva.response.CriacaoReservaResponseDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.reserva.CriacaoReservaMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriacaoReservaUseCaseImpl implements CriacaoReservaUseCase {

    private final CriacaoReservaMapper mapper;
    private final CriacaoReservaGateway criacaoReservaRepositoryGateway;
    @Override
    public CriacaoReservaResponseDTO salvar(CriacaoReservaRequestDTO request) {
        Reserva reservaDb = this.criacaoReservaRepositoryGateway.salvar(this.mapper.criacaoRestauranteToRestaurante(request));
        return new CriacaoReservaResponseDTO(reservaDb.getId());
    }
}
