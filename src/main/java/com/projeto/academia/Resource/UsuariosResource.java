package com.projeto.academia.Resource;

import com.projeto.academia.domain.Usuario;
import com.projeto.academia.service.UsuariosService;
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
 * Created by wata on 21/09/2016.
 */

@RestController
@RequestMapping("usuarios")
public class UsuariosResource
{
    @Autowired
    private UsuariosService usuariosService;


    //localhost/usuarios metodo POST
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {
        usuario = usuariosService.salvarUsuario(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> listarUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.listarUsuarios());
    }
}
