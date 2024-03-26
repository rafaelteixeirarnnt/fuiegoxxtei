package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.reserva;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Reserva;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.reserva.request.CriacaoReservaRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CriacaoReservaMapper {

    @Mapping(target = "restaurante.id", source = "idRestaurante")
    @Mapping(target = "usuario.id", source = "idUsuario")
    @Mapping(target = "horario", source = "horario")
    @Mapping(target = "data", source = "data")
    Reserva criacaoRestauranteToRestaurante(CriacaoReservaRequestDTO request);

}
