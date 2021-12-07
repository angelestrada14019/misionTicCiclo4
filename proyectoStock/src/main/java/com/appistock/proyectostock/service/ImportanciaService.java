package com.appistock.proyectostock.service;

import com.appistock.proyectostock.entity.Importancia;
import com.appistock.proyectostock.exceptions.GeneralServicesExceptions;
import com.appistock.proyectostock.exceptions.NoDataFoundExceptions;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;

import com.appistock.proyectostock.repository.ImportanciaRepository;

import com.appistock.proyectostock.validator.ImportanciaValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ImportanciaService {

    @Autowired
    private ImportanciaRepository importanciaRepository;

    public List<Importancia> findAll() {
        try {
            List<Importancia> importancias = importanciaRepository.findAll();
            return importancias;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }


    public Importancia findById(Long id) {
        try {
            Importancia objimportancia = importanciaRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no exite la importancia con el id: " + id));
            return objimportancia;
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
