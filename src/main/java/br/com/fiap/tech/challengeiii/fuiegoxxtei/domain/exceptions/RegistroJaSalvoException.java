package br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.exceptions;

public class RegistroJaSalvoException extends RuntimeException {

    public RegistroJaSalvoException(String mensagem) {
        super(mensagem);
    }

    public RegistroJaSalvoException(String mensagem, Throwable exception) {
        super(mensagem, exception);
    }

}
