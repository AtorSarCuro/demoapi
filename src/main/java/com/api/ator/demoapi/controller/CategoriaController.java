package com.api.ator.demoapi.controller;

import com.api.ator.demoapi.entity.Categoria;
import com.api.ator.demoapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CategoriaController {

    @Autowired
    @Qualifier("categoriaService")
    CategoriaService categoriaService;

    @PostMapping("/categoria")
    public boolean agregarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.crear(categoria);
    }

    @PutMapping("/categoria")
    public boolean actualizaCategoria(@RequestBody Categoria categoria) {
        return categoriaService.actualizar(categoria);
    }

    @DeleteMapping("/categoria/{id}")
    public boolean borraCategoria(@PathVariable("id") long cat_id) {
        return categoriaService.borrar(cat_id);
    }

    @GetMapping("/categoria")
    public List<com.api.ator.demoapi.model.Categoria> obtenerCategorias(Pageable pageable) {
        return categoriaService.obtenerPorPaginacion(pageable);
    }
}
