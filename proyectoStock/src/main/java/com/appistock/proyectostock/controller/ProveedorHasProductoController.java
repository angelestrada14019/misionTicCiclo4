package com.appistock.proyectostock.controller;


import com.appistock.proyectostock.converter.ProveedorHasProductoConverter;

import com.appistock.proyectostock.dtos.ProveedorHasProductoDto;

import com.appistock.proyectostock.entity.ProveedorHasProducto;
import com.appistock.proyectostock.service.ProveedorHasProductoService;
import com.appistock.proyectostock.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProveedorHasProductoController {

    @Autowired
    private ProveedorHasProductoService proveedorHasProductoService;
    private ProveedorHasProductoConverter proveedorHasProductoConverter=new ProveedorHasProductoConverter();

    @GetMapping("/proveedor_has_producto")
    public ResponseEntity<WrapperResponse<List<ProveedorHasProductoDto>>> findAll() {
        List<ProveedorHasProducto> proveedorHasProductos = proveedorHasProductoService.findAll();
        List<ProveedorHasProductoDto> proveedorHasProductoDtos=proveedorHasProductoConverter.fromEntity(proveedorHasProductos);
        return new WrapperResponse<>(true,"Succes",proveedorHasProductoDtos).createResponse(HttpStatus.OK);

    }

    @GetMapping("/proveedor_has_producto/{Id}")
    public ResponseEntity<WrapperResponse<ProveedorHasProductoDto>> findById(@PathVariable("Id") Long id) {
        ProveedorHasProducto objProveedorHasProducto = proveedorHasProductoService.findById(id);
        ProveedorHasProductoDto objProveedorHasProductoDto=proveedorHasProductoConverter.fromEntity(objProveedorHasProducto);
        return new WrapperResponse<>(true,"Id Succes",objProveedorHasProductoDto).createResponse(HttpStatus.OK);

    }

    @PostMapping("/proveedor_has_producto")
    public ResponseEntity<WrapperResponse<ProveedorHasProductoDto>> create(@RequestBody ProveedorHasProductoDto proveedorHasProductoDto) {
        ProveedorHasProducto objProveedorHasProducto = proveedorHasProductoService.create(proveedorHasProductoConverter.fromDto(proveedorHasProductoDto));
        ProveedorHasProductoDto objProveedorHasProductoDto=proveedorHasProductoConverter.fromEntity(objProveedorHasProducto);
        return new WrapperResponse<>(true,"Create Succes",objProveedorHasProductoDto).createResponse(HttpStatus.CREATED);


    }

    @PutMapping("/proveedor_has_producto")
    public ResponseEntity<WrapperResponse<ProveedorHasProductoDto>> update(@RequestBody ProveedorHasProductoDto proveedorHasProductoDto) {
        ProveedorHasProducto objProveedorHasProducto = proveedorHasProductoService.update(proveedorHasProductoConverter.fromDto(proveedorHasProductoDto));
        ProveedorHasProductoDto objProveedorHasProductoDto=proveedorHasProductoConverter.fromEntity(objProveedorHasProducto);
        return new WrapperResponse<>(true,"Update Succes",objProveedorHasProductoDto).createResponse(HttpStatus.OK);


    }

    @DeleteMapping("/proveedor_has_producto/{Id}")
    public ResponseEntity<WrapperResponse<Void>> delete(@PathVariable("Id") Long id) {
        proveedorHasProductoService.delete(id);
        return new WrapperResponse<Void>(true,"Delete Succes",null).createResponse(HttpStatus.OK);

    }
}
