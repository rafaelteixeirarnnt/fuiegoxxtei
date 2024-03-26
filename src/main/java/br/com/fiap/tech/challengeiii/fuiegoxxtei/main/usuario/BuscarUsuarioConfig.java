package br.com.fiap.tech.challengeiii.fuiegoxxtei.main.usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.BuscarUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.RemocaoUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.BuscaUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.impl.BuscaUsuarioUseCaseImpl;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.usuario.UsuarioEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.usuario.BuscarUsuarioRepositoryGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios.BuscarUsuarioRequestMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.mapper.usuarios.RemocaoUsuarioRequestMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarUsuarioConfig {
   @Bean
   public BuscaUsuarioUseCase buscaUsuarioUseCase(BuscarUsuarioGateway buscarUsuarioGateway, BuscarUsuarioRequestMapper buscarUsuarioRequestMapper){
      return new BuscaUsuarioUseCaseImpl((RemocaoUsuarioGateway) buscarUsuarioGateway, (RemocaoUsuarioRequestMapper) buscarUsuarioRequestMapper);
   }

   @Bean
   public BuscarUsuarioGateway usuarioGateway(UsuarioEntityRepository usuarioEntityRepository,
                                              UsuarioEntityMapper mapper,
                                              EnderecoEntityRepository enderecoEntityRepository){
      return new BuscarUsuarioRepositoryGateway(usuarioEntityRepository, mapper, enderecoEntityRepository);
   }
}
