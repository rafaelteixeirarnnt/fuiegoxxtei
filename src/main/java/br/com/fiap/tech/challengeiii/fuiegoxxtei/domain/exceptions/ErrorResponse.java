package br.com.fiap.tech.challengeiii.fuiegoxxtei.domain.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(int code,
                            String error,
                            String path,
                            LocalDateTime timestamp) {

}
