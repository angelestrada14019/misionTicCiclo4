package com.appistock.proyectostock.controller;


import com.appistock.proyectostock.converter.RecursoHumanoHasProveedorConverter;

import com.appistock.proyectostock.dtos.RecursoHumanoHasProveedorDto;

import com.appistock.proyectostock.entity.RecursoHumanoHasProveedor;
import com.appistock.proyectostock.service.RecursoHumanoHasProveedorService;
import com.appistock.proyectostock.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RecursoHumanoHasProveedorController {

    @Autowired
    private RecursoHumanoHasProveedorService recursohumanoHasProveedorService;
    private RecursoHumanoHasProveedorConverter recursoHumanoHasProveedorConverter=new RecursoHumanoHasProveedorConverter();

    @GetMapping("/recurso_humano_has_proveedor")
    public ResponseEntity<WrapperResponse<List<RecursoHumanoHasProveedorDto>>> findAll() {
        List<RecursoHumanoHasProveedor> recursoHumanoHasProveedores = recursohumanoHasProveedorService.findAll();
        List<RecursoHumanoHasProveedorDto> recursoHumanoHasProveedoresDto=recursoHumanoHasProveedorConverter.fromEntity(recursoHumanoHasProveedores);
        return new WrapperResponse<>(true,"Succes",recursoHumanoHasProveedoresDto).createResponse(HttpStatus.OK);

    }

    @GetMapping("/recurso_humano_has_proveedor/{Id}")
    public ResponseEntity<WrapperResponse<RecursoHumanoHasProveedorDto>> findById(@PathVariable("Id") Long id) {
        RecursoHumanoHasProveedor objRecursoHumanoHasProveedor = recursohumanoHasProveedorService.findById(id);
        RecursoHumanoHasProveedorDto objobjRecursoHumanoHasProveedorDto=recursoHumanoHasProveedorConverter.fromEntity(objRecursoHumanoHasProveedor);
        return new WrapperResponse<>(true,"Id Succes",objobjRecursoHumanoHasProveedorDto).createResponse(HttpStatus.OK);

    }

    @PostMapping("/recurso_humano_has_proveedor")
    public ResponseEntity<WrapperResponse<RecursoHumanoHasProveedorDto>> create(@RequestBody RecursoHumanoHasProveedorDto recursoHumanoHasProveedorDto) {
        RecursoHumanoHasProveedor objRecursoHumanoHasProveedor = recursohumanoHasProveedorService.create(recursoHumanoHasProveedorConverter.fromDto(recursoHumanoHasProveedorDto));
        RecursoHumanoHasProveedorDto objobjRecursoHumanoHasProveedorDto=recursoHumanoHasProveedorConverter.fromEntity(objRecursoHumanoHasProveedor);
        return new WrapperResponse<>(true,"Create Succes",objobjRecursoHumanoHasProveedorDto).createResponse(HttpStatus.CREATED);


    }

    @PutMapping("/recurso_humano_has_proveedor")
    public ResponseEntity<WrapperResponse<RecursoHumanoHasProveedorDto>> update(@RequestBody RecursoHumanoHasProveedorDto recursoHumanoHasProveedorDto) {
        RecursoHumanoHasProveedor objRecursoHumanoHasProveedor = recursohumanoHasProveedorService.update(recursoHumanoHasProveedorConverter.fromDto(recursoHumanoHasProveedorDto));
        RecursoHumanoHasProveedorDto objobjRecursoHumanoHasProveedorDto=recursoHumanoHasProveedorConverter.fromEntity(objRecursoHumanoHasProveedor);
        return new WrapperResponse<>(true,"Update Succes",objobjRecursoHumanoHasProveedorDto).createResponse(HttpStatus.OK);


    }

    @DeleteMapping("/recurso_humano_has_proveedor/{Id}")
    public ResponseEntity<WrapperResponse<Void>> delete(@PathVariable("Id") Long id) {
        recursohumanoHasProveedorService.delete(id);
        return new WrapperResponse<Void>(true,"Delete Succes",null).createResponse(HttpStatus.OK);

    }
}
