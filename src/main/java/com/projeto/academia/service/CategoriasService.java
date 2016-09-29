package com.projeto.academia.service;

import com.projeto.academia.domain.Categoria;
import com.projeto.academia.domain.Exercicio;
import com.projeto.academia.repository.CategoriasRepository;
import com.projeto.academia.repository.ExerciciosRepository;
import com.projeto.academia.service.exceptions.CategoriaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wata on 21/09/2016.
 */

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;
    @Autowired
    private ExerciciosRepository exerciciosRepository;

    //Lista todos os livros
    public List<Categoria> listarCategorias() {
        return categoriasRepository.findAll();
    }

    //Busca uma categoria pelo {id}
    public Categoria buscarCategoria(Long id) {
        Categoria categoria = categoriasRepository.findOne(id);

        if(categoria == null) {
            throw new CategoriaNaoEncontradaException("Categoria não encontrada");
        }

        return categoria;
    }

    //salva uma categoria
    public Categoria salvarCategoria(Categoria categoria) {
        categoria.setId(null);
        return categoriasRepository.save(categoria);
    }

    //deleta uma categoria
    public void deletarCategoria(Long id) {
        try {
            categoriasRepository.delete(id);
        }catch (EmptyResultDataAccessException e) {
            throw new CategoriaNaoEncontradaException("A categoria não pode ser encontrada");
        }
    }
    //verifica se a categoria existe e depois atualiza
    public void atualizarCategoria(Categoria categoria) {
        verificarExistenciaCategoria(categoria);
        categoriasRepository.save(categoria);
    }

    //verificar existencia da categoria
    private void verificarExistenciaCategoria(Categoria categoria) {
        buscarCategoria(categoria.getId());
    }

    //salva um exercicio em uma determinada categoria
    public Exercicio salvarExercicio(Long categoriaId, Exercicio exercicio) {
        Categoria categoria = buscarCategoria(categoriaId);

        exercicio.setCategoria(categoria);
        return exerciciosRepository.save(exercicio);
    }

    //lista os exercicios de uma determinada categoria
    public List<Exercicio> listarExercicios(Long categoriaId) {
        Categoria categoria = buscarCategoria(categoriaId);

        return categoria.getExercicios();
    }
}
