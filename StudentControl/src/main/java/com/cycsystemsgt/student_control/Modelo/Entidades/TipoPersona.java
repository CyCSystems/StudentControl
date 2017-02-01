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
public class TipoPersona {
    private Integer IdTipoPersona;
    private String Descripcion;

    public TipoPersona() {
    }

    public TipoPersona(Integer IdTipoPersona) {
        this.IdTipoPersona = IdTipoPersona;
    }

    public TipoPersona(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public TipoPersona(Integer IdTipoPersona, String Descripcion) {
        this.IdTipoPersona = IdTipoPersona;
        this.Descripcion = Descripcion;
    }

    public Integer getIdTipoPersona() {
        return IdTipoPersona;
    }

    public void setIdTipoPersona(Integer IdTipoPersona) {
        this.IdTipoPersona = IdTipoPersona;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
