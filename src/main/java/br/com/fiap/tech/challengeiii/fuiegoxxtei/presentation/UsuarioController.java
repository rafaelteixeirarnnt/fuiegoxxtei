package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.AlteraUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.CriaUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.request.AlteracaoUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.request.CriacaoUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.response.CriacaoUsuarioResponse;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.CriacaoUsuarioResponseMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
@Tag(name = "1 - Usuários", description = "Serviços disponíveis para gerenciamento de usuários.")
public class UsuarioController {

    private final CriaUsuarioUseCase criaUsuarioUseCase;
    private final AlteraUsuarioUseCase alteraUsuarioUseCase;
    private final CriacaoUsuarioResponseMapper mapper;

    @PostMapping
    @Operation(summary = "Serviço responsável por cadastrar usuários.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Falha no cadastro de usuário"),
    })
    public ResponseEntity<CriacaoUsuarioResponse> salvar(@RequestBody @Valid CriacaoUsuarioRequest request) {
        var usuario = this.criaUsuarioUseCase.salvar(request);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(this.mapper.usuarioToCriacaoUsuarioResponse(usuario)).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    @Operation(summary = "Serviço responsável por cadastrar usuários.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Falha no cadastro de usuário"),
    })
    public ResponseEntity<Void> alterar(@RequestBody @Valid AlteracaoUsuarioRequest request) {
        this.alteraUsuarioUseCase.alterar(request);
        return ResponseEntity.ok().build();
    }
}
