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
public class Documento {
    private Integer IdDocumento;
    private String Numero;
    private Integer TipoDocumento;
    private String Tipo;
    private String Persona;

    public Documento(Integer IdDocumento, String Numero, Integer TipoDocumento, String Persona) {
        this.IdDocumento = IdDocumento;
        this.Numero = Numero;
        this.TipoDocumento = TipoDocumento;
        this.Persona = Persona;
    }

    public Documento() {
    }

    public Integer getIdDocumento() {
        return IdDocumento;
    }

    public void setIdDocumento(Integer IdDocumento) {
        this.IdDocumento = IdDocumento;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public Integer getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(Integer TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public String getPersona() {
        return Persona;
    }

    public void setPersona(String Persona) {
        this.Persona = Persona;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
