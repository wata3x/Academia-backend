package com.projeto.academia.repository;

import com.projeto.academia.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wata on 21/09/2016.
 */
public interface CategoriasRepository extends JpaRepository<Categoria, Long> {
}
