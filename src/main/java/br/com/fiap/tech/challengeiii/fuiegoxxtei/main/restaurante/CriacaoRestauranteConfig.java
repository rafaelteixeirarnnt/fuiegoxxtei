package br.com.fiap.tech.challengeiii.fuiegoxxtei.main.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante.CriacaoRestauranteGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.CriacaoRestauranteUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.impl.CriacaoRestauranteUseCaseImpl;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.restaurante.RestauranteEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.restaurante.CriacaoRestauranteRepositoryGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.RestauranteEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.restaurantes.CriacaoRestauranteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CriacaoRestauranteConfig {

    @Bean
    public CriacaoRestauranteUseCase criacaoRestauranteUseCase(CriacaoRestauranteGateway gateway, CriacaoRestauranteMapper mapper) {
        return new CriacaoRestauranteUseCaseImpl(gateway, mapper);
    }

    @Bean
    public CriacaoRestauranteGateway criacaoRestauranteGateway(UsuarioEntityRepository usuarioEntityRepository, EnderecoEntityRepository enderecoEntityRepository,
                                                               RestauranteEntityRepository repository, RestauranteEntityMapper mapper) {
        return new CriacaoRestauranteRepositoryGateway(usuarioEntityRepository, enderecoEntityRepository, repository, mapper);
    }

}
