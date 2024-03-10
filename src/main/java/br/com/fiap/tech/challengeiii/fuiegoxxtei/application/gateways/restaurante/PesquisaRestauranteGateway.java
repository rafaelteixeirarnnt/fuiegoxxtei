package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Restaurante;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.enums.TipoCozinhaEnum;
import org.springframework.data.domain.Page;

public interface PesquisaRestauranteGateway {

    Page<Restaurante> pesquisar(String nome, TipoCozinhaEnum tipoCozinha, String cep, String logradouro, int pagina, int tamanhoPagina);

}
