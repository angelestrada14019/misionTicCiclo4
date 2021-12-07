package com.appistock.proyectostock.validator;

import com.appistock.proyectostock.entity.Categoria;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;

public class CategoriaValidator {

    public static void validador(Categoria categoria){
        if (categoria.getNombre()==null || categoria.getNombre().trim().isEmpty()){
            throw new ValidateServiceExceptions("El nombre del perfil es obligatorio");
        }
        if (categoria.getNombre().length()>100){
            throw new ValidateServiceExceptions("El nombre es muy largo maximo 200 caracteres");
        }
    }
}
