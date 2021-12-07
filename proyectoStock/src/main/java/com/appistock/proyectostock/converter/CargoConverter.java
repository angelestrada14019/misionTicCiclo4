package com.appistock.proyectostock.converter;

import com.appistock.proyectostock.dtos.CargoDto;
import com.appistock.proyectostock.entity.Cargo;

public class CargoConverter extends AbstractConverter<Cargo, CargoDto> {
    @Override
    public CargoDto fromEntity(Cargo entity) {
        return CargoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    public Cargo fromDto(CargoDto dto) {
        return Cargo.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .build();
    }
}
