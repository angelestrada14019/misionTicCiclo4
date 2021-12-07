package com.appistock.proyectostock.service;

import com.appistock.proyectostock.entity.Dependencia;
import com.appistock.proyectostock.entity.Importancia;
import com.appistock.proyectostock.exceptions.GeneralServicesExceptions;
import com.appistock.proyectostock.exceptions.NoDataFoundExceptions;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;
import com.appistock.proyectostock.repository.DependenciaRepository;
import com.appistock.proyectostock.repository.ImportanciaRepository;
import com.appistock.proyectostock.validator.DependenciaValidator;
import com.appistock.proyectostock.validator.ImportanciaValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DependenciaService {
    @Autowired
    private DependenciaRepository dependenciaRepository;

    public List<Dependencia> findAll() {
        try {
            List<Dependencia> dependencias = dependenciaRepository.findAll();
            return dependencias;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }


    public Dependencia findById(Long id) {
        try {
            Dependencia objdependencia = dependenciaRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no exite la dependencia con el id: " + id));
            return objdependencia;
        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }

    }





}
