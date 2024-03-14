package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.PesquisaRestauranteResponseDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.enums.TipoCozinhaEnum;
import org.springframework.data.domain.Page;

public interface PesquisaRestauranteGateway {

    Page<PesquisaRestauranteResponseDTO> pesquisar(String nome, TipoCozinhaEnum tipoCozinha, String cep, String logradouro, int pagina, int tamanhoPagina);

}
