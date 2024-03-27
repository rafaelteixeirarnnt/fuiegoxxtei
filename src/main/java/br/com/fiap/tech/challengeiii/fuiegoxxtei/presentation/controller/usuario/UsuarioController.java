package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.controller.usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.AlteraUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.BuscaUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.CriaUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.RemoveUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.impl.CriaUsuarioUseCaseImpl;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.AlteracaoUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.BuscarUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.CriacaoUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.response.AlteracaoUsuarioResponse;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.response.BuscarUsuarioResponse;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.response.CriacaoUsuarioResponse;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios.CriacaoUsuarioResponseMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
@Tag(name = "1 - Usuários", description = "Serviços disponíveis para gerenciamento de usuários.")
public class UsuarioController {

    private final CriaUsuarioUseCase criaUsuarioUseCase;
    private final AlteraUsuarioUseCase alteraUsuarioUseCase;
    private final CriacaoUsuarioResponseMapper mapper;
    private final BuscaUsuarioUseCase buscaUsuarioUseCase;
    private final RemoveUsuarioUseCase removeUsuarioUseCase;

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
                .buildAndExpand(this.mapper.usuarioToCriacaoUsuarioResponse(usuario).id()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    @Operation(summary = "Serviço responsável por cadastrar usuários.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Falha no cadastro de usuário"),
    })
    public ResponseEntity<AlteracaoUsuarioResponse> alterar(@RequestBody @Valid AlteracaoUsuarioRequest request) {
        return ResponseEntity.ok(this.alteraUsuarioUseCase.alterar(request));
    }

/*    @GetMapping(value = "/{id}")
    public ResponseEntity<BuscarUsuarioResponse> buscar(@RequestBody @Valid BuscarUsuarioRequest buscarUsuarioRequest){
      try{
         var usr =
      }
      return ResponseEntity.ok(this.buscaUsuarioUseCase.buscar(buscarUsuarioRequest));
    }*/
}
