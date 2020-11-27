package com.msa.api.services;

import com.msa.api.model.Usuario;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

public interface UsuarioServices {
    List<Usuario>getUsuario();
    ResponseEntity<?> getUsuarioID(String id);
    ResponseEntity<?> register(Usuario u);
    Usuario editUsuario(Usuario u);
    void deleteUsuario(String id);
}
