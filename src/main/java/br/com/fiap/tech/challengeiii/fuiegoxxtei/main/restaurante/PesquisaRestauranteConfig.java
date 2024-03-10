package br.com.fiap.tech.challengeiii.fuiegoxxtei.main.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante.PesquisaRestauranteGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.PesquisaRestaurantesUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.impl.PesquisarRestaurantesUseCaseImpl;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.restaurante.RestauranteEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.restaurante.PesquisaRestauranteRepositoryGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.RestauranteEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class PesquisaRestauranteConfig {

    @Bean
    public PesquisaRestaurantesUseCase pesquisaRestaurantesUseCase(PesquisaRestauranteGateway gateway) {
        return new PesquisarRestaurantesUseCaseImpl(gateway);
    }

    @Bean
    public PesquisaRestauranteGateway pesquisaRestauranteGateway(EnderecoEntityRepository enderecoEntityRepository,
                                                                 RestauranteEntityRepository repository,
                                                                 RestauranteEntityMapper mapper, MongoTemplate mongoTemplate) {
        return new PesquisaRestauranteRepositoryGateway(enderecoEntityRepository, repository, mapper, mongoTemplate);
    }

}
