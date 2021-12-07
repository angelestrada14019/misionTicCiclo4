package com.appistock.proyectostock.service;

import com.appistock.proyectostock.entity.Producto;
import com.appistock.proyectostock.exceptions.GeneralServicesExceptions;
import com.appistock.proyectostock.exceptions.NoDataFoundExceptions;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;
import com.appistock.proyectostock.repository.ProductoRepository;
import com.appistock.proyectostock.validator.ProductoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        try {
            List<Producto> productos = productoRepository.findAll();
            return productos;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }


    public Producto findById(Long id) {
        try {
            Producto objProducto = productoRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el producto con el id: " + id));
            return objProducto;
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
    public Producto create(Producto producto) {
        try {
            ProductoValidator.validador(producto);
            Producto objProducto = productoRepository.save(producto);
            return objProducto;
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
    public Producto update( Producto producto) {
        try {
            ProductoValidator.validador(producto);
            Producto objProducto = productoRepository.findById(producto.getId())
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el producto con el id: " + producto.getId()));
            objProducto.setNombre(producto.getNombre());
            objProducto.setCantidad(producto.getCantidad());
            objProducto.setPrecio(producto.getPrecio());
            objProducto.setDescripcion(producto.getDescripcion());
            objProducto.setSerial(producto.getSerial());
            productoRepository.save(objProducto);
            return objProducto;

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
            Producto objProducto = productoRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el producto con el id: " + id));
            productoRepository.delete(objProducto);

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
