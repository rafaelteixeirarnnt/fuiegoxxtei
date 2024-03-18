package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.reserva;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.reserva.CriacaoReservaGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Reserva;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.reserva.ReservaEntityMapper;
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
        List<ReservaEntity> reservas = this.repository.findByHorarioDisponivel_HorarioAndData(reserva.getHorario(), reserva.getData());
        if (Objects.isNull(reservas) || reservas.isEmpty()) {
            var horarioDisponivel = horariosDisponiveisRepository.findByRestaurante_IdAndHorario(reserva.getRestaurante().getId(), reserva.getHorario()).stream().findFirst().orElse(null);
            var usuario = this.usuarioEntityRepository.findById(reserva.getUsuario().getId()).orElseThrow(RuntimeException::new);
            var restaurante = this.restauranteEntityRepository.findById(reserva.getRestaurante().getId()).orElseThrow(RuntimeException::new);

            var entity = new ReservaEntity(horarioDisponivel, restaurante, usuario, reserva.getData(), "ABERTA");

            return this.mapper.reservaEntityToReserva(this.repository.save(entity));
        }
        return null;
    }

}
