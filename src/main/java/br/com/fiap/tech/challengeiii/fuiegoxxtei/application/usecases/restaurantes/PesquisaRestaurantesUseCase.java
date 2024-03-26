package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.PesquisaRestauranteRequestDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.PesquisaRestauranteResponseDTO;
import org.springframework.data.domain.Page;

public interface PesquisaRestaurantesUseCase {

    Page<PesquisaRestauranteResponseDTO> pesquisar(PesquisaRestauranteRequestDTO request);

}
