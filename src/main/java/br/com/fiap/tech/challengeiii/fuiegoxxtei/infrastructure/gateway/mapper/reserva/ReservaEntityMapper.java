package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.reserva;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Reserva;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.ReservaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaEntityMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "horarioDisponivel.horario", source = "horario")
    @Mapping(target = "restaurante.id", source = "restaurante.id")
    @Mapping(target = "usuario.id", source = "usuario.id")
    @Mapping(target = "data", source = "data")
    @Mapping(target = "situacao", source = "situacao")
    ReservaEntity reservaToReservaEntity(Reserva reserva);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "horario", source = "horarioDisponivel.horario")
    @Mapping(target = "restaurante.id", source = "restaurante.id")
    @Mapping(target = "usuario.id", source = "usuario.id")
    @Mapping(target = "data", source = "data")
    @Mapping(target = "situacao", source = "situacao")
    Reserva reservaEntityToReserva(ReservaEntity reservaEntity);

}
