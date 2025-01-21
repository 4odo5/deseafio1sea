package com.amd.desafio1.configurations;

import com.amd.desafio1.errors.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControleExceptions {

    Logger logger = LoggerFactory.getLogger(ControleExceptions.class);

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(Exception e) {
        logger.error("Erro: Requisição não atende aos padrões exigidos.", e);
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ErrorResponse(status, "Requisição não atende aos padrões exigidos"), status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleArgumentoInvalido(Exception e) {
        logger.error("Erro: Parametros inválidos.", e);
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, "Requisição não atende aos padrões exigidos"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenerics(Exception e) {
        logger.error("Erro: Requisição não atende aos padrões exigidos.", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST, "Requisição não atende aos padrões exigidos"));
    }

}
