package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante.PesquisaRestauranteGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Restaurante;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.restaurante.RestauranteEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.RestauranteEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.PesquisaRestauranteResponseDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.enums.TipoCozinhaEnum;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.restaurantes.PesquisaRestauranteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;

@RequiredArgsConstructor
public class PesquisaRestauranteRepositoryGateway implements PesquisaRestauranteGateway {

    private final EnderecoEntityRepository enderecoEntityRepository;
    private final RestauranteEntityRepository repository;
    private final RestauranteEntityMapper mapper;
    private final PesquisaRestauranteMapper pesquisaRestauranteMapper;
    private final MongoTemplate mongoTemplate;

    @Override
    public Page<PesquisaRestauranteResponseDTO> pesquisar(String nome, TipoCozinhaEnum tipoCozinha, String cep,
                                                          String logradouro, int pagina, int tamanhoPagina) {

        Criteria criteriaForRestaurante = new Criteria();
        if (nome != null && !nome.isEmpty()) {
            criteriaForRestaurante.and("nomeEstabelecimento").regex(nome, "i");
        }
        if (tipoCozinha != null) {
            criteriaForRestaurante.and("tipoCozinha").is(tipoCozinha.getDescricao());
        }

        MatchOperation initialMatchOperation = Aggregation.match(criteriaForRestaurante);

        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("db_enderecos")
                .localField("endereco")
                .foreignField("_id")
                .as("enderecos");

        Criteria criteriaForEndereco = new Criteria();

        if (cep != null && !cep.isEmpty()) {
            criteriaForEndereco.and("enderecos.cep").is(cep);
        }
        if (logradouro != null && !logradouro.isEmpty()) {
            criteriaForEndereco.and("enderecos.logradouro").regex(logradouro, "i");
        }

        MatchOperation finalMatchOperation = Aggregation.match(criteriaForEndereco);

        Aggregation aggregation = Aggregation.newAggregation(
                initialMatchOperation,
                lookupOperation,
                finalMatchOperation
        );

        var results = mongoTemplate.aggregate(aggregation, "db_restaurantes", Restaurante.class);
        var restaurantes = results.getMappedResults().stream()
                .map(restaurante -> {
                    PesquisaRestauranteResponseDTO pesquisaRestauranteResponseDTO = this.pesquisaRestauranteMapper.restauranteToPesquisaRestauranteDTO(restaurante);
                    pesquisaRestauranteResponseDTO.setTipoCozinha(TipoCozinhaEnum.obterPorDescricao(restaurante.getTipoCozinha()));
                    return pesquisaRestauranteResponseDTO;
                }).toList();

        return new PageImpl<>(restaurantes, PageRequest.of(pagina, tamanhoPagina), results.getMappedResults().size());
    }
}
