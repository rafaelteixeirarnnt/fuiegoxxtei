package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.UsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.UsuarioEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsuarioRepositoryGateway implements UsuarioGateway {

    private final UsuarioEntityRepository repository;
    private final UsuarioEntityMapper mapper;

    @Override
    public Usuario salvar(Usuario usuario) {
        var entity = this.mapper.usuarioEntity(usuario);
        return this.mapper.usuario(this.repository.save(entity));
    }

//    @Override
//    public Usuario atualizar(Usuario entity) {
//        return null;
//    }
//
//    @Override
//    public boolean deletar(Usuario entity) {
//        return false;
//    }
//
//    @Override
//    public Usuario obterPorId(Usuario entity) {
//        return null;
//    }
}
