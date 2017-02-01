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
public class FormaPago {
    private Integer idFormaPago;
    private String descripcion;
    private boolean estado;

    public FormaPago(Integer idFormaPago, String descripcion, boolean estado) {
        this.idFormaPago = idFormaPago;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public FormaPago() {
    }

    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "FormaPago{" + "idFormaPago=" + idFormaPago + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }
}
