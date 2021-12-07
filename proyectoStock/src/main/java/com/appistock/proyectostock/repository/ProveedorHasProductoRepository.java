package com.appistock.proyectostock.repository;

import com.appistock.proyectostock.entity.ProveedorHasProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProveedorHasProductoRepository extends JpaRepository<ProveedorHasProducto, Long>, JpaSpecificationExecutor<ProveedorHasProducto> {

}