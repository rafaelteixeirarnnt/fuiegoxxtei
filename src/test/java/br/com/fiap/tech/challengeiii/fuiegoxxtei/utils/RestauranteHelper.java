package br.com.fiap.tech.challengeiii.fuiegoxxtei.utils;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Endereco;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Restaurante;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.EnderecoEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.RestauranteEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.UsuarioEntity;

import java.time.LocalDate;
import java.time.LocalTime;

import static br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.enums.TipoCozinhaEnum.ITALIANA;

public abstract class RestauranteHelper {
   public static RestauranteEntity gerarRestaurante() {
      return RestauranteEntity.builder()
              .id("564565")
              .nomeEstabelecimento("Napoli")
              .cnpj("11.111.111/1111-11")
              .tipoCozinha(ITALIANA.getDescricao())
              .hrInicioAtendimento(LocalTime.of(18, 00, 00))
              .hrFimAtendimento(LocalTime.of(23, 59, 59))
              .capacidade(120)
              .email("pizza.napoli@restaurante.com")
              .telefone("3333-3333")
              .usuario(UsuarioEntity.builder().build())
              .endereco(EnderecoHelper.gerarEnderecoRestaurante())
              .build();
   }
}
