package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Data
@Document(collection = "db_restaurantes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestauranteEntity {

    @Id
    private String id;
    private String cnpj;
    private String nomeEstabelecimento;
    private String tipoCozinha;
    private String tipoCozinhaDescricao;
    private LocalTime hrInicioAtendimento;
    private LocalTime hrFimAtendimento;
    private Integer capacidade;
    private String email;
    private String telefone;

    @DBRef
    private UsuarioEntity usuario;

    @DBRef
    private EnderecoEntity endereco;
}
