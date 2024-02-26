package br.com.fiap.tech.challengeiii.fuiegoxxtei.main;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.UsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.CriaUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.impl.CriaUsuarioUseCaseImpl;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.UsuarioRepositoryGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.CriacaoUsuarioRequestMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.UsuarioEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public CriaUsuarioUseCase criaUsuarioUseCase(UsuarioGateway usuarioGateway, CriacaoUsuarioRequestMapper mapper) {
        return new CriaUsuarioUseCaseImpl(usuarioGateway, mapper);
    }

    @Bean
    public UsuarioGateway usuarioGateway(UsuarioEntityRepository usuarioEntityRepository, UsuarioEntityMapper mapper,
                                         EnderecoEntityRepository enderecoEntityRepository) {
        return new UsuarioRepositoryGateway(usuarioEntityRepository, mapper, enderecoEntityRepository);
    }

}
