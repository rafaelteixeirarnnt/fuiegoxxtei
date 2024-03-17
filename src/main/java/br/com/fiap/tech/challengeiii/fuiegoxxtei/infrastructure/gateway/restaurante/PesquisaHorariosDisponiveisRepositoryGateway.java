package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante.PesquisaHorariosDisponiveisGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.HorarioDisponivelEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.ReservaEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.HorariosDisponiveisRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.ReservaEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.RestauranteEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.PesquisaHorariosDisponiveisResponseDTO;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PesquisaHorariosDisponiveisRepositoryGateway implements PesquisaHorariosDisponiveisGateway {

    private final HorariosDisponiveisRepository repository;
    private final ReservaEntityRepository reservaEntityRepository;
    private final RestauranteEntityRepository restauranteEntityRepository;

    @Override
    public List<PesquisaHorariosDisponiveisResponseDTO> obterHorariosDisponiveis(String idRestaurante, LocalDate data) {

        var horariosRestaurante = this.repository.findByRestaurante_Id(idRestaurante);
        var reservas = this.reservaEntityRepository.findByRestaurante_IdAndData(idRestaurante, data);
        var restaurante = this.restauranteEntityRepository.findById(idRestaurante).orElseThrow(RuntimeException::new);
        List<PesquisaHorariosDisponiveisResponseDTO> horariosDisponiveis = new ArrayList<>();

        if (Objects.nonNull(reservas) && !reservas.isEmpty()) {
            List<HorarioDisponivelEntity> horariosReservados = reservas.stream().map(ReservaEntity::getHorarioDisponivel).toList();
            List<HorarioDisponivelEntity> listaCombinada = new ArrayList<>(horariosRestaurante);

            listaCombinada.addAll(horariosReservados);

            Map<LocalTime, List<HorarioDisponivelEntity>> reservasPorHorario = listaCombinada.stream()
                    .collect(Collectors.groupingBy(HorarioDisponivelEntity::getHorario));

            List<LocalTime> horariosParaRemover = reservasPorHorario.entrySet().stream()
                    .filter(entry -> entry.getValue().size() == restaurante.getCapacidade())
                    .flatMap(entry -> {
                        LocalTime horario = entry.getKey();
                        List<LocalTime> horariosAfetados = new ArrayList<>();
                        horariosAfetados.add(horario);
                        horariosAfetados.add(horario.minusHours(2));
                        horariosAfetados.add(horario.plusHours(2));
                        return horariosAfetados.stream();
                    })
                    .distinct()
                    .toList();

            List<HorarioDisponivelEntity> listaFiltrada = listaCombinada.stream()
                    .filter(reserva -> !horariosParaRemover.contains(reserva.getHorario()))
                    .toList();
        } else {
            Map<LocalTime, List<HorarioDisponivelEntity>> horariosDisponiveisMap = horariosRestaurante.stream()
                    .collect(Collectors.groupingBy(HorarioDisponivelEntity::getHorario));

            horariosDisponiveisMap.forEach((horarios, horarioDisponivelEntities) -> horariosDisponiveis.add(new PesquisaHorariosDisponiveisResponseDTO(idRestaurante, data, horarios)));
        }
        horariosDisponiveis.sort(Comparator.comparing(PesquisaHorariosDisponiveisResponseDTO::getHorarioDisponivel));
        return horariosDisponiveis;
    }
}
