package br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControleGlobalExceptionHandle {

    @ExceptionHandler(RegistroJaSalvoException.class)
    public ResponseEntity<ErrorResponse> handleException(RegistroJaSalvoException e, HttpServletRequest request) {
        var erro = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

}
