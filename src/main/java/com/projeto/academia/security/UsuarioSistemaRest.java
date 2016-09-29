package com.projeto.academia.security;

import com.projeto.academia.domain.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by wata on 21/09/2016.
 */

public class UsuarioSistemaRest extends User {

    private Usuario usuario;

    public UsuarioSistemaRest(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getEmail(), usuario.getPassword(), authorities);
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}
