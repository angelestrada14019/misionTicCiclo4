package com.appistock.proyectostock.service;


import com.appistock.proyectostock.entity.RecursoHumanoHasProveedor;
import com.appistock.proyectostock.exceptions.GeneralServicesExceptions;
import com.appistock.proyectostock.exceptions.NoDataFoundExceptions;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;
import com.appistock.proyectostock.repository.RecursoHumanoHasProveedorRepository;

import com.appistock.proyectostock.validator.RecursoHumanoHasProveedorValidator;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class RecursoHumanoHasProveedorService {

    @Autowired
    private RecursoHumanoHasProveedorRepository recursohumanoHasProveedorRepository;

    public List<RecursoHumanoHasProveedor> findAll() {
        try {
            List<RecursoHumanoHasProveedor> recursoHumanoHasProveedores = recursohumanoHasProveedorRepository.findAll();
            return recursoHumanoHasProveedores;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }


    public RecursoHumanoHasProveedor findById(Long id) {
        try {
            RecursoHumanoHasProveedor objRecursoHumanoHasProveedor = recursohumanoHasProveedorRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + id));
            return objRecursoHumanoHasProveedor;
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
    public RecursoHumanoHasProveedor create(RecursoHumanoHasProveedor recursoHumanoHasProveedor) {
        try {
            RecursoHumanoHasProveedorValidator.validador(recursoHumanoHasProveedor);
            RecursoHumanoHasProveedor objRecursoHumanoHasProveedor = recursohumanoHasProveedorRepository.save(recursoHumanoHasProveedor);
            return objRecursoHumanoHasProveedor;
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
    public RecursoHumanoHasProveedor update( RecursoHumanoHasProveedor recursoHumanoHasProveedor) {
        try {
            RecursoHumanoHasProveedorValidator.validador(recursoHumanoHasProveedor);
            RecursoHumanoHasProveedor objRecursoHumanoHasProveedor = recursohumanoHasProveedorRepository.findById(recursoHumanoHasProveedor.getId())
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + recursoHumanoHasProveedor.getId()));
            objRecursoHumanoHasProveedor.setProveedorId(recursoHumanoHasProveedor.getProveedorId());
            objRecursoHumanoHasProveedor.setRecursohumanoId(recursoHumanoHasProveedor.getRecursohumanoId());
            objRecursoHumanoHasProveedor.setMensaje(recursoHumanoHasProveedor.getMensaje());
            recursohumanoHasProveedorRepository.save(objRecursoHumanoHasProveedor);
            return objRecursoHumanoHasProveedor;

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
            RecursoHumanoHasProveedor objRecursoHumanoHasProveedor = recursohumanoHasProveedorRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el producto con el id: " + id));
            recursohumanoHasProveedorRepository.delete(objRecursoHumanoHasProveedor);

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
