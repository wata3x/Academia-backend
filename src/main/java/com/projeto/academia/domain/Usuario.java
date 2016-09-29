package com.projeto.academia.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wata on 21/09/2016.
 */

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome", unique = false)
    private String nome;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password", unique = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_tipo", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Tipo> tipos;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Dieta> dietas;

    //construtores

    public Usuario() {
    }

    public Usuario(String nome, String username, String email, String password, List<Tipo> tipos, List<Dieta> dietas) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tipos = tipos;
        this.dietas = dietas;
    }

    //getters and setters

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public boolean isNovo() {
        return true;
    }

    public List<Dieta> getDietas() {
        return dietas;
    }

    public void setDietas(List<Dieta> dietas) {
        this.dietas = dietas;
    }
}
