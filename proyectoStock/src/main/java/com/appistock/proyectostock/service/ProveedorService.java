package com.appistock.proyectostock.service;

import com.appistock.proyectostock.entity.Proveedor;

import com.appistock.proyectostock.exceptions.GeneralServicesExceptions;
import com.appistock.proyectostock.exceptions.NoDataFoundExceptions;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;
import com.appistock.proyectostock.repository.ProveedorRepository;

import com.appistock.proyectostock.validator.ProveedorValidator;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> findAll() {
        try {
            List<Proveedor> proveedores = proveedorRepository.findAll();
            return proveedores;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }


    public Proveedor findById(Long id) {
        try {
            Proveedor objProveedor = proveedorRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + id));
            return objProveedor;
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
    public Proveedor create(Proveedor proveedor) {
        try {
            ProveedorValidator.validador(proveedor);
            Proveedor objProveedor = proveedorRepository.save(proveedor);
            return objProveedor;
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
    public Proveedor update( Proveedor proveedor) {
        try {
            ProveedorValidator.validador(proveedor);
            Proveedor objProveedor = proveedorRepository.findById(proveedor.getId())
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + proveedor.getId()));
            objProveedor.setDescripcion(proveedor.getDescripcion());
            objProveedor.setCategoriaId(proveedor.getCategoriaId());
            objProveedor.setContrasenia(proveedor.getContrasenia());
            objProveedor.setEmail(proveedor.getEmail());
            objProveedor.setDependenciaId(proveedor.getDependenciaId());
            objProveedor.setImportanciaId(proveedor.getImportanciaId());
            proveedorRepository.save(objProveedor);
            return objProveedor;

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
            Proveedor objProveedor = proveedorRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + id));
            proveedorRepository.delete(objProveedor);

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
