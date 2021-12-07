package com.appistock.proyectostock.controller;

import com.appistock.proyectostock.converter.ImportanciaConverter;

import com.appistock.proyectostock.dtos.ImportanciaDto;

import com.appistock.proyectostock.entity.Importancia;

import com.appistock.proyectostock.service.ImportanciaService;
import com.appistock.proyectostock.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImportanciaController {

    @Autowired
    private ImportanciaService importanciaService;
    private ImportanciaConverter importanciaConverter=new ImportanciaConverter();


    @GetMapping("/importancia")
    public ResponseEntity<WrapperResponse<List<ImportanciaDto>>> findAll() {
        List<Importancia> importancias = importanciaService.findAll();
        List<ImportanciaDto> importanciasDto=importanciaConverter.fromEntity(importancias);
        return new WrapperResponse<>(true,"Succes",importanciasDto).createResponse(HttpStatus.OK);

    }

    @GetMapping("/importancia/{Id}")
    public ResponseEntity<WrapperResponse<ImportanciaDto>> findById(@PathVariable("Id") Long id) {
        Importancia objImportancia = importanciaService.findById(id);
        ImportanciaDto objImportanciaDto=importanciaConverter.fromEntity(objImportancia);
        return new WrapperResponse<>(true,"Id Succes",objImportanciaDto).createResponse(HttpStatus.OK);

    }




}
