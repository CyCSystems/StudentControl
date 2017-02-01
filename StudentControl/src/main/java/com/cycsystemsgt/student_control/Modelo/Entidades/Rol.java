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
public class Rol {
    private Integer IdRol;
    private String Descripcion;
    private Boolean Estado;
    private Integer Departamento;
    private Integer TipoPersona;

    public Rol(Integer IdRol, String Descripcion, Boolean Estado, Integer Departamento, Integer TipoPersona) {
        this.IdRol = IdRol;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
        this.Departamento = Departamento;
        this.TipoPersona = TipoPersona;
    }

    public Rol() {
    }

    public Integer getIdRol() {
        return IdRol;
    }

    public void setIdRol(Integer IdRol) {
        this.IdRol = IdRol;
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

    public Integer getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(Integer Departamento) {
        this.Departamento = Departamento;
    }

    public Integer getTipoPersona() {
        return TipoPersona;
    }

    public void setTipoPersona(Integer TipoPersona) {
        this.TipoPersona = TipoPersona;
    }
    
    
}
