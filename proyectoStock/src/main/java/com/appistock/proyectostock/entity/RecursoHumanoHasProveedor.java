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
public class RecursoHumanoHasProveedor {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recursoHumano_id",nullable = false,updatable = false,referencedColumnName = "id")
    private RecursoHumano recursohumanoId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proveedor_id",nullable = false,updatable = false,referencedColumnName = "id")
    private Proveedor proveedorId;

}
