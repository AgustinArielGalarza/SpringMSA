package com.msa.api.services;


import com.msa.api.exceptions.DatosNoEncontradosExcepcion;
import com.msa.api.model.Usuario;
import com.msa.api.repository.UsuarioRepository;
import com.msa.api.repository.UsuarioRepositoryOptional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.MapAccessor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class UsuarioServiceImpl implements UsuarioServices{

    @Autowired
    private UsuarioRepository usrRep;
    @Autowired
    private UsuarioRepositoryOptional usrRepOp;

    @Override
    public ResponseEntity<?> register (Usuario usuario){
        Usuario usrPost = null;
        Map<String, Object> response = new HashMap<>();
        try{
            usrPost = usrRep.save(usuario);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al registrar el usuario");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        response.put("mensaje","el Usuario se creo con exito!");
        response.put("usuario",usrPost);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @Override
    public List<Usuario> getUsuario (){
        return usrRep.findAll();
    }

    @Override
    public ResponseEntity<?> getUsuarioID (String id){
       Optional<Usuario> usuario = null;
       Map<String, Object> response = new HashMap<>();
       try{
             usuario = usrRep.findById(id);
        }catch (DataAccessException e){
           response.put("mensaje","Error al realizar la consulta");
           response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
           return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        if(usuario.equals(Optional.empty())){
            response.put("mensaje","El usuario con el ID: ".concat(id).concat(" no se encuentra en la Base de datos."));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Optional<Usuario>>(usuario, HttpStatus.OK);
    }

    @Override
    public void deleteUsuario (String id){
         /*Optional<Usuario> u = usrRep.findOne(id);
            if (u != null) {
                usrRep.delete(u);
            }
                    */
        usrRep.deleteById(id);
    }
    @Override
    public Usuario editUsuario(Usuario usuario){
            return usrRep.save(usuario);
    }
}
