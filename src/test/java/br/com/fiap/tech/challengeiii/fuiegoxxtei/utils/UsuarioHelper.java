package br.com.fiap.tech.challengeiii.fuiegoxxtei.utils;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Endereco;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.entity.Usuario;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.UsuarioEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.CriacaoUsuarioRequest;

import java.time.LocalDate;

public abstract class UsuarioHelper {
   public static UsuarioEntity gerarUsuario(){
      return UsuarioEntity.builder()
              .id("123456")
              .cpf("12345678910")
              .nome("Albert")
              .dtNascimento(LocalDate.of(1879, 3, 14))
              .telefone("99999-9999")
              .responsavelRestaurante(true)
              .email("albert@relativity.com")
              .situacao(true)
              .endereco(EnderecoHelper.gerarEnderecoUsuario())
              .build();
   }

   public static CriacaoUsuarioRequest gerarUsuarioCtrl(){
      return CriacaoUsuarioRequest.builder()
              .cpf("12345678910")
              .nome("Albert")
              .dtNascimento(LocalDate.of(1879, 3, 14))
              .telefone("99999-9999")
              .responsavelRestaurante(true)
              .email("albert@relativity.com")
              .cep("40000000")
              .numero("23")
              .complemento("")
              .build();
   }
}
