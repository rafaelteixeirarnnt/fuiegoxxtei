package br.com.fiap.tech.challengeiii.fuiegoxxtei.main.usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.AlteracaoUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.AlteraUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.impl.AlteraUsuarioUseCaseImpl;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.UsuarioEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.usuario.AlteracaoUsuarioRepositoryGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios.AlteracaoUsuarioRequestMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios.AlteracaoUsuarioResponseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlteracaoUsuarioConfig {

    @Bean
    public AlteraUsuarioUseCase alteraUsuarioUseCase(AlteracaoUsuarioGateway gateway,
                                                     AlteracaoUsuarioRequestMapper mapper,
                                                     AlteracaoUsuarioResponseMapper alteracaoUsuarioResponseMapper) {
        return new AlteraUsuarioUseCaseImpl(gateway, mapper, alteracaoUsuarioResponseMapper);
    }

    @Bean
    public AlteracaoUsuarioGateway alteracaoUsuarioGateway(UsuarioEntityMapper mapper, UsuarioEntityRepository usuarioEntityRepository,
                                                           EnderecoEntityRepository enderecoEntityRepository) {
        return new AlteracaoUsuarioRepositoryGateway(mapper, usuarioEntityRepository, enderecoEntityRepository);
    }
}
