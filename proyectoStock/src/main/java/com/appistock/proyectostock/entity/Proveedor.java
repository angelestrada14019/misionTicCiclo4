package com.appistock.proyectostock.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "proveedor")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion",nullable = false,length = 300)
    private String descripcion;

    @Column(name = "email",nullable = false,length = 60)
    private String email;

    @Column(name = "contrasenia",nullable = false,length = 200)
    private String contrasenia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id",nullable = false,updatable = false,referencedColumnName = "id")
    private Categoria categoriaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dependencia_id",nullable = false,updatable = false,referencedColumnName = "id")
    private Dependencia dependenciaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "importancia_id",nullable = false,updatable = false,referencedColumnName = "id")
    private Importancia importanciaId;

}
