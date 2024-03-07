package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.restaurante;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways.restaurante.CriacaoRestauranteGateway;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Restaurante;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.exceptions.ApplicationException;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.gateway.mapper.restaurante.RestauranteEntityMapper;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.UsuarioEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.EnderecoEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.RestauranteEntityRepository;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository.UsuarioEntityRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriacaoRestauranteRepositoryGateway implements CriacaoRestauranteGateway {

    private final UsuarioEntityRepository usuarioEntityRepository;
    private final EnderecoEntityRepository enderecoEntityRepository;
    private final RestauranteEntityRepository repository;
    private final RestauranteEntityMapper mapper;

    @Override
    public Restaurante salvar(Restaurante restaurante) {

        var usuario = this.usuarioEntityRepository.findById(restaurante.getUsuario().getId()).
                orElseThrow(() -> new ApplicationException("Registro não localizado"));

        validarSeUsuarioPodeSerResponsavelPorRestaurante(usuario);
        validarSeRestauranteJahExiste(restaurante);

        var entity = this.mapper.restauranteToRestaurante(restaurante);

        var endereco = this.enderecoEntityRepository.save(entity.getEndereco());

        entity.setEndereco(endereco);
        entity.setUsuario(usuario);

        return this.mapper.entityToRestaurante(this.repository.save(entity));
    }

    private void validarSeUsuarioPodeSerResponsavelPorRestaurante(UsuarioEntity usuario) {
        if (!usuario.getResponsavelRestaurante()) {
            throw new ApplicationException("Usuário não pode ser responsável pelo restaurante");
        }
    }

    private void validarSeRestauranteJahExiste(Restaurante entity) {
        var restauranteOptinal = this.repository.findByCnpj(entity.getCnpj());

        if (restauranteOptinal.isPresent()) {
            throw new ApplicationException("Restaurante já cadastrado");
        }
    }
}
