package com.appistock.proyectostock.validator;

import com.appistock.proyectostock.entity.Producto;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;

public class ProductoValidator {

    public static void validador(Producto producto){

        if (producto.getNombre()==null || producto.getNombre().trim().isEmpty()){
            throw new ValidateServiceExceptions("El nombre del producto es obligatorio");
        }
        if (producto.getDescripcion()==null || producto.getDescripcion().trim().isEmpty()){
            throw new ValidateServiceExceptions("La descripcion del producto es obligatorio");
        }

        if (producto.getCantidad()==null){
            throw new ValidateServiceExceptions("La cantidad es obligatoria");
        }
        if (producto.getSerial()==null){
            throw new ValidateServiceExceptions("El serial es obligatoria");
        }
        if (producto.getPrecio()==null){
            throw new ValidateServiceExceptions("El precio es obligatorio");
        }
        if (producto.getNombre().length()>100){
            throw new ValidateServiceExceptions("El nombre es muy largo maximo 100 caracteres");
        }
        if (producto.getDescripcion().length()>200){
            throw new ValidateServiceExceptions("La descripcion es muy largo maximo 200 caracteres");
        }
        if (producto.getSerial().length()>16){
            throw new ValidateServiceExceptions("El serial no debe ser mayor de 16 caracteres");
        }
        if (producto.getCantidad()<=0){
            throw new ValidateServiceExceptions("La cantidad de productos debe ser mayor a 0");
        }

    }

}
