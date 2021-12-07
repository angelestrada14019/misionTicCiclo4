package com.appistock.proyectostock.service;

import com.appistock.proyectostock.entity.Cargo;
import com.appistock.proyectostock.exceptions.GeneralServicesExceptions;
import com.appistock.proyectostock.exceptions.NoDataFoundExceptions;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;
import com.appistock.proyectostock.repository.CargoRepository;
import com.appistock.proyectostock.validator.CargoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public List<Cargo> findAll() {
        try {
            List<Cargo> cargos = cargoRepository.findAll();
            return cargos;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }


    public Cargo findById(Long id) {
        try {
            Cargo objCargo = cargoRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no exite el cargo con el id: " + id));
            return objCargo;
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
    public Cargo create(Cargo cargo) {
        try {
            CargoValidator.validador(cargo);
            Cargo objCargo = cargoRepository.save(cargo);
            return objCargo;
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
    public Cargo update( Cargo cargo) {
        try {
            CargoValidator.validador(cargo);
            Cargo objCargo = cargoRepository.findById(cargo.getId())
                    .orElseThrow(() -> new NoDataFoundExceptions("no exite el cargo con el id: " + cargo.getId()));
            objCargo.setNombre(cargo.getNombre());
            cargoRepository.save(objCargo);
            return objCargo;

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
            Cargo objCargo = cargoRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no exite el cargo con el id: " + id));
            cargoRepository.delete(objCargo);

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
