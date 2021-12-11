package com.appistock.proyectostock.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "proveedor_has_producto")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorHasProducto {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proveedor_id",nullable = false,updatable = false,referencedColumnName = "id")
    private Proveedor proveedorId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id",nullable = false,updatable = false,referencedColumnName = "id")
    private Producto productoId;

    @Column(name = "cantidad",nullable = false)
    private Long cantidad;

}
