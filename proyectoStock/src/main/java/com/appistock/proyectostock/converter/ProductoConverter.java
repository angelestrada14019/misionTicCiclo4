package com.appistock.proyectostock.converter;

import com.appistock.proyectostock.dtos.ProductoDto;
import com.appistock.proyectostock.entity.Producto;

public class ProductoConverter extends AbstractConverter<Producto, ProductoDto> {
    @Override
    public ProductoDto fromEntity(Producto entity) {
        return ProductoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())

                .precio(entity.getPrecio())
                .serial(entity.getSerial())
                .build();
    }

    @Override
    public Producto fromDto(ProductoDto dto) {
        return Producto.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())

                .precio(dto.getPrecio())
                .serial(dto.getSerial())
                .build();
    }
}
