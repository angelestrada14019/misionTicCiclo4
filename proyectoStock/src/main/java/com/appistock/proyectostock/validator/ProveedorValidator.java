package com.appistock.proyectostock.validator;

import com.appistock.proyectostock.entity.Dependencia;
import com.appistock.proyectostock.entity.Proveedor;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;

public class ProveedorValidator {

    public static void validador(Proveedor proveedor){
        if (proveedor.getDescripcion()==null || proveedor.getDescripcion().trim().isEmpty()){
            throw new ValidateServiceExceptions("La descripcion es obligatoria");
        }
        if (proveedor.getEmail()==null || proveedor.getEmail().trim().isEmpty()){
            throw new ValidateServiceExceptions("El email es obligatorio");
        }
        if (proveedor.getContrasenia()==null || proveedor.getContrasenia().trim().isEmpty()){
            throw new ValidateServiceExceptions("La contraseña es obligatoria");
        }
        if (proveedor.getCategoriaId()==null){
            throw new ValidateServiceExceptions("La categoria es obligatoria");
        }
        if (proveedor.getDependenciaId()==null){
            throw new ValidateServiceExceptions("La dependencia es obligatoria");
        }
        if (proveedor.getImportanciaId()==null){
            throw new ValidateServiceExceptions("La importancia es obligatoria");
        }

        if (proveedor.getDescripcion().length()>300){
            throw new ValidateServiceExceptions("La descripción es muy larga maximo 300 caracteres");
        }
        if (proveedor.getEmail().length()>60){
            throw new ValidateServiceExceptions("El email es muy largo maximo 60 caracteres");
        }
    }
}
