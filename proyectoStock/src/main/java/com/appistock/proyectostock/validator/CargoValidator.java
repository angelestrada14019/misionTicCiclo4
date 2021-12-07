package com.appistock.proyectostock.validator;

import com.appistock.proyectostock.entity.Cargo;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;

public class CargoValidator {
    public static void validador(Cargo cargo){
        if (cargo.getNombre()==null || cargo.getNombre().trim().isEmpty()){
            throw new ValidateServiceExceptions("El nombre del perfil es obligatorio");
        }
        if (cargo.getNombre().length()>100){
            throw new ValidateServiceExceptions("El nombre es muy largo maximo 200 caracteres");
        }
    }
}
