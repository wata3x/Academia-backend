package com.projeto.academia.service.exceptions;

/**
 * Created by wata on 21/09/2016.
 */
public class CategoriaNaoEncontradaException extends RuntimeException {

    public CategoriaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CategoriaNaoEncontradaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
