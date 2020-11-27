package com.msa.api.exceptions;

import org.springframework.boot.ExitCodeExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.*;

@Provider
public class DatosNoEncontradosMapper
        implements ExceptionMapper <DatosNoEncontradosExcepcion>{

    @Override
    public Response toResponse(DatosNoEncontradosExcepcion excepcion) {
        MensajeError mensaje = new MensajeError("Datos no encontrados",404,"Esta información no se encuentra");
        return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
    }
}
