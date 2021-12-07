package com.appistock.proyectostock.repository;

import com.appistock.proyectostock.entity.RecursoHumanoHasProveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecursoHumanoHasProveedorRepository extends JpaRepository<RecursoHumanoHasProveedor, Long>, JpaSpecificationExecutor<RecursoHumanoHasProveedor> {

}