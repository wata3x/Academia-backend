package com.projeto.academia.repository;

import com.projeto.academia.domain.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wata on 22/09/2016.
 */
public interface ExerciciosRepository extends JpaRepository<Exercicio, Long> {
}
