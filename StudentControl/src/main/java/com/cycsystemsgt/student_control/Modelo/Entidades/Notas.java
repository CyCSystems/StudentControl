/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Entidades;

import java.util.Objects;

/**
 *
 * @author angel
 */
public class Notas {
    private Integer IdNota;
    private String Persona;
    private Integer Unidad;
    private Double Zona;
    private Double Examen;
    private Double Total;
    private Integer Materia;
    private Integer Ciclo;

    public Notas() {
    }

    public Notas(Integer IdNota, String Persona, Integer Unidad, Double Zona, Double Examen, Double Total, Integer Materia, Integer Ciclo) {
        this.IdNota = IdNota;
        this.Persona = Persona;
        this.Unidad = Unidad;
        this.Zona = Zona;
        this.Examen = Examen;
        this.Total = Total;
        this.Materia = Materia;
        this.Ciclo = Ciclo;
    }

    public Integer getIdNota() {
        return IdNota;
    }

    public void setIdNota(Integer IdNota) {
        this.IdNota = IdNota;
    }

    public String getPersona() {
        return Persona;
    }

    public void setPersona(String Persona) {
        this.Persona = Persona;
    }

    public Integer getUnidad() {
        return Unidad;
    }

    public void setUnidad(Integer Unidad) {
        this.Unidad = Unidad;
    }

    public Double getZona() {
        return Zona;
    }

    public void setZona(Double Zona) {
        this.Zona = Zona;
    }

    public Double getExamen() {
        return Examen;
    }

    public void setExamen(Double Examen) {
        this.Examen = Examen;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public Integer getMateria() {
        return Materia;
    }

    public void setMateria(Integer Materia) {
        this.Materia = Materia;
    }

    public Integer getCiclo() {
        return Ciclo;
    }

    public void setCiclo(Integer Ciclo) {
        this.Ciclo = Ciclo;
    }

    @Override
    public String toString() {
        return "Notas{" + "IdNota=" + IdNota + ", Persona=" + Persona + ", Unidad=" + Unidad + ", Zona=" + Zona + ", Examen=" + Examen + ", Total=" + Total + ", Materia=" + Materia + ", Ciclo=" + Ciclo + '}';
    }
    
    
}
