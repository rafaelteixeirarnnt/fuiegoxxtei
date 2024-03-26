package br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    private String id;

    private LocalTime horario;

    private Restaurante restaurante;

    private Usuario usuario;

    private LocalDate data;

    private String situacao;

}
