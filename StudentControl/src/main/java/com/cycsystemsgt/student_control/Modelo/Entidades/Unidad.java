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
public class Unidad {
    private Integer IdUnidad; 
    private String Descripcion;

    public Unidad() {
    }

    public Unidad(Integer IdUnidad, String Descripcion) {
        this.IdUnidad = IdUnidad;
        this.Descripcion = Descripcion;
    }

    public Integer getIdUnidad() {
        return IdUnidad;
    }

    public void setIdUnidad(Integer IdUnidad) {
        this.IdUnidad = IdUnidad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
