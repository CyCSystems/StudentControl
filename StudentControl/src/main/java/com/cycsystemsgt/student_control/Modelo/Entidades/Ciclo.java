/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Entidades;

import java.math.BigDecimal;

/**
 *
 * @author angel
 */

public class Ciclo {
    private Integer idCiclo;
    private String ciclo;
    private int cantidadUnidades;
    private Integer notaMinima;
    private Integer diaPago;
    private BigDecimal moraDia;
    private Boolean estado;

    public Ciclo() {
    }

    public Ciclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Ciclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Ciclo(Integer idCiclo, String ciclo, int cantidadUnidades) {
        this.idCiclo = idCiclo;
        this.ciclo = ciclo;
        this.cantidadUnidades = cantidadUnidades;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public Integer getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(Integer notaMinima) {
        this.notaMinima = notaMinima;
    }

    public Integer getDiaPago() {
        return diaPago;
    }

    public void setDiaPago(Integer diaPago) {
        this.diaPago = diaPago;
    }

    public BigDecimal getMoraDia() {
        return moraDia;
    }

    public void setMoraDia(BigDecimal moraDia) {
        this.moraDia = moraDia;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
