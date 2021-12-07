package com.appistock.proyectostock.converter;

import com.appistock.proyectostock.dtos.ProveedorDto;
import com.appistock.proyectostock.dtos.ProveedorHasProductoDto;
import com.appistock.proyectostock.entity.ProveedorHasProducto;

public class ProveedorHasProductoConverter extends AbstractConverter<ProveedorHasProducto, ProveedorHasProductoDto> {
    @Override
    public ProveedorHasProductoDto fromEntity(ProveedorHasProducto entity) {
        return ProveedorHasProductoDto.builder()
                .id(entity.getId())
                .productoId(entity.getProductoId())
                .proveedorId(entity.getProveedorId())
                .build();
    }

    @Override
    public ProveedorHasProducto fromDto(ProveedorHasProductoDto dto) {
        return ProveedorHasProducto.builder()
                .id(dto.getId())
                .productoId(dto.getProductoId())
                .proveedorId(dto.getProveedorId())
                .build();
    }
}
