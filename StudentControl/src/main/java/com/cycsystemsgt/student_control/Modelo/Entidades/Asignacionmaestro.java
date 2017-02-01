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
public class Asignacionmaestro{

    private Integer idAsignacion;
    private String fechaAsignacion;
    private Boolean estado;
    private int ciclo;
    private int materia;
    private String persona;

    public Asignacionmaestro() {
    }

    public Asignacionmaestro(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Asignacionmaestro(Integer idAsignacion, String fechaAsignacion) {
        this.idAsignacion = idAsignacion;
        this.fechaAsignacion = fechaAsignacion;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getMateria() {
        return materia;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }
}
