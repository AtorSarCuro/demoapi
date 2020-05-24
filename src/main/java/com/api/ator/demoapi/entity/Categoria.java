package com.api.ator.demoapi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "categorias")
@Entity
public class Categoria implements Serializable {

    public Categoria() {
        //constructor
    }

    @GeneratedValue
    @Id
    @Column(name = "cat_id")
    private long id;

    @Column(name = "cat_descripcion")
    private String descripcion;

    @Column(name = "cat_alias")
    private String alias;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
