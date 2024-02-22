package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.controllers;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.CriaUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.controllers.dtos.request.CriacaoUsuarioRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final CriaUsuarioUseCase criaUsuarioUseCase;

    @PostMapping
    public String criar(@RequestBody CriacaoUsuarioRequest request) {
        this.criaUsuarioUseCase.salvar(request);
        return "oi";
    }

}
