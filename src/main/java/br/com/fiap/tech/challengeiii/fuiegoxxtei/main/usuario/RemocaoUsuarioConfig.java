package br.com.fiap.tech.challengeiii.fuiegoxxtei.main.usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.RemocaoUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.RemoveUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.impl.RemoveUsuarioUseCaseImpl;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.usuario.UsuarioEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.usuario.RemocaoUsuarioRepositoryGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios.RemocaoUsuarioRequestMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RemocaoUsuarioConfig {
   @Bean
   public RemoveUsuarioUseCase removeUsuarioUseCase(RemocaoUsuarioGateway remocaoUsuarioGateway,
                                                    RemocaoUsuarioRequestMapper mapper){
      return new RemoveUsuarioUseCaseImpl(remocaoUsuarioGateway, mapper);
   }

   @Bean
   public RemocaoUsuarioGateway usuarioGateway(UsuarioEntityRepository usuarioEntityRepository,
                                               UsuarioEntityMapper mapper,
                                               EnderecoEntityRepository enderecoEntityRepository){
      return new RemocaoUsuarioRepositoryGateway(usuarioEntityRepository, mapper, enderecoEntityRepository);
   }
}
