package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.CriacaoUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.exceptions.RegistroJaSalvoException;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.usuario.UsuarioEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.UsuarioEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
public class CriacaoUsuarioRepositoryGateway implements CriacaoUsuarioGateway {

    private final UsuarioEntityRepository repository;
    private final UsuarioEntityMapper mapper;
    private final EnderecoEntityRepository enderecoEntityRepository;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        var entity = this.mapper.usuarioEntity(usuario);
        validarSeUsuarioExiste(entity);
        var endereco = this.enderecoEntityRepository.save(entity.getEndereco());
        entity.setSituacao(Boolean.TRUE);
        entity.setEndereco(endereco);
        return this.mapper.usuario(this.repository.save(entity));
    }

    private void validarSeUsuarioExiste(UsuarioEntity entity) {
        Optional<UsuarioEntity> entityOptional = this.repository.findByCpf(entity.getCpf());
        if (entityOptional.isPresent()) {
            throw new RegistroJaSalvoException("Usuário já cadastrado");
        }
    }
}
