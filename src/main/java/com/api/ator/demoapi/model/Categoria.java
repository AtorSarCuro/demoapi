package com.api.ator.demoapi.model;

public class Categoria {

    private long cat_id;
    private String descripcion;
    private String alias;

    public Categoria() {
    }

    public Categoria(com.api.ator.demoapi.entity.Categoria categoria) {
        this.cat_id = categoria.getId();
        this.descripcion = categoria.getDescripcion();
        this.alias = categoria.getAlias();
    }


    public Categoria(long cat_id, String descripcion, String alias) {
        this.cat_id = cat_id;
        this.descripcion = descripcion;
        this.alias = alias;
    }

    public long getCat_id() {
        return cat_id;
    }

    public void setCat_id(long cat_id) {
        this.cat_id = cat_id;
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
