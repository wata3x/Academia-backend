package com.projeto.academia.handler;

import com.projeto.academia.domain.DetalhesErro;
import com.projeto.academia.service.exceptions.CategoriaNaoEncontradaException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Created by wata on 22/09/2016.
 */

@ControllerAdvice
public class ResourceExceptionHandler {

    public ResponseEntity<DetalhesErro> handleCategoriaNaoEncontradaException
                            (CategoriaNaoEncontradaException e , HttpServletRequest request) {

        DetalhesErro erro = new DetalhesErro();
        erro.setStatus(404l);
        erro.setTitulo("A categoria não foi encontrada");
        erro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
