package com.appistock.proyectostock.controller;

import com.appistock.proyectostock.converter.CargoConverter;
import com.appistock.proyectostock.dtos.CargoDto;
import com.appistock.proyectostock.entity.Cargo;
import com.appistock.proyectostock.service.CargoService;
import com.appistock.proyectostock.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CargoController {

    @Autowired
    private CargoService cargoService;
    private CargoConverter cargoConverter=new CargoConverter();


    @GetMapping("/cargo")
    public ResponseEntity<WrapperResponse<List<CargoDto>>> findAll() {
        List<Cargo> cargos = cargoService.findAll();
        List<CargoDto> cargosDto=cargoConverter.fromEntity(cargos);
        return new WrapperResponse<>(true,"Succes",cargosDto).createResponse(HttpStatus.OK);

    }

    @GetMapping("/cargo/{Id}")
    public ResponseEntity<WrapperResponse<CargoDto>> findById(@PathVariable("Id") Long id) {
        Cargo objCargo = cargoService.findById(id);
        CargoDto objCargoDto=cargoConverter.fromEntity(objCargo);
        return new WrapperResponse<>(true,"Id Succes",objCargoDto).createResponse(HttpStatus.OK);

    }

    @PostMapping("/cargo")
    public ResponseEntity<WrapperResponse<CargoDto>> create(@RequestBody CargoDto cargoDto) {
        Cargo objCargo = cargoService.create(cargoConverter.fromDto(cargoDto));
        CargoDto objCargoDto=cargoConverter.fromEntity(objCargo);
        return new WrapperResponse<>(true,"Create Succes",objCargoDto).createResponse(HttpStatus.CREATED);


    }

    @PutMapping("/cargo")
    public ResponseEntity<WrapperResponse<CargoDto>> update(@RequestBody CargoDto cargoDto) {
        Cargo objCargo = cargoService.update(cargoConverter.fromDto(cargoDto));
        CargoDto objCargoDto=cargoConverter.fromEntity(objCargo);
        return new WrapperResponse<>(true,"Update Succes",objCargoDto).createResponse(HttpStatus.OK);


    }

    @DeleteMapping("/cargo/{Id}")
    public ResponseEntity<WrapperResponse<Void>> delete(@PathVariable("Id") Long id) {
        cargoService.delete(id);
        return new WrapperResponse<Void>(true,"Delete Succes",null).createResponse(HttpStatus.OK);

    }
}
