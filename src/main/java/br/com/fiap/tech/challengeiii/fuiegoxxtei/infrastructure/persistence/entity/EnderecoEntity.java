package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "db_enderecos")
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {

    @Id
    private String id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;


}
