package com.appistock.proyectostock.dtos;


import com.appistock.proyectostock.entity.Categoria;
import com.appistock.proyectostock.entity.Dependencia;
import com.appistock.proyectostock.entity.Importancia;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDto {
    private Long id;

    private String descripcion;

    private String email;

    private String contrasenia;

    private Categoria categoriaId;

    private Dependencia dependenciaId;

    private Importancia importanciaId;

}
