package com.msa.api.repository;

import com.msa.api.model.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository <Usuario, String>  {
    List<Usuario>findAll();
    Usuario save (Usuario u);

    @Override
    Optional<Usuario> findById(String s);

    @Override
    <S extends Usuario> Optional<S> findOne(Example<S> example);
    //void delete(Optional<Usuario> u);

}
