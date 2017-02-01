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
public class Materia {
    private Integer IdMateria;
    private String Descripcion;
    private Integer Grado;
    private Boolean Estado;

    public Materia() {
    }

    public Materia(Integer IdMateria, String Descripcion, Integer Grado, Boolean Estado) {
        this.IdMateria = IdMateria;
        this.Descripcion = Descripcion;
        this.Grado = Grado;
        this.Estado = Estado;
    }

    public Integer getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(Integer IdMateria) {
        this.IdMateria = IdMateria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getGrado() {
        return Grado;
    }

    public void setGrado(Integer Grado) {
        this.Grado = Grado;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }
    
    
}
