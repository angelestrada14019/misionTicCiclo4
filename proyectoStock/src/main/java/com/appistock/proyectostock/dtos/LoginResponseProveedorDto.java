package com.appistock.proyectostock.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseProveedorDto {
    private ProveedorDto proveedorDto;
    private String token;
}
