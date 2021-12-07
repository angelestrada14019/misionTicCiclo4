package com.appistock.proyectostock.converter;

import com.appistock.proyectostock.dtos.ProductoDto;
import com.appistock.proyectostock.dtos.ProveedorDto;
import com.appistock.proyectostock.entity.Proveedor;

public class ProveedorConverter extends AbstractConverter<Proveedor, ProveedorDto> {
    @Override
    public ProveedorDto fromEntity(Proveedor entity) {
        return ProveedorDto.builder()
                .id(entity.getId())
                .categoriaId(entity.getCategoriaId())
                .contrasenia(entity.getContrasenia())
                .email(entity.getEmail())
                .descripcion(entity.getDescripcion())
                .dependenciaId(entity.getDependenciaId())
                .importanciaId(entity.getImportanciaId())
                .build();
    }

    @Override
    public Proveedor fromDto(ProveedorDto dto) {
        return Proveedor.builder()
                .id(dto.getId())
                .categoriaId(dto.getCategoriaId())
                .contrasenia(dto.getContrasenia())
                .email(dto.getEmail())
                .descripcion(dto.getDescripcion())
                .dependenciaId(dto.getDependenciaId())
                .importanciaId(dto.getImportanciaId())
                .build();
    }
}
