package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.PesquisaHorariosDisponiveisRequestDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.PesquisaHorariosDisponiveisResponseDTO;

import java.util.List;

public interface PesquisaHorariosDisponiveisUseCase {

    List<PesquisaHorariosDisponiveisResponseDTO> obterHorariosDisponiveis(PesquisaHorariosDisponiveisRequestDTO request);

}
