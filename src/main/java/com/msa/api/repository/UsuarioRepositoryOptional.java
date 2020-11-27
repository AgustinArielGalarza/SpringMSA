package com.msa.api.repository;

import com.msa.api.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepositoryOptional extends MongoRepository <Optional<Usuario>, String> {

}
