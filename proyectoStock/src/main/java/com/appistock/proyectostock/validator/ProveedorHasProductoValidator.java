package com.appistock.proyectostock.validator;


import com.appistock.proyectostock.entity.ProveedorHasProducto;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;

public class ProveedorHasProductoValidator {

    public static void validador(ProveedorHasProducto proveedorHasProducto){
        if (proveedorHasProducto.getProveedorId()==null){
            throw new ValidateServiceExceptions("El proveedor es obligatorio");
        }
        if (proveedorHasProducto.getProductoId()==null){
            throw new ValidateServiceExceptions("El id del producto es obligatorio");
        }
    }
}
