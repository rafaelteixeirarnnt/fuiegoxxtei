package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PesquisaHorariosDisponiveisResponseDTO {

    private String idRestaurante;
    private LocalDate data;
    private LocalTime horarioDisponivel;

}
