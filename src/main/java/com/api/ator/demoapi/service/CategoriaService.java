package com.api.ator.demoapi.service;

import com.api.ator.demoapi.converter.CategoriaConverter;
import com.api.ator.demoapi.entity.Categoria;
import com.api.ator.demoapi.repository.CategoriaRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    private static final Log logger = LogFactory.getLog(CategoriaService.class);

    @Autowired
    @Qualifier("categoriaRepository")
    private CategoriaRepository categoriaRepository;

    @Autowired
    @Qualifier("categoriaConverter")
    private CategoriaConverter categoriaConverter;

    public boolean crear(Categoria categoria) {
        try {
            categoriaRepository.save(categoria);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error(e.getLocalizedMessage());
            return false;
        }
    }

    public boolean actualizar(Categoria categoria) {
        try {
            categoriaRepository.save(categoria);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error(e.getLocalizedMessage());
            return false;
        }
    }

    public boolean borrar(long cat_id) {
        try {
            Categoria categoria1 = categoriaRepository.findCategoriaById(cat_id);
            categoriaRepository.delete(categoria1);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error(e.getLocalizedMessage());
            return false;
        }
    }

    public List<com.api.ator.demoapi.model.Categoria> obtener() {
        logger.info("Obteniendo Categorias.");
        List<com.api.ator.demoapi.model.Categoria> categorias = new ArrayList<>();
        try {
            categorias = categoriaConverter.convertirLista(categoriaRepository.findAll());
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error(e.getLocalizedMessage());
        }
        return categorias;
    }

    public List<com.api.ator.demoapi.model.Categoria> obtenerPorPaginacion(Pageable pageable) {
        return categoriaConverter.convertirLista(categoriaRepository.findAll(pageable).getContent());
    }
}
