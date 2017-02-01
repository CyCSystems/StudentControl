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
public class Telefono {
    private Integer IdTelefono;
    private String Telefono;
    private String Persona;

    public Telefono(String Telefono, String Persona) {
        this.Telefono = Telefono;
        this.Persona = Persona;
    }

    public Telefono() {
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getPersona() {
        return Persona;
    }

    public void setPersona(String Persona) {
        this.Persona = Persona;
    }

    public Integer getIdTelefono() {
        return IdTelefono;
    }

    public void setIdTelefono(Integer IdTelefono) {
        this.IdTelefono = IdTelefono;
    }
}
