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
public class Seccion {
    private Integer IdSeccion;
    private String Descripcion;

    public Seccion(Integer IdSeccion, String Descripcion) {
        this.IdSeccion = IdSeccion;
        this.Descripcion = Descripcion;
    }

    public Seccion() {
    }

    public Integer getIdSeccion() {
        return IdSeccion;
    }

    public void setIdSeccion(Integer IdSeccion) {
        this.IdSeccion = IdSeccion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
