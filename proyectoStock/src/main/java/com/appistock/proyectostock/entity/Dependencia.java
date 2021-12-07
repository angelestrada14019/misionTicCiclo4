package com.appistock.proyectostock.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dependencia")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dependencia {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false,length = 100)
    private String nombre;
}
