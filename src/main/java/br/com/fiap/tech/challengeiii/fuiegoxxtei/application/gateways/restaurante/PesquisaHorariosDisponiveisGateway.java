package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.PesquisaHorariosDisponiveisResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface PesquisaHorariosDisponiveisGateway {

    List<PesquisaHorariosDisponiveisResponseDTO> obterHorariosDisponiveis(String idRestaurante, LocalDate data);
}
