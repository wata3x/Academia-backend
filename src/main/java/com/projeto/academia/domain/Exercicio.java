package com.projeto.academia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by wata on 21/09/2016.
 */

@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome", unique = true)
    private String nome;
    @Column(name = "descricao", unique = false)
    private String descricao;
    @Column(name = "imagem", unique = false)
    private String imagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    @JsonIgnore
    private Categoria categoria;

    //Construtores

    public Exercicio() {
    }

    public Exercicio(String nome, String descricao, String imagem, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.categoria = categoria;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
