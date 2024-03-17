package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "db_reservas")
public class ReservaEntity {

    @Id
    private String id;

    @DBRef
    private HorarioDisponivelEntity horarioDisponivel;

    @DBRef
    private RestauranteEntity restaurante;

    @DBRef
    private UsuarioEntity usuarioEntity;

    private LocalDate data;

    private String situacao;

}
