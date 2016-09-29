package com.projeto.academia.Resource;

import com.projeto.academia.domain.Dieta;
import com.projeto.academia.service.DietaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by wata on 25/09/16.
 */

@RestController
@RequestMapping("/dietas")
public class DietasResource {

    @Autowired
    private DietaService dietaService;

    //localhost/dietas metodo GET
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Dieta>> listarCategorias() {
        return ResponseEntity.status(HttpStatus.OK).body(dietaService.listarDietas());
    }

    //localhost/dietas metodo POST
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvarDieta(@RequestBody Dieta dieta) {
        dietaService.salvarDieta(dieta);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).build();
    }

}
