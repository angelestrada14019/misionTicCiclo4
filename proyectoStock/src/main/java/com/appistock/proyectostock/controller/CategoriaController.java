package com.appistock.proyectostock.controller;
import com.appistock.proyectostock.converter.CategoriaConverter;
import com.appistock.proyectostock.dtos.CategoriaDto;
import com.appistock.proyectostock.entity.Categoria;
import com.appistock.proyectostock.service.CategoriaService;
import com.appistock.proyectostock.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    private CategoriaConverter categoriaConverter=new CategoriaConverter();


    @GetMapping("/categoria")
    public ResponseEntity<WrapperResponse<List<CategoriaDto>>> findAll() {
        List<Categoria> categorias = categoriaService.findAll();
        List<CategoriaDto> categoriasDto=categoriaConverter.fromEntity(categorias);
        return new WrapperResponse<>(true,"Succes",categoriasDto).createResponse(HttpStatus.OK);

    }

    @GetMapping("/categoria/{Id}")
    public ResponseEntity<WrapperResponse<CategoriaDto>> findById(@PathVariable("Id") Long id) {
        Categoria objCategoria = categoriaService.findById(id);
        CategoriaDto objCategoriaDto=categoriaConverter.fromEntity(objCategoria);
        return new WrapperResponse<>(true,"Id Succes",objCategoriaDto).createResponse(HttpStatus.OK);

    }






}
