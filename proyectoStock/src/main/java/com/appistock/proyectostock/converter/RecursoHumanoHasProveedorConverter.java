package com.appistock.proyectostock.converter;

import com.appistock.proyectostock.dtos.RecursoHumanoHasProveedorDto;
import com.appistock.proyectostock.entity.RecursoHumanoHasProveedor;

public class RecursoHumanoHasProveedorConverter extends AbstractConverter<RecursoHumanoHasProveedor, RecursoHumanoHasProveedorDto> {
    @Override
    public RecursoHumanoHasProveedorDto fromEntity(RecursoHumanoHasProveedor entity) {
        return RecursoHumanoHasProveedorDto.builder()
                .id(entity.getId())
                .recursohumanoId(entity.getRecursohumanoId())
                .proveedorId(entity.getProveedorId())
                .build();
    }

    @Override
    public RecursoHumanoHasProveedor fromDto(RecursoHumanoHasProveedorDto dto) {
        return RecursoHumanoHasProveedor.builder()
                .id(dto.getId())
                .recursohumanoId(dto.getRecursohumanoId())
                .proveedorId(dto.getProveedorId())
                .build();
    }
}
