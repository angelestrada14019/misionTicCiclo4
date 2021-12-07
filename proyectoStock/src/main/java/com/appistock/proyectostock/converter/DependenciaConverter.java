package com.appistock.proyectostock.converter;

import com.appistock.proyectostock.dtos.DependenciaDto;
import com.appistock.proyectostock.dtos.ImportanciaDto;
import com.appistock.proyectostock.entity.Dependencia;
import com.appistock.proyectostock.entity.Importancia;

public class DependenciaConverter extends AbstractConverter<Dependencia, DependenciaDto> {
    @Override
    public DependenciaDto fromEntity(Dependencia entity) {
        return DependenciaDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    public Dependencia fromDto(DependenciaDto dto) {
        return Dependencia.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .build();
    }
}
