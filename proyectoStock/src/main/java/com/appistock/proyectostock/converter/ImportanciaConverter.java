package com.appistock.proyectostock.converter;

import com.appistock.proyectostock.dtos.CategoriaDto;
import com.appistock.proyectostock.dtos.ImportanciaDto;
import com.appistock.proyectostock.entity.Categoria;
import com.appistock.proyectostock.entity.Importancia;

public class ImportanciaConverter extends AbstractConverter<Importancia, ImportanciaDto> {
    @Override
    public ImportanciaDto fromEntity(Importancia entity) {
        return ImportanciaDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    public Importancia fromDto(ImportanciaDto dto) {
        return Importancia.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .build();
    }
}
