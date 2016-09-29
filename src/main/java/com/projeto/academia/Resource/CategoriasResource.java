package com.projeto.academia.Resource;

import com.projeto.academia.domain.Categoria;
import com.projeto.academia.domain.Exercicio;
import com.projeto.academia.repository.CategoriasRepository;
import com.projeto.academia.service.CategoriasService;
import com.projeto.academia.service.exceptions.CategoriaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by wata on 21/09/2016.
 */

@RestController
@RequestMapping("/categorias")
public class CategoriasResource {

    @Autowired
    private CategoriasService categoriasService;

    //localhost/categorias metodo GET
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriasService.listarCategorias());
    }

    //localhost/categorias/{id} metodo GET
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarCategoria(@PathVariable("id") Long id) {
        Categoria categoria = categoriasService.buscarCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    //localhost/categorias metodo POST
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvarCategoria(@RequestBody Categoria categoria) {
        categoria = categoriasService.salvarCategoria(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    //localhost/categorias/{id} metodo DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletarCategoria(@PathVariable("id") Long id) {
        categoriasService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }

    //localhost/categorias/{id} metodo PUT
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizarCategoria(@RequestBody Categoria categoria, @PathVariable("id") Long id) {
        categoria.setId(id);
        categoriasService.atualizarCategoria(categoria);
        return ResponseEntity.noContent().build();
    }

    //localhost/categorias/{id}/exercicios metodo POST
    @RequestMapping(value = "/{id}/exercicios", method = RequestMethod.POST)
    public ResponseEntity<Void> salvarExercicio(@PathVariable("id") Long categoriaId,
                                                @RequestBody Exercicio exercicio) {
        categoriasService.salvarExercicio(categoriaId, exercicio);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).build();
    }

    //localhost/categorias/{id}/exercicios metodo GET
    @RequestMapping(value = "/{id}/exercicios", method = RequestMethod.GET)
    public ResponseEntity<List<Exercicio>> listarExercicios(@PathVariable ("id") Long categoriaId) {
        List<Exercicio> exercicios = categoriasService.listarExercicios(categoriaId);

        return ResponseEntity.status(HttpStatus.OK).body(exercicios);
    }
}
