package com.projeto.academia.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wata on 21/09/2016.
 */

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome", unique = true)
    private String nome;
    @Column(name = "imagem", unique = false)
    private String imagem;

    @OneToMany(mappedBy = "categoria")
    private List<Exercicio> exercicios;

    //Construtores

    public Categoria() {
    }

    public Categoria(Long id, String nome, String imagem, List<Exercicio> exercicios) {
        this.id = id;
        this.nome = nome;
        this.imagem = imagem;
        this.exercicios = exercicios;
    }

    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }
}
