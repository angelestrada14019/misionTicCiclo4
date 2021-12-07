package com.appistock.proyectostock.converter;

import com.appistock.proyectostock.dtos.RecursoHumanoDto;
import com.appistock.proyectostock.entity.RecursoHumano;

public class RecursoHumanoConverter extends AbstractConverter<RecursoHumano, RecursoHumanoDto> {
    @Override
    public RecursoHumanoDto fromEntity(RecursoHumano entity) {
        return RecursoHumanoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .cargoId(entity.getCargoId())
                .contrasenia(entity.getContrasenia())
                .email(entity.getEmail())
                .build();
    }

    @Override
    public RecursoHumano fromDto(RecursoHumanoDto dto) {
        return RecursoHumano.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .cargoId(dto.getCargoId())
                .contrasenia(dto.getContrasenia())
                .email(dto.getEmail())
                .build();
    }
}
