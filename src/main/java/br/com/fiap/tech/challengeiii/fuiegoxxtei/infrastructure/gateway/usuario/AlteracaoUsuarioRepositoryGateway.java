package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.usuario.AlteracaoUsuarioGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.UsuarioEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.EnderecoEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.UsuarioEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlteracaoUsuarioRepositoryGateway implements AlteracaoUsuarioGateway {

    private final UsuarioEntityMapper mapper;
    private final UsuarioEntityRepository repository;
    private final EnderecoEntityRepository enderecoEntityRepository;

    @Override
    public Usuario alterar(Usuario entity) {

        var usuario = this.mapper.usuarioEntity(entity);

        var usuarioBD = this.repository.findById(usuario.getId()).orElseThrow(RuntimeException::new);

        usuarioBD.setNome(usuario.getNome());
        usuarioBD.setEmail(usuario.getEmail());
        usuarioBD.setSituacao(usuario.getResponsavelRestaurante());
        usuarioBD.setTelefone(usuario.getTelefone());
        usuarioBD.setResponsavelRestaurante(usuario.getResponsavelRestaurante());
        usuarioBD.setEndereco(this.enderecoEntityRepository.save(alterarDadosEndereco(usuarioBD, usuario)));

        return this.mapper.usuario(this.repository.save(usuarioBD));
    }

    private EnderecoEntity alterarDadosEndereco(UsuarioEntity usuarioBD, UsuarioEntity usuario) {
        var enderecoBD = this.enderecoEntityRepository.findById(usuarioBD.getEndereco().getId()).orElseThrow(RuntimeException::new);
        enderecoBD.setCep(usuario.getEndereco().getCep());
        enderecoBD.setLogradouro(usuario.getEndereco().getLogradouro());
        enderecoBD.setComplemento(usuario.getEndereco().getComplemento());
        enderecoBD.setNumero(usuario.getEndereco().getNumero());
        return enderecoBD;
    }
}
