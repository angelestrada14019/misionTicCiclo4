package com.appistock.proyectostock.repository;

import com.appistock.proyectostock.entity.RecursoHumano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecursoHumanoRepository extends JpaRepository<RecursoHumano, Long>, JpaSpecificationExecutor<RecursoHumano> {

}