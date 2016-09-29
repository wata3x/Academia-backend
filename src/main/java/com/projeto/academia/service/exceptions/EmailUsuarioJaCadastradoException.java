package com.projeto.academia.service.exceptions;

/**
 * Created by wata on 23/09/2016.
 */
public class EmailUsuarioJaCadastradoException extends RuntimeException {

    public EmailUsuarioJaCadastradoException(String mensagem) {
        super(mensagem);
    }
}
