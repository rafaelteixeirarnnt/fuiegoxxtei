package br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.enums;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.exceptions.ApplicationException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum TipoCozinhaEnum {

    BRASILEIRA("Brasileira"),
    ITALIANA("Italiana"),
    ARABE("Árabe"),
    JAPONESA("Japonesa"),
    VEGETARIANA("Vegetariana");

    private String descricao;

    public TipoCozinhaEnum obterPorDescricao(String descricao) {
        return Arrays.stream(TipoCozinhaEnum.values())
                .filter(tipoCozinhaEnum -> tipoCozinhaEnum.getDescricao().equalsIgnoreCase(descricao))
                .findFirst().orElseThrow(() -> new ApplicationException("Registro não localizado"));
    }

}
