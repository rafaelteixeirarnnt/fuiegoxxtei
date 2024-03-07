package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
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
public class RestauranteEntity {

    @Id
    private String id;
    private String cnpj;
    private String nomeEstabelecimento;
    private String tipoCozinha;
    private LocalTime horaInicioFuncionamento;
    private LocalTime horaFimFuncionamento;
    private Integer capacidade;

    @DBRef
    private UsuarioEntity usuario;

    @DBRef
    private EnderecoEntity endereco;
}
