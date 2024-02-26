package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.UsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.UsuarioEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class UsuarioRepositoryGateway implements UsuarioGateway {

    private final UsuarioEntityRepository repository;
    private final UsuarioEntityMapper mapper;
    private final EnderecoEntityRepository enderecoEntityRepository;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        var entity = this.mapper.usuarioEntity(usuario);
        var endereco = this.enderecoEntityRepository.save(entity.getEndereco());
        entity.setSituacao(Boolean.TRUE);
        entity.setEndereco(endereco);
        return this.mapper.usuario(this.repository.save(entity));
    }
}
