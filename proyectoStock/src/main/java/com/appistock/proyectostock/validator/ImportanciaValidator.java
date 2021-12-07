package com.appistock.proyectostock.validator;


import com.appistock.proyectostock.entity.Importancia;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;

public class ImportanciaValidator {

    public static void validador(Importancia importancia){
        if (importancia.getNombre()==null || importancia.getNombre().trim().isEmpty()){
            throw new ValidateServiceExceptions("El nombre del perfil es obligatorio");
        }
        if (importancia.getNombre().length()>100){
            throw new ValidateServiceExceptions("El nombre es muy largo maximo 200 caracteres");
        }
    }
}
