package com.projeto.academia.repository;

import com.projeto.academia.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by wata on 21/09/2016.
 */
public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    //public Optional<Usuario> findByEmail(String email);

}
