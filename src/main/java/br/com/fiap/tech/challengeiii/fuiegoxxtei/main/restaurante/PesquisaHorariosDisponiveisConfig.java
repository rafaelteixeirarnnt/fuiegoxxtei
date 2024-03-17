package br.com.fiap.tech.challengeiii.fuiegoxxtei.main.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante.PesquisaHorariosDisponiveisGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.PesquisaHorariosDisponiveisUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.impl.PesquisaHorariosDisponiveisUseCaseImpl;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.restaurante.PesquisaHorariosDisponiveisRepositoryGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.HorariosDisponiveisRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.ReservaEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.RestauranteEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PesquisaHorariosDisponiveisConfig {

    @Bean
    public PesquisaHorariosDisponiveisUseCase pesquisaHorariosDisponiveisUseCase(PesquisaHorariosDisponiveisGateway gateway) {
        return new PesquisaHorariosDisponiveisUseCaseImpl(gateway);
    }

    @Bean
    public PesquisaHorariosDisponiveisGateway pesquisaHorariosDisponiveisGateway(HorariosDisponiveisRepository repository, ReservaEntityRepository reservaEntityRepository,
                                                                                 RestauranteEntityRepository restauranteEntityRepository) {
        return new PesquisaHorariosDisponiveisRepositoryGateway(repository, reservaEntityRepository, restauranteEntityRepository);
    }

}
