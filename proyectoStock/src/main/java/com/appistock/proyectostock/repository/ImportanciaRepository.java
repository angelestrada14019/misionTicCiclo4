package com.appistock.proyectostock.repository;

import com.appistock.proyectostock.entity.Importancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportanciaRepository extends JpaRepository<Importancia,Long> {
}
