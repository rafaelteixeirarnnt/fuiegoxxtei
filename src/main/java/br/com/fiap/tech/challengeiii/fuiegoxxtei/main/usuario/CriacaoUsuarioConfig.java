package br.com.fiap.tech.challengeiii.fuiegoxxtei.main.usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.CriacaoUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.CriaUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.impl.CriaUsuarioUseCaseImpl;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.usuario.CriacaoUsuarioRepositoryGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.CriacaoUsuarioRequestMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.UsuarioEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CriacaoUsuarioConfig {

    @Bean
    public CriaUsuarioUseCase criaUsuarioUseCase(CriacaoUsuarioGateway criacaoUsuarioGateway, CriacaoUsuarioRequestMapper mapper) {
        return new CriaUsuarioUseCaseImpl(criacaoUsuarioGateway, mapper);
    }

    @Bean
    public CriacaoUsuarioGateway usuarioGateway(UsuarioEntityRepository usuarioEntityRepository, UsuarioEntityMapper mapper,
                                                EnderecoEntityRepository enderecoEntityRepository) {
        return new CriacaoUsuarioRepositoryGateway(usuarioEntityRepository, mapper, enderecoEntityRepository);
    }

}
