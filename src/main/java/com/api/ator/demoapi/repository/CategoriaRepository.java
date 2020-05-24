package com.api.ator.demoapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoriaRepository extends JpaRepository<com.api.ator.demoapi.entity.Categoria, Long>, PagingAndSortingRepository<com.api.ator.demoapi.entity.Categoria, Long> {

    com.api.ator.demoapi.entity.Categoria findCategoriaById(Long id);

    Page<com.api.ator.demoapi.entity.Categoria> findAll(Pageable pageable);
}
