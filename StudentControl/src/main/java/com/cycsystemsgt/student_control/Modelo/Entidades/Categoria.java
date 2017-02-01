/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Entidades;
/**
 *
 * @author angel
 */

public class Categoria{
    private Integer idCategoria;
    private String descripcion;
    private String ordenCategoria;
    private Integer categoriaBase;
    private Boolean Estado;

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }

    public Categoria() {
    }

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(Integer idCategoria, String descripcion) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrdenCategoria() {
        return ordenCategoria;
    }

    public void setOrdenCategoria(String ordenCategoria) {
        this.ordenCategoria = ordenCategoria;
    }

    public Integer getCategoriaBase() {
        return categoriaBase;
    }

    public void setCategoriaBase(Integer categoriaBase) {
        this.categoriaBase = categoriaBase;
    }
}
