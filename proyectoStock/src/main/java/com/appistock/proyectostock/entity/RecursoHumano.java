package com.appistock.proyectostock.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "recursohumano")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecursoHumano {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false,length = 100)
    private String nombre;

    @Column(name = "apellido",nullable = false,length = 100)
    private String apellido;

    @Column(name = "email",nullable = false,length = 60)
    private String email;

    @Column(name = "contrasenia",nullable = false,length = 100)
    private String contrasenia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cargo_id",nullable = false,updatable = false,referencedColumnName = "id")
    private Cargo cargoId;

}
