package com.appistock.proyectostock.controller;


import com.appistock.proyectostock.converter.ProveedorConverter;

import com.appistock.proyectostock.dtos.ProveedorDto;

import com.appistock.proyectostock.entity.Proveedor;
import com.appistock.proyectostock.service.ProveedorService;
import com.appistock.proyectostock.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;
    private ProveedorConverter proveedorConverter=new ProveedorConverter();

    @GetMapping("/proveedor")
    public ResponseEntity<WrapperResponse<List<ProveedorDto>>> findAll() {
        List<Proveedor> proveedores = proveedorService.findAll();
        List<ProveedorDto> proveedoresDto=proveedorConverter.fromEntity(proveedores);
        return new WrapperResponse<>(true,"Succes",proveedoresDto).createResponse(HttpStatus.OK);

    }

    @GetMapping("/proveedor/{Id}")
    public ResponseEntity<WrapperResponse<ProveedorDto>> findById(@PathVariable("Id") Long id) {
        Proveedor objProveedor = proveedorService.findById(id);
        ProveedorDto objProveedorDto=proveedorConverter.fromEntity(objProveedor);
        return new WrapperResponse<>(true,"Id Succes",objProveedorDto).createResponse(HttpStatus.OK);

    }

    @PostMapping("/proveedor")
    public ResponseEntity<WrapperResponse<ProveedorDto>> create(@RequestBody ProveedorDto proveedorDto) {
        Proveedor objProveedor = proveedorService.create(proveedorConverter.fromDto(proveedorDto));
        ProveedorDto objProveedorDto=proveedorConverter.fromEntity(objProveedor);
        return new WrapperResponse<>(true,"Create Succes",objProveedorDto).createResponse(HttpStatus.CREATED);


    }

    @PutMapping("/proveedor")
    public ResponseEntity<WrapperResponse<ProveedorDto>> update(@RequestBody ProveedorDto proveedorDto) {
        Proveedor objProveedor = proveedorService.update(proveedorConverter.fromDto(proveedorDto));
        ProveedorDto objProveedorDto=proveedorConverter.fromEntity(objProveedor);
        return new WrapperResponse<>(true,"Update Succes",objProveedorDto).createResponse(HttpStatus.OK);


    }

    @DeleteMapping("/proveedor/{Id}")
    public ResponseEntity<WrapperResponse<Void>> delete(@PathVariable("Id") Long id) {
        proveedorService.delete(id);
        return new WrapperResponse<Void>(true,"Delete Succes",null).createResponse(HttpStatus.OK);

    }
}
