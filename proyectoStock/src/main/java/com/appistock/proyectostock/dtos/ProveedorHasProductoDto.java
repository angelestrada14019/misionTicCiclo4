package com.appistock.proyectostock.dtos;


import com.appistock.proyectostock.entity.Producto;
import com.appistock.proyectostock.entity.Proveedor;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorHasProductoDto {
    private Long id;
    private Proveedor proveedorId;
    private Producto productoId;
    private Long cantidad;

}
