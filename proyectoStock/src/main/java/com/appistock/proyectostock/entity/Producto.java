package com.appistock.proyectostock.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false,length = 100)
    private String nombre;

    @Column(name = "cantidad",nullable = false)
    private Long cantidad;

    @Column(name = "descripcion",nullable = false,length = 200)
    private String descripcion;

    @Column(name = "precio",nullable = false)
    private Double precio;

    @Column(name = "serial",nullable = false,length = 16)
    private String serial;

}
