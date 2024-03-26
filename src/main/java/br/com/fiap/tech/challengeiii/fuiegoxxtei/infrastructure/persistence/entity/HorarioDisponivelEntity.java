package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Data
@Document(collection = "db_horarios_disponiveis")
@NoArgsConstructor
@AllArgsConstructor
public class HorarioDisponivelEntity {

    @Id
    private String id;
    private String mesa;
    private LocalTime horario;

    @DBRef
    private RestauranteEntity restaurante;

}
