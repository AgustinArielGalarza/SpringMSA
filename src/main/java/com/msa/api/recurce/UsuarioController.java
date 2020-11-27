package com.msa.api.recurce;


import com.msa.api.model.Usuario;
import com.msa.api.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/usuario"})
public class UsuarioController {

    @Autowired
    private UsuarioServices services;

    @GetMapping
    public List<Usuario> getUsuario(){
        return services.getUsuario();
    }

    @PostMapping
    public ResponseEntity<?> postUsuario(@RequestBody Usuario usuario){
        return services.register(usuario);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> getUsuarioID(@PathVariable String id){
        return services.getUsuarioID(id);
    }

    @PutMapping(path = {"/{id}"})
    public Usuario editUsuario(@PathVariable String id, @RequestBody Usuario usuario){
        usuario.setId(id);
        return services.editUsuario(usuario);
    }

    @DeleteMapping(path = {"/{id}"})
    public void Delete(@PathVariable String id){
        services.deleteUsuario(id);
    }
}
