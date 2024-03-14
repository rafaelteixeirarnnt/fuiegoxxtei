package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.restaurante.request;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.enums.TipoCozinhaEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PesquisaRestauranteRequestDTO {

    @NotBlank
    private String nome;

    @Schema(name = "tipoCozinha", type = "string", description = "Tipos de cozinha que o sistema permite atualmente", example = "BRASILEIRA ou ITALIANA ou ARABE ou JAPONESA ou VEGETARIANA")
    private TipoCozinhaEnum tipoCozinha;

    @NotNull
    @Length(min = 8, max = 8)
    @Schema(name = "cep", description = "Cep do restaurante", type = "string", example = "48370000")
    private String cep;

    private String logradouro;

    private int pagina = 0;
    private int tamanhoPagina = 10;

}
