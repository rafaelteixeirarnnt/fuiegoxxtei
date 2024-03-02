package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.controller.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.CriacaoRestauranteResponse;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request.CriacaoRestauranteRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurantes")
@Tag(name = "2 - Restaurantes", description = "Serviços disponíveis para gerenciamento de restaurantes.")
public class RestauranteController {

    @PostMapping
    @Operation(summary = "Serviço responsável por cadastrar restaurantes.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Restaurante cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Falha no cadastro de restaurante"),
    })
    public ResponseEntity<CriacaoRestauranteResponse> salvar(@RequestBody @Valid CriacaoRestauranteRequest request) {
        return ResponseEntity.ok().build();
    }

}
