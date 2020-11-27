package com.msa.api.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mongodb.lang.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.*;
import org.springframework.data.mongodb.core.mapping.*;
import org.springframework.data.mongodb.repository.Query;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString

@Document(collection = "MSA_")
@JsonPropertyOrder({"nombre", "name"})
public class Usuario implements Serializable {
    private static final long serialVersionUID = -7788619177798333712L;
    @Id
    private String id;
    private String nombre;
    @NotEmpty
    @NotNull
    private String apellido;
    @NotEmpty
    @NotNull
    @Indexed(unique = true)
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
