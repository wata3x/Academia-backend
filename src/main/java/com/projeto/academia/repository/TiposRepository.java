package com.projeto.academia.repository;

import com.projeto.academia.domain.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wata on 21/09/2016.
 */
public interface TiposRepository extends JpaRepository<Tipo, Long> {
    List<Tipo> findByTipo(String tipo);
}
