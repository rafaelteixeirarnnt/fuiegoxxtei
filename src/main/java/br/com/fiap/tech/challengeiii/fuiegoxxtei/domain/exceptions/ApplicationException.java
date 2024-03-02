package br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.exceptions;

public class ApplicationException extends RuntimeException {

    public ApplicationException(String mensagem) {
        super(mensagem);
    }

    public ApplicationException(String mensagem, Throwable exception) {
        super(mensagem, exception);
    }

}
