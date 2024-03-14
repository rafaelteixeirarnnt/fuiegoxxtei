package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante.PesquisaRestauranteGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Restaurante;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.restaurante.RestauranteEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.RestauranteEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.RestauranteEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.enums.TipoCozinhaEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;

import java.util.List;

@RequiredArgsConstructor
public class PesquisaRestauranteRepositoryGateway implements PesquisaRestauranteGateway {

    private final EnderecoEntityRepository enderecoEntityRepository;
    private final RestauranteEntityRepository repository;
    private final RestauranteEntityMapper mapper;
    private final MongoTemplate mongoTemplate;

    @Override
    public Page<Restaurante> pesquisar(String nome, TipoCozinhaEnum tipoCozinha, String cep, String logradouro,
                                       int pagina, int tamanhoPagina) {

        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("db_enderecos")
                .localField("endereco")
                .foreignField("_id")
                .as("enderecos");

//        MatchOperation matchOperation = Aggregation.match(Criteria.where("enderecos.cep").is(cep));

        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);

        AggregationResults<RestauranteEntity> results = mongoTemplate.aggregate(aggregation, "db_restaurantes", RestauranteEntity.class);
        List<RestauranteEntity> mappedResults = results.getMappedResults();

        return null;
    }
}
