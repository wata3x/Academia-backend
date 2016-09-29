package com.projeto.academia.domain;

/**
 * Created by wata on 22/09/2016.
 */
public class DetalhesErro {

    private String titulo;

    private Long status;

    private Long timestamp;

    //getters and setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
