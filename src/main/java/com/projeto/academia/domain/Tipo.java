package com.projeto.academia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wata on 21/09/2016.
 */

@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "tipo", unique = true)
    private String tipo;


    @ManyToMany(mappedBy = "tipos", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Usuario> usuarios;


    //construtores

    public Tipo() {
    }

    public Tipo(String tipo, List<Usuario> usuarios) {
        this.tipo = tipo;
        this.usuarios = usuarios;
    }

//getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
