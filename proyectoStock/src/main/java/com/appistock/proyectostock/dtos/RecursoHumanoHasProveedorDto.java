package com.appistock.proyectostock.dtos;


import com.appistock.proyectostock.entity.Proveedor;
import com.appistock.proyectostock.entity.RecursoHumano;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecursoHumanoHasProveedorDto {
    private Long id;

    private RecursoHumano recursohumanoId;

    private Proveedor proveedorId;

}
