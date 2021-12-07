package com.appistock.proyectostock.validator;
import com.appistock.proyectostock.entity.Dependencia;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;

public class DependenciaValidator {
    public static void validador(Dependencia dependencia){
        if (dependencia.getNombre()==null || dependencia.getNombre().trim().isEmpty()){
            throw new ValidateServiceExceptions("El nombre del perfil es obligatorio");
        }
        if (dependencia.getNombre().length()>100){
            throw new ValidateServiceExceptions("El nombre es muy largo maximo 200 caracteres");
        }
    }
}
