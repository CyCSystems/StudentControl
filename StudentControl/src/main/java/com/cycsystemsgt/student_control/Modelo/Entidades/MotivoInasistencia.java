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
public class MotivoInasistencia {
    private Integer IdMotivoInasistencia;
    private String Descripcion;

    public MotivoInasistencia() {
    }

    public MotivoInasistencia(Integer IdMotivoInasistencia, String Descripcion) {
        this.IdMotivoInasistencia = IdMotivoInasistencia;
        this.Descripcion = Descripcion;
    }

    public Integer getIdMotivoInasistencia() {
        return IdMotivoInasistencia;
    }

    public void setIdMotivoInasistencia(Integer IdMotivoInasistencia) {
        this.IdMotivoInasistencia = IdMotivoInasistencia;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
