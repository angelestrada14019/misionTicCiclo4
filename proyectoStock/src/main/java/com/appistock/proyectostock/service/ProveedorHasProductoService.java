package com.appistock.proyectostock.service;


import com.appistock.proyectostock.entity.ProveedorHasProducto;
import com.appistock.proyectostock.exceptions.GeneralServicesExceptions;
import com.appistock.proyectostock.exceptions.NoDataFoundExceptions;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;
import com.appistock.proyectostock.repository.ProveedorHasProductoRepository;
import com.appistock.proyectostock.validator.ProveedorHasProductoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Slf4j
public class ProveedorHasProductoService {

    @Autowired
    private ProveedorHasProductoRepository proveedorHasProductoRepository;

    public List<ProveedorHasProducto> findAll() {
        try {
            List<ProveedorHasProducto> proveedorHasProductos = proveedorHasProductoRepository.findAll();
            return proveedorHasProductos;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }


    public ProveedorHasProducto findById(Long id) {
        try {
            ProveedorHasProducto objProveedorHasProducto = proveedorHasProductoRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + id));
            return objProveedorHasProducto;
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
    public ProveedorHasProducto create(ProveedorHasProducto proveedorHasProducto) {
        try {
            ProveedorHasProductoValidator.validador(proveedorHasProducto);
            ProveedorHasProducto objProveedorHasProducto = proveedorHasProductoRepository.save(proveedorHasProducto);
            return objProveedorHasProducto;
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
    public ProveedorHasProducto update( ProveedorHasProducto proveedorHasProducto) {
        try {
            ProveedorHasProductoValidator.validador(proveedorHasProducto);
            ProveedorHasProducto objProveedorHasProducto = proveedorHasProductoRepository.findById(proveedorHasProducto.getId())
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + proveedorHasProducto.getId()));
            objProveedorHasProducto.setProveedorId(proveedorHasProducto.getProveedorId());
            objProveedorHasProducto.setProductoId(proveedorHasProducto.getProductoId());
            proveedorHasProductoRepository.save(objProveedorHasProducto);
            return objProveedorHasProducto;

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
            ProveedorHasProducto objProveedorHasProducto = proveedorHasProductoRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el producto con el id: " + id));
            proveedorHasProductoRepository.delete(objProveedorHasProducto);

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
