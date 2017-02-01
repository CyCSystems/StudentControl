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
public class Grado {
    private Integer IdGrado;
    private String Descripcion;
    private Integer Nivel;
    private Integer Jornada;
    private Integer Seccion;
    private Boolean Estado;

    public Grado(Integer IdGrado, String Descripcion, Integer Nivel, Integer Jornada, Integer Seccion, Boolean Estado) {
        this.IdGrado = IdGrado;
        this.Descripcion = Descripcion;
        this.Nivel = Nivel;
        this.Jornada = Jornada;
        this.Seccion = Seccion;
        this.Estado = Estado;
    }

    public Grado() {
    }

    public Integer getIdGrado() {
        return IdGrado;
    }

    public void setIdGrado(Integer IdGrado) {
        this.IdGrado = IdGrado;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getNivel() {
        return Nivel;
    }

    public void setNivel(Integer Nivel) {
        this.Nivel = Nivel;
    }

    public Integer getJornada() {
        return Jornada;
    }

    public void setJornada(Integer Jornada) {
        this.Jornada = Jornada;
    }

    public Integer getSeccion() {
        return Seccion;
    }

    public void setSeccion(Integer Seccion) {
        this.Seccion = Seccion;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }
    
    
}
