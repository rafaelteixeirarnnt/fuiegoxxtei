package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.reserva;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.reserva.CriacaoReservaGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Reserva;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.exceptions.ApplicationException;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.reserva.ReservaEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.HorarioDisponivelEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.ReservaEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.HorariosDisponiveisRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.ReservaEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.RestauranteEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class CriacaoReservaRepositoryGateway implements CriacaoReservaGateway {

    private final ReservaEntityMapper mapper;
    private final ReservaEntityRepository repository;
    private final UsuarioEntityRepository usuarioEntityRepository;
    private final RestauranteEntityRepository restauranteEntityRepository;
    private final HorariosDisponiveisRepository horariosDisponiveisRepository;

    @Override
    public Reserva salvar(Reserva reserva) {
        var horariosDisponiveisRestaurante = this.horariosDisponiveisRepository.findByRestaurante_Id(reserva.getRestaurante().getId());
        if (horariosDisponiveisRestaurante.isEmpty()) {
            throw new ApplicationException("Horário não localizado");
        }
        var reservas = this.repository.findByRestaurante_IdAndData(reserva.getRestaurante().getId(), reserva.getData());
        var usuario = this.usuarioEntityRepository.findById(reserva.getUsuario().getId()).orElseThrow(RuntimeException::new);
        var restaurante = this.restauranteEntityRepository.findById(reserva.getRestaurante().getId()).orElseThrow(RuntimeException::new);

        if (Objects.isNull(reservas) || reservas.isEmpty()) {
            var horarioDisponivel = horariosDisponiveisRestaurante.stream()
                    .filter(horarioDisponivelEntity -> horarioDisponivelEntity.getHorario().equals(reserva.getHorario()))
                    .findFirst().orElse(null);

            var entity = new ReservaEntity(horarioDisponivel, restaurante, usuario, reserva.getData(), "ABERTA");

            return this.mapper.reservaEntityToReserva(this.repository.save(entity));
        }

        var horariosJahReservados = reservas.stream()
                .filter(reservaEntity -> reservaEntity.getHorarioDisponivel().getHorario().equals(reserva.getHorario()))
                .toList();

        List<HorarioDisponivelEntity> horariosAgrupadosPorHorarioSolicitadoParaReserva = horariosDisponiveisRestaurante.stream()
                .filter(horarioDisponivelEntity -> horarioDisponivelEntity.getHorario().equals(reserva.getHorario()))
                .toList();

        if (horariosJahReservados.size() < horariosAgrupadosPorHorarioSolicitadoParaReserva.size()) {
            if (restaurante.getCapacidade() > horariosJahReservados.size()) {

                var idHorariosReservas = reservas.stream().map(ReservaEntity::getHorarioDisponivel)
                        .map(HorarioDisponivelEntity::getId)
                        .toList();

                var horarioDisponivel = horariosAgrupadosPorHorarioSolicitadoParaReserva.stream().filter(horario -> !idHorariosReservas.contains(horario.getId())).findFirst().orElse(null);

                var entity = new ReservaEntity(horarioDisponivel, restaurante, usuario, reserva.getData(), "ABERTA");

                return this.mapper.reservaEntityToReserva(this.repository.save(entity));
            }
        }

        return null;
    }

}
