package com.appistock.proyectostock.repository;


import com.appistock.proyectostock.entity.RecursoHumano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface RecursoHumanoRepository extends JpaRepository<RecursoHumano, Long>,
        JpaSpecificationExecutor<RecursoHumano> {

    public Optional<RecursoHumano> findByemail(String email);

}