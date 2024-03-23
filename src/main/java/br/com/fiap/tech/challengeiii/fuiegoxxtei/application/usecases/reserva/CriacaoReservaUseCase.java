package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.reserva;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.reserva.request.CriacaoReservaRequestDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.reserva.response.CriacaoReservaResponseDTO;

public interface CriacaoReservaUseCase {

    CriacaoReservaResponseDTO salvar(CriacaoReservaRequestDTO request);

}
