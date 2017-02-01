/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Entidades;

import java.math.BigDecimal;
import java.sql.Date;
/**
 *
 * @author angel
 */

public class AsignacionAlumno {
    
    private Integer idAsignacion;
    private Date fechaAsignacion;
    private BigDecimal inscripcion;
    private BigDecimal mensualidad;
    private int ciclo;
    private int grado;
    private String persona;
    private boolean Estado;

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public AsignacionAlumno() {
    }

    public AsignacionAlumno(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public AsignacionAlumno(Integer idAsignacion, Date fechaAsignacion) {
        this.idAsignacion = idAsignacion;
        this.fechaAsignacion = fechaAsignacion;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public BigDecimal getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(BigDecimal inscripcion) {
        this.inscripcion = inscripcion;
    }

    public BigDecimal getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(BigDecimal mensualidad) {
        this.mensualidad = mensualidad;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }    
}
