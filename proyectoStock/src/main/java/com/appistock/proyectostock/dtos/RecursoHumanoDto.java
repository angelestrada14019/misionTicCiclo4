package com.appistock.proyectostock.dtos;


import com.appistock.proyectostock.entity.Cargo;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecursoHumanoDto {
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String contrasenia;

    private Cargo cargoId;

}
