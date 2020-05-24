package com.api.ator.demoapi.converter;

import com.api.ator.demoapi.model.Categoria;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaConverter {

    public List<Categoria> convertirLista(List<com.api.ator.demoapi.entity.Categoria> categorias) {
        List<Categoria> categorias1 = new ArrayList<>();
        for (com.api.ator.demoapi.entity.Categoria cat : categorias) {
            categorias1.add(new Categoria(cat));
        }
        return categorias1;
    }
}
