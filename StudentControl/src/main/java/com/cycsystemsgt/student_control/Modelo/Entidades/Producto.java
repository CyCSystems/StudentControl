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
public class Producto {
    private Integer idProducto;
    private String descripcion;
    private Double existencias;
    private Integer categoria;
    private Integer estado;

    public Producto() {
    }

    public Producto(Integer idProducto, String descripcion, Double existencias, Integer categoria, Integer estado) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.categoria = categoria;
        this.estado = estado;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getExistencias() {
        return existencias;
    }

    public void setExistencias(Double existencias) {
        this.existencias = existencias;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", descripcion=" + descripcion + ", existencias=" + existencias + ", categoria=" + categoria + ", estado=" + estado + '}';
    }
}
