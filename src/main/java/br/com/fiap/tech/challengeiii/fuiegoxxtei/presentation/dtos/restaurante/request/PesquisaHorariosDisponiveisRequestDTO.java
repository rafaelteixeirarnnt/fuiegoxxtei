package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class PesquisaHorariosDisponiveisRequestDTO {

    @NotNull
    @NotBlank
    @NotEmpty
    private String idRestaurante;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(description = "Data selecionada para verificar disponibilidade",
            type = "string", example = "2024-03-31",
            name = "data", defaultValue = "2024-03-31")
    private LocalDate data;
}
