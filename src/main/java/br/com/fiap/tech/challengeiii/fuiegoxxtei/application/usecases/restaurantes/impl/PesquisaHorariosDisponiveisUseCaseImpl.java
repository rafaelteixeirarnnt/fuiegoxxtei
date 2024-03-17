package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.impl;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante.PesquisaHorariosDisponiveisGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.PesquisaHorariosDisponiveisUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.PesquisaHorariosDisponiveisRequestDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.PesquisaHorariosDisponiveisResponseDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PesquisaHorariosDisponiveisUseCaseImpl implements PesquisaHorariosDisponiveisUseCase {

    private final PesquisaHorariosDisponiveisGateway gateway;

    @Override
    public List<PesquisaHorariosDisponiveisResponseDTO> obterHorariosDisponiveis(PesquisaHorariosDisponiveisRequestDTO request) {
        return this.gateway.obterHorariosDisponiveis(request.getIdRestaurante(), request.getData());
    }
}
