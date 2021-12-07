package com.appistock.proyectostock.controller;

import com.appistock.proyectostock.converter.DependenciaConverter;
import com.appistock.proyectostock.converter.ImportanciaConverter;
import com.appistock.proyectostock.dtos.DependenciaDto;
import com.appistock.proyectostock.dtos.ImportanciaDto;
import com.appistock.proyectostock.entity.Dependencia;
import com.appistock.proyectostock.entity.Importancia;
import com.appistock.proyectostock.service.DependenciaService;
import com.appistock.proyectostock.service.ImportanciaService;
import com.appistock.proyectostock.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DependenciaController {

    @Autowired
    private DependenciaService dependenciaService;
    private DependenciaConverter dependenciaConverter=new DependenciaConverter();


    @GetMapping("/dependencia")
    public ResponseEntity<WrapperResponse<List<DependenciaDto>>> findAll() {
        List<Dependencia> dependencias = dependenciaService.findAll();
        List<DependenciaDto> dependenciasDto=dependenciaConverter.fromEntity(dependencias);
        return new WrapperResponse<>(true,"Succes",dependenciasDto).createResponse(HttpStatus.OK);

    }

    @GetMapping("/dependencia/{Id}")
    public ResponseEntity<WrapperResponse<DependenciaDto>> findById(@PathVariable("Id") Long id) {
        Dependencia objdependencia = dependenciaService.findById(id);
        DependenciaDto objdependenciaDto=dependenciaConverter.fromEntity(objdependencia);
        return new WrapperResponse<>(true,"Id Succes",objdependenciaDto).createResponse(HttpStatus.OK);

    }






}
