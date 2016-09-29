package com.projeto.academia.service;

import com.projeto.academia.domain.Tipo;
import com.projeto.academia.domain.Usuario;
import com.projeto.academia.repository.TiposRepository;
import com.projeto.academia.repository.UsuariosRepository;
import com.projeto.academia.service.exceptions.EmailUsuarioJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

/**
 * Created by wata on 21/09/2016.
 */

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private TiposRepository tiposRepository;

    public List<Usuario> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) {
        /*Optional<Usuario> usuarioExistente = usuariosRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new EmailUsuarioJaCadastradoException("Email já cadastrado");
        }
        if (usuario.isNovo()) {
            usuario.setTipos(tiposRepository.findByTipo("ROLE_CLIENTE"));
        }

        return usuariosRepository.save(usuario);*/

        if (emailExistente(usuario.getEmail())) {
            throw new EmailUsuarioJaCadastradoException("Email ja cadastrado.");
        }
        usuario.setTipos(tiposRepository.findByTipo("ROLE_CLIENTE"));
        return usuariosRepository.save(usuario);
    }

    public boolean emailExistente(String email) {
        Usuario usuario = usuariosRepository.findByEmail(email);
        if (usuario != null) {
            return true;
        }
        return false;
    }

}
