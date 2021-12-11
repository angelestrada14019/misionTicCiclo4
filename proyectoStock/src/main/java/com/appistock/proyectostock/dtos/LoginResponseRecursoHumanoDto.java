package com.appistock.proyectostock.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseRecursoHumanoDto {
    private RecursoHumanoDto recursoHumanoDto;
    private String token;
}
