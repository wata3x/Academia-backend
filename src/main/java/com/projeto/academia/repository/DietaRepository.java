package com.projeto.academia.repository;

import com.projeto.academia.domain.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wata on 24/09/16.
 */
public interface DietaRepository extends JpaRepository<Dieta, Long> {
}
