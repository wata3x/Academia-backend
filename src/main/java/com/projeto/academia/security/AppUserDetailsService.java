package com.projeto.academia.security;

import com.projeto.academia.domain.Tipo;
import com.projeto.academia.domain.Usuario;
import com.projeto.academia.repository.TiposRepository;
import com.projeto.academia.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by wata on 21/09/2016.
 */

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private TiposRepository tiposRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        /*Optional<Usuario> usuarioOptional = usuariosRepository.findByEmail(email);
        //UsuarioSistemaRest user = null;
        Usuario usuario = usuarioOptional.orElseThrow(()-> new UsernameNotFoundException("usuario ou senha incorretas"));

        return new UsuarioSistemaRest(usuario, getTipos(usuario));*/

        Usuario usuario = usuariosRepository.findByEmail(email);
        UsuarioSistemaRest user = null;
        if ( usuario == null) {
            throw new UsernameNotFoundException("Email ou senha incorretos");
        }

        return new UsuarioSistemaRest(usuario, getTipos(usuario));

    }

    private Collection<? extends GrantedAuthority> getTipos(Usuario usuario) {
        List<SimpleGrantedAuthority> grupos = new ArrayList<>();
        for (Tipo tipo : usuario.getTipos()) {
            grupos.add(new SimpleGrantedAuthority(tipo.getTipo().toUpperCase()));
        }
        return grupos;
    }
}
