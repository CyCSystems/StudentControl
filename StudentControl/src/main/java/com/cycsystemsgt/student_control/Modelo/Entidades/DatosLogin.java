/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Entidades;

/**
 *
 * @author Emmanuel Rodas
 */
public class DatosLogin {
    private String IdPersona;
    private String PNombre;
    private String PApellido;
    private String Rol;
    private Boolean EstadoPersona;
    private Boolean EstadoRol;
    private String Departamento;
    private String TipoDepartamento;

    public DatosLogin() {
    }

    public String getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(String IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getPNombre() {
        return PNombre;
    }

    public void setPNombre(String PNombre) {
        this.PNombre = PNombre;
    }

    public String getPApellido() {
        return PApellido;
    }

    public void setPApellido(String SNombre) {
        this.PApellido = SNombre;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public Boolean isEstadoPersona() {
        return EstadoPersona;
    }

    public void setEstadoPersona(Boolean EstadoPersona) {
        this.EstadoPersona = EstadoPersona;
    }

    public Boolean isEstadoRol() {
        return EstadoRol;
    }

    public void setEstadoRol(Boolean EstadoRol) {
        this.EstadoRol = EstadoRol;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getTipoDepartamento() {
        return TipoDepartamento;
    }

    public void setTipoDepartamento(String TipoDepartamento) {
        this.TipoDepartamento = TipoDepartamento;
    }
}
