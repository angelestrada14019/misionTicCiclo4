package com.appistock.proyectostock.controller;


import com.appistock.proyectostock.converter.RecursoHumanoConverter;

import com.appistock.proyectostock.dtos.RecursoHumanoDto;

import com.appistock.proyectostock.entity.RecursoHumano;
import com.appistock.proyectostock.service.RecursoHumanoService;
import com.appistock.proyectostock.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RecursoHumanoController {

    @Autowired
    private RecursoHumanoService recursohumanoService;
    private RecursoHumanoConverter recursoHumanoConverter=new RecursoHumanoConverter();

    @GetMapping("/recurso_humano")
    public ResponseEntity<WrapperResponse<List<RecursoHumanoDto>>> findAll() {
        List<RecursoHumano> recursoHumanos = recursohumanoService.findAll();
        List<RecursoHumanoDto> recursoHumanosDto=recursoHumanoConverter.fromEntity(recursoHumanos);
        return new WrapperResponse<>(true,"Succes",recursoHumanosDto).createResponse(HttpStatus.OK);

    }

    @GetMapping("/recurso_humano/{Id}")
    public ResponseEntity<WrapperResponse<RecursoHumanoDto>> findById(@PathVariable("Id") Long id) {
        RecursoHumano objRecursoHumano = recursohumanoService.findById(id);
        RecursoHumanoDto objRecursoHumanoDto=recursoHumanoConverter.fromEntity(objRecursoHumano);
        return new WrapperResponse<>(true,"Id Succes",objRecursoHumanoDto).createResponse(HttpStatus.OK);

    }

    @PostMapping("/recurso_humano")
    public ResponseEntity<WrapperResponse<RecursoHumanoDto>> create(@RequestBody RecursoHumanoDto recursoHumanoDto) {
        RecursoHumano objRecursoHumano = recursohumanoService.create(recursoHumanoConverter.fromDto(recursoHumanoDto));
        RecursoHumanoDto objRecursoHumanoDto=recursoHumanoConverter.fromEntity(objRecursoHumano);
        return new WrapperResponse<>(true,"Create Succes",objRecursoHumanoDto).createResponse(HttpStatus.CREATED);


    }

    @PutMapping("/recurso_humano")
    public ResponseEntity<WrapperResponse<RecursoHumanoDto>> update(@RequestBody RecursoHumanoDto recursoHumanoDto) {
        RecursoHumano objRecursoHumano = recursohumanoService.update(recursoHumanoConverter.fromDto(recursoHumanoDto));
        RecursoHumanoDto objRecursoHumanoDto=recursoHumanoConverter.fromEntity(objRecursoHumano);
        return new WrapperResponse<>(true,"Update Succes",objRecursoHumanoDto).createResponse(HttpStatus.OK);


    }

    @DeleteMapping("/recurso_humano/{Id}")
    public ResponseEntity<WrapperResponse<Void>> delete(@PathVariable("Id") Long id) {
        recursohumanoService.delete(id);
        return new WrapperResponse<Void>(true,"Delete Succes",null).createResponse(HttpStatus.OK);

    }
}
