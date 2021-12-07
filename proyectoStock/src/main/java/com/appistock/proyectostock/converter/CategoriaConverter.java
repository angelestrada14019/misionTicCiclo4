package com.appistock.proyectostock.converter;

import com.appistock.proyectostock.dtos.CargoDto;
import com.appistock.proyectostock.dtos.CategoriaDto;
import com.appistock.proyectostock.entity.Cargo;
import com.appistock.proyectostock.entity.Categoria;

public class CategoriaConverter extends AbstractConverter<Categoria, CategoriaDto> {
    @Override
    public CategoriaDto fromEntity(Categoria entity) {
        return CategoriaDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    public Categoria fromDto(CategoriaDto dto) {
        return Categoria.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .build();
    }
}
