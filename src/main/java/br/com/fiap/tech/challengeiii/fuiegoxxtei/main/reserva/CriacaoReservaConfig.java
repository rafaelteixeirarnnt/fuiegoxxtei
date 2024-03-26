package br.com.fiap.tech.challengeiii.fuiegoxxtei.main.reserva;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.reserva.CriacaoReservaGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.reserva.CriacaoReservaUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.reserva.impl.CriacaoReservaUseCaseImpl;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.reserva.ReservaEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.reserva.CriacaoReservaRepositoryGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.HorariosDisponiveisRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.ReservaEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.RestauranteEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.reserva.CriacaoReservaMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CriacaoReservaConfig {

    @Bean
    public CriacaoReservaUseCase criacaoReservaUseCase(CriacaoReservaMapper mapper,  CriacaoReservaGateway gateway) {
        return new CriacaoReservaUseCaseImpl(mapper, gateway);
    }

    @Bean
    public CriacaoReservaGateway criacaoReservaGateway(ReservaEntityMapper mapper,
                                                       ReservaEntityRepository repository,
                                                       UsuarioEntityRepository usuarioEntityRepository,
                                                       RestauranteEntityRepository restauranteEntityRepository,
                                                       HorariosDisponiveisRepository horariosDisponiveisRepository) {
        return new CriacaoReservaRepositoryGateway(mapper, repository, usuarioEntityRepository,
                                                   restauranteEntityRepository, horariosDisponiveisRepository);
    }

}
