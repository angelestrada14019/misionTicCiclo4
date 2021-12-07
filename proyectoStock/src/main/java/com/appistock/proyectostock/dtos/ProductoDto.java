package com.appistock.proyectostock.dtos;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {

    private Long id;
    private String nombre;
    private Long cantidad;
    private String descripcion;
    private Double precio;
    private String serial;
}
