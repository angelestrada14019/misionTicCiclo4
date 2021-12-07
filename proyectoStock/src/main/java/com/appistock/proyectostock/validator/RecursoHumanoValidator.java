package com.appistock.proyectostock.validator;

import com.appistock.proyectostock.entity.Proveedor;
import com.appistock.proyectostock.entity.RecursoHumano;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;

public class RecursoHumanoValidator {
    public static void validador(RecursoHumano recursoHumano){
        if (recursoHumano.getNombre()==null || recursoHumano.getNombre().trim().isEmpty()){
            throw new ValidateServiceExceptions("El nombre es obligatorio");
        }
        if (recursoHumano.getApellido()==null || recursoHumano.getApellido().trim().isEmpty()){
            throw new ValidateServiceExceptions("El apellido es obligatorio");
        }
        if (recursoHumano.getEmail()==null || recursoHumano.getEmail().trim().isEmpty()){
            throw new ValidateServiceExceptions("El email es obligatorio");
        }
        if (recursoHumano.getContrasenia()==null || recursoHumano.getContrasenia().trim().isEmpty()){
            throw new ValidateServiceExceptions("La contraseña es obligatoria");
        }
        if (recursoHumano.getCargoId()==null){
            throw new ValidateServiceExceptions("El id del cargo es obligatorio");
        }

        if (recursoHumano.getNombre().length()>100){
            throw new ValidateServiceExceptions("El nombre es muy largo, maximo 100 caracteres");
        }
        if (recursoHumano.getApellido().length()>100){
            throw new ValidateServiceExceptions("El apellido es muy largo, maximo 100 caracteres");
        }
        if (recursoHumano.getEmail().length()>60){
            throw new ValidateServiceExceptions("El email es muy largo maximo 60 caracteres");
        }
    }
}
