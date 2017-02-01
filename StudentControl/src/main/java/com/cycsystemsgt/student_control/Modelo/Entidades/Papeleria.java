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
public class Papeleria {
    private Integer IdPapeleria;
    private Integer IdTipoPapeleria;
    private String TipoPapeleria;
    private String Persona;
    private String Descripcion;

    public Papeleria(Integer IdPapeleria, String TipoPapeleria, String Persona, String Descripcion) {
        this.IdPapeleria = IdPapeleria;
        this.TipoPapeleria = TipoPapeleria;
        this.Persona = Persona;
        this.Descripcion = Descripcion;
    }

    public Papeleria() {
    }

    public Integer getIdPapeleria() {
        return IdPapeleria;
    }

    public void setIdPapeleria(Integer IdPapeleria) {
        this.IdPapeleria = IdPapeleria;
    }

    public String getTipoPapeleria() {
        return TipoPapeleria;
    }

    public void setTipoPapeleria(String TipoPapeleria) {
        this.TipoPapeleria = TipoPapeleria;
    }

    public String getPersona() {
        return Persona;
    }

    public void setPersona(String Persona) {
        this.Persona = Persona;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getIdTipoPapeleria() {
        return IdTipoPapeleria;
    }

    public void setIdTipoPapeleria(Integer IdTipoPapeleria) {
        this.IdTipoPapeleria = IdTipoPapeleria;
    }
    
    
}
