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
public class TipoPapeleria {
    
    private Integer IdTipoPapeleria;
    private String Descripcion;

    public TipoPapeleria() {
    }

    public TipoPapeleria(Integer IdTipoPapeleria) {
        this.IdTipoPapeleria = IdTipoPapeleria;
    }

    public TipoPapeleria(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public TipoPapeleria(Integer IdTipoPapeleria, String Descripcion) {
        this.IdTipoPapeleria = IdTipoPapeleria;
        this.Descripcion = Descripcion;
    }

    public Integer getIdTipoPapeleria() {
        return IdTipoPapeleria;
    }

    public void setIdTipoPapeleria(Integer IdTipoPapeleria) {
        this.IdTipoPapeleria = IdTipoPapeleria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }    
}
