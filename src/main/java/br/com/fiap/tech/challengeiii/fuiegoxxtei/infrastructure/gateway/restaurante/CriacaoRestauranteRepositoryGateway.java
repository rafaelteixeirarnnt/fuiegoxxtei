package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante.CriacaoRestauranteGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Restaurante;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.exceptions.ApplicationException;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.restaurante.RestauranteEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.HorarioDisponiveisEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.RestauranteEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.UsuarioEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.HorariosDisponiveisRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.RestauranteEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CriacaoRestauranteRepositoryGateway implements CriacaoRestauranteGateway {

    private final UsuarioEntityRepository usuarioEntityRepository;
    private final EnderecoEntityRepository enderecoEntityRepository;
    private final RestauranteEntityRepository repository;
    private final RestauranteEntityMapper mapper;
    private final HorariosDisponiveisRepository horariosDisponiveisRepository;

    @Override
    public Restaurante salvar(Restaurante restaurante) {

        var usuario = this.usuarioEntityRepository.findById(restaurante.getUsuario().getId()).
                orElseThrow(() -> new ApplicationException("Registro não localizado"));

        validarSeUsuarioPodeSerResponsavelPorRestaurante(usuario);
        validarSeRestauranteJahExiste(restaurante);

        var entity = this.mapper.restauranteToRestaurante(restaurante);

        var endereco = this.enderecoEntityRepository.save(entity.getEndereco());

        entity.setEndereco(endereco);
        entity.setUsuario(usuario);

        var restauranteDB = this.repository.save(entity);

        var horariosDisponiveis = montarHorariosDisponiveisNoRestaurante(restauranteDB);

        horariosDisponiveisRepository.saveAll(horariosDisponiveis);

        return this.mapper.entityToRestaurante(restauranteDB);
    }

    private List<HorarioDisponiveisEntity> montarHorariosDisponiveisNoRestaurante(RestauranteEntity restauranteDB) {
        calcularDiferencaDeHoras(restauranteDB.getHrInicioAtendimento(), restauranteDB.getHrFimAtendimento());
        List<HorarioDisponiveisEntity> horariosDisponiveis = new ArrayList<>();
        for (int i = 0; i < calcularDiferencaDeHoras(restauranteDB.getHrInicioAtendimento(), restauranteDB.getHrFimAtendimento()); i++) {
            for (int j = 1; j <= restauranteDB.getCapacidade(); j++) {
                var horarioDisponiveis = new HorarioDisponiveisEntity();
                horarioDisponiveis.setMesa(String.format("Mesa %d", j));
                horarioDisponiveis.setHorario(restauranteDB.getHrInicioAtendimento().plusMinutes(i * 30L));
                horariosDisponiveis.add(horarioDisponiveis);
                horarioDisponiveis.setRestaurante(restauranteDB);
            }
        }
        return horariosDisponiveis;
    }

    private void validarSeUsuarioPodeSerResponsavelPorRestaurante(UsuarioEntity usuario) {
        if (!usuario.getResponsavelRestaurante()) {
            throw new ApplicationException("Usuário não pode ser responsável pelo restaurante");
        }
    }

    private void validarSeRestauranteJahExiste(Restaurante entity) {
        var restauranteOptinal = this.repository.findByCnpj(entity.getCnpj());

        if (restauranteOptinal.isPresent()) {
            throw new ApplicationException("Restaurante já cadastrado");
        }
    }


    public int calcularDiferencaDeHoras(LocalTime inicio, LocalTime fim) {
        long minutosTotais = ChronoUnit.MINUTES.between(inicio, fim);

        if (fim.isBefore(inicio)) {
            minutosTotais += 24 * 60;
        }

        return (int) minutosTotais / 60;
    }
}
