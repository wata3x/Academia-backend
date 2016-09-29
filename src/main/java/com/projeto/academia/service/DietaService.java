package com.projeto.academia.service;

import com.projeto.academia.domain.Dieta;
import com.projeto.academia.repository.DietaRepository;
import com.projeto.academia.security.UsuarioSistemaRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wata on 24/09/16.
 */

@Service
public class DietaService {

    @Autowired
    private DietaRepository dietaRepository;

    //Lista todos as dietas do usuario logado
    public List<Dieta> listarDietas() {

        UsuarioSistemaRest usuario = (UsuarioSistemaRest) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return usuario.getUsuario().getDietas();
        //return dietaRepository.findAll();
    }

    //o usuario logado posta uma dieta
    public Dieta salvarDieta(Dieta dieta) {
        UsuarioSistemaRest usuario = (UsuarioSistemaRest) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        dieta.setUsuario(usuario.getUsuario());
        return dietaRepository.save(dieta);
    }


}
