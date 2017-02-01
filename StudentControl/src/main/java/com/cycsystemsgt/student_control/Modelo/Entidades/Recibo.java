/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Entidades;

import java.sql.Timestamp;

/**
 *
 * @author angel
 */
public class Recibo {
    private Integer IdRecibo;
    private Timestamp fechaVenta;
    private Double total;
    private Boolean estado;
    private Integer cliente;
    private Integer empleado;
    private Integer coutas;
    private String alumno;
    private Double descuento;

    public Recibo() {
    }

    public Recibo(Integer IdRecibo, Timestamp fechaVenta, Double descuento, Double total, Boolean estado, Integer cliente, Integer empleado, Integer coutas) {
        this.IdRecibo = IdRecibo;
        this.fechaVenta = fechaVenta;
        this.descuento = descuento;
        this.total = total;
        this.estado = estado;
        this.cliente = cliente;
        this.empleado = empleado;
        this.coutas = coutas;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }   

    public Integer getIdRecibo() {
        return IdRecibo;
    }

    public void setIdRecibo(Integer IdRecibo) {
        this.IdRecibo = IdRecibo;
    }

    public Timestamp getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Timestamp fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Integer empleado) {
        this.empleado = empleado;
    }

    public Integer getCoutas() {
        return coutas;
    }

    public void setCoutas(Integer coutas) {
        this.coutas = coutas;
    }

    @Override
    public String toString() {
        return "Recibo{" + "IdRecibo=" + IdRecibo + ", fechaVenta=" + fechaVenta + ", total=" + total + ", estado=" + estado + ", cliente=" + cliente + ", empleado=" + empleado + ", coutas=" + coutas + '}';
    }
}
