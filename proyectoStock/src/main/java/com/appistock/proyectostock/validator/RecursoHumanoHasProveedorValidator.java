package com.appistock.proyectostock.validator;

import com.appistock.proyectostock.entity.RecursoHumanoHasProveedor;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;

public class RecursoHumanoHasProveedorValidator {

    public static void validador(RecursoHumanoHasProveedor recursoHumanoHasProveedor){
        if (recursoHumanoHasProveedor.getProveedorId()==null){
            throw new ValidateServiceExceptions("El proveedor es obligatorio");
        }
        if (recursoHumanoHasProveedor.getRecursohumanoId()==null){
            throw new ValidateServiceExceptions("El id de recurso humano es obligatorio");
        }
        if (recursoHumanoHasProveedor.getMensaje().length()>300){
            throw new ValidateServiceExceptions("El mensaje es muy largo, maximo 300 caracteres");
        }
    }
}
