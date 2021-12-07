package com.appistock.proyectostock.service;

import com.appistock.proyectostock.entity.Cargo;
import com.appistock.proyectostock.entity.Categoria;
import com.appistock.proyectostock.exceptions.GeneralServicesExceptions;
import com.appistock.proyectostock.exceptions.NoDataFoundExceptions;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;
import com.appistock.proyectostock.repository.CargoRepository;
import com.appistock.proyectostock.repository.CategoriaRepository;
import com.appistock.proyectostock.validator.CargoValidator;
import com.appistock.proyectostock.validator.CategoriaValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        try {
            List<Categoria> categorias = categoriaRepository.findAll();
            return categorias;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }


    public Categoria findById(Long id) {
        try {
            Categoria objCategoria = categoriaRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no exite la categoria con el id: " + id));
            return objCategoria;
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
