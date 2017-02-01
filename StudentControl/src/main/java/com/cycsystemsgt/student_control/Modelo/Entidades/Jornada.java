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
public class Jornada {
    private Integer IdJornada;
    private String Descripcion;
    private Boolean Estado;

    public Jornada(Integer IdJornada, String Descripcion, Boolean Estado) {
        this.IdJornada = IdJornada;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public Jornada() {
    }

    public Integer getIdJornada() {
        return IdJornada;
    }

    public void setIdJornada(Integer IdJornada) {
        this.IdJornada = IdJornada;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }
    
    
}
