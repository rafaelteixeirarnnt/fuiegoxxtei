package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.controller.reserva;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.reserva.request.CriacaoReservaRequestDTO;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.response.CriacaoRestauranteResponseDTO;
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
@RequestMapping("/reservas")
@Tag(name = "4 - Reservas", description = "Serviços disponíveis para gerenciamento das reservas.")
public class ReservaController {

    @PostMapping
    @Operation(summary = "Serviço responsável por cadastrar a reserva.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reserva cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Falha no cadastro da reserva"),
    })
    public ResponseEntity<CriacaoRestauranteResponseDTO> salvar(@RequestBody @Valid CriacaoReservaRequestDTO request) {
//        CriacaoRestauranteResponseDTO response = this.criacaoRestauranteUseCase.salvar(request);
//        var location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(response.id())
//                .toUri();
//        return ResponseEntity.created(location).build();
        return ResponseEntity.ok().build();
    }


}
