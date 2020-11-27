package com.msa.api.exceptions;

public class DatosNoEncontradosExcepcion extends RuntimeException {

    public DatosNoEncontradosExcepcion (String mensaje){
        super(mensaje);
    }
}
