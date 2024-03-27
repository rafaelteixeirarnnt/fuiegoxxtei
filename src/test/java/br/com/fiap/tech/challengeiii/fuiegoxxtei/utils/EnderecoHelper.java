package br.com.fiap.tech.challengeiii.fuiegoxxtei.utils;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.EnderecoEntity;

public abstract class EnderecoHelper {
   public static EnderecoEntity gerarEnderecoRestaurante() {
      return EnderecoEntity.builder()
              .id("123345")
              .cep("20000-000")
              .logradouro("rua alternativa")
              .numero("999")
              .complemento("loja 1")
              .build();
   }

   public static EnderecoEntity gerarEnderecoUsuario() {
      return EnderecoEntity.builder()
              .id("987654")
              .cep("30000-000")
              .logradouro("rua principal")
              .numero("155")
              .complemento("n/a")
              .build();
   }
}
