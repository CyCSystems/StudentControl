/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Entidades;

import java.sql.Date;

/**
 *
 * @author angel
 */
public class Inasistencia {
    private Integer idInasistencia;
    private Date fechaInasistencia;
    private String persona;
    private Integer motivoInasistencia;

    public Inasistencia(Integer idInasistencia, Date fechaInasistencia, String persona, Integer motivoInasistencia) {
        this.idInasistencia = idInasistencia;
        this.fechaInasistencia = fechaInasistencia;
        this.persona = persona;
        this.motivoInasistencia = motivoInasistencia;
    }

    public Inasistencia() {
    }

    public Integer getIdInasistencia() {
        return idInasistencia;
    }

    public void setIdInasistencia(Integer idInasistencia) {
        this.idInasistencia = idInasistencia;
    }

    public Date getFechaInasistencia() {
        return fechaInasistencia;
    }

    public void setFechaInasistencia(Date fechaInasistencia) {
        this.fechaInasistencia = fechaInasistencia;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public Integer getMotivoInasistencia() {
        return motivoInasistencia;
    }

    public void setMotivoInasistencia(Integer motivoInasistencia) {
        this.motivoInasistencia = motivoInasistencia;
    }
    
    
}
    
