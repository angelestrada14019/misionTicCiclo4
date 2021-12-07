package com.appistock.proyectostock.service;


import com.appistock.proyectostock.entity.RecursoHumano;
import com.appistock.proyectostock.exceptions.GeneralServicesExceptions;
import com.appistock.proyectostock.exceptions.NoDataFoundExceptions;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;
import com.appistock.proyectostock.repository.RecursoHumanoRepository;

import com.appistock.proyectostock.validator.RecursoHumanoValidator;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
public class RecursoHumanoService {

    @Autowired
    private RecursoHumanoRepository recursohumanoRepository;

    public List<RecursoHumano> findAll() {
        try {
            List<RecursoHumano> recursoHumanos = recursohumanoRepository.findAll();
            return recursoHumanos;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }


    public RecursoHumano findById(Long id) {
        try {
            RecursoHumano objRecursoHumano = recursohumanoRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + id));
            return objRecursoHumano;
        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }

    }

    @Transactional
    public RecursoHumano create(RecursoHumano recursoHumano) {
        try {
            RecursoHumanoValidator.validador(recursoHumano);
            RecursoHumano objRecursoHumano = recursohumanoRepository.save(recursoHumano);
            return objRecursoHumano;
        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }

    }

    @Transactional
    public RecursoHumano update( RecursoHumano recursoHumano) {
        try {
            RecursoHumanoValidator.validador(recursoHumano);
            RecursoHumano objRecursoHumano = recursohumanoRepository.findById(recursoHumano.getId())
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + recursoHumano.getId()));
            objRecursoHumano.setApellido(recursoHumano.getApellido());
            objRecursoHumano.setNombre(recursoHumano.getNombre());
            objRecursoHumano.setCargoId(recursoHumano.getCargoId());
            objRecursoHumano.setContrasenia(recursoHumano.getContrasenia());
            objRecursoHumano.setEmail(recursoHumano.getEmail());
            recursohumanoRepository.save(objRecursoHumano);
            return objRecursoHumano;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }

    }
    @Transactional
    public void delete( Long id) {
        try {
            RecursoHumano objRecursoHumano = recursohumanoRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el producto con el id: " + id));
            recursohumanoRepository.delete(objRecursoHumano);

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
