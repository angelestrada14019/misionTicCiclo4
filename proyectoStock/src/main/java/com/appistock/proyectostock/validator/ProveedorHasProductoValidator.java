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
        if (proveedorHasProducto.getCantidad()==null){
            throw new ValidateServiceExceptions("La cantidad es obligatoria");
        }
        if (proveedorHasProducto.getCantidad()<=0){
            throw new ValidateServiceExceptions("La cantidad de productos debe ser mayor a 0");
        }
    }
}
