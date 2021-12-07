package com.appistock.proyectostock.controller;

import com.appistock.proyectostock.converter.ProductoConverter;
import com.appistock.proyectostock.dtos.ProductoDto;
import com.appistock.proyectostock.entity.Producto;
import com.appistock.proyectostock.service.ProductoService;
import com.appistock.proyectostock.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    private ProductoConverter productoConverter=new ProductoConverter();

    @GetMapping("/producto")
    public ResponseEntity<WrapperResponse<List<ProductoDto>>> findAll() {
        List<Producto> productos = productoService.findAll();
        List<ProductoDto> productosDto=productoConverter.fromEntity(productos);
        return new WrapperResponse<>(true,"Succes",productosDto).createResponse(HttpStatus.OK);

    }

    @GetMapping("/producto/{Id}")
    public ResponseEntity<WrapperResponse<ProductoDto>> findById(@PathVariable("Id") Long id) {
        Producto objProducto = productoService.findById(id);
        ProductoDto objProductoDto=productoConverter.fromEntity(objProducto);
        return new WrapperResponse<>(true,"Id Succes",objProductoDto).createResponse(HttpStatus.OK);

    }

    @PostMapping("/producto")
    public ResponseEntity<WrapperResponse<ProductoDto>> create(@RequestBody ProductoDto productoDto) {
        Producto objProducto = productoService.create(productoConverter.fromDto(productoDto));
        ProductoDto objProductoDto=productoConverter.fromEntity(objProducto);
        return new WrapperResponse<>(true,"Create Succes",objProductoDto).createResponse(HttpStatus.CREATED);


    }

    @PutMapping("/producto")
    public ResponseEntity<WrapperResponse<ProductoDto>> update(@RequestBody ProductoDto productoDto) {
        Producto objProducto = productoService.update(productoConverter.fromDto(productoDto));
        ProductoDto objProductoDto=productoConverter.fromEntity(objProducto);
        return new WrapperResponse<>(true,"Update Succes",objProductoDto).createResponse(HttpStatus.OK);


    }

    @DeleteMapping("/producto/{Id}")
    public ResponseEntity<WrapperResponse<Void>> delete(@PathVariable("Id") Long id) {
        productoService.delete(id);
        return new WrapperResponse<Void>(true,"Delete Succes",null).createResponse(HttpStatus.OK);

    }
}
