package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.controller.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.CriacaoRestauranteUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.restaurantes.PesquisaRestaurantesUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.CriacaoRestauranteRequestDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.PesquisaRestauranteRequestDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.CriacaoRestauranteResponseDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.PesquisaRestauranteResponseDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.ReservaRestauranteResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurantes")
@Tag(name = "2 - Restaurantes", description = "Serviços disponíveis para gerenciamento de restaurantes.")
public class RestauranteController {

    private final CriacaoRestauranteUseCase criacaoRestauranteUseCase;
    private final PesquisaRestaurantesUseCase pesquisaRestaurantesUseCase;

    @PostMapping
    @Operation(summary = "Serviço responsável por cadastrar restaurantes.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Restaurante cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Falha no cadastro de restaurante"),
    })
    public ResponseEntity<CriacaoRestauranteResponseDTO> salvar(@RequestBody @Valid CriacaoRestauranteRequestDTO request) {
        CriacaoRestauranteResponseDTO response = this.criacaoRestauranteUseCase.salvar(request);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                  .path("/{id}")
                                                  .buildAndExpand(response.id())
                                                  .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @Operation(summary = "Serviço responsável por buscar os restaurantes.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pesquisa realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Falha no cadastro de restaurante"),
    })
    public Page<PesquisaRestauranteResponseDTO> pesquisar(PesquisaRestauranteRequestDTO request) {
        return this.pesquisaRestaurantesUseCase.pesquisar(request);
    }

    @PostMapping("/reservar")
    @Operation(summary = "Serviço responsável por reservas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mesa cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Falha ao tentar reservar mesa"),
    })
    public ResponseEntity<ReservaRestauranteResponseDTO> reservar(@RequestBody @Valid CriacaoRestauranteRequestDTO request) {
        CriacaoRestauranteResponseDTO response = this.criacaoRestauranteUseCase.salvar(request);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
