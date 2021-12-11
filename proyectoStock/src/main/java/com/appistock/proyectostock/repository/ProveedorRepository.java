package com.appistock.proyectostock.repository;

import com.appistock.proyectostock.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>,
        JpaSpecificationExecutor<Proveedor> {

    public Optional<Proveedor> findByemail(String email);

}