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
public class Detalle {
    private Integer idDetalle;
    private Integer recibo;
    private Integer Cantidad;
    private Double descuento;
    private Double subTotal;
    private Integer producto;
    private Integer mes;

    public Detalle(Integer idDetalle, Integer recibo, Integer Cantidad, Double subTotal, Integer producto, Integer mes) {
        this.idDetalle = idDetalle;
        this.recibo = recibo;
        this.Cantidad = Cantidad;
        this.subTotal = subTotal;
        this.producto = producto;
        this.mes = mes;
    }
    
    /**
     * Get the value of descuento
     *
     * @return the value of descuento
     */
    public Double getDescuento() {
        return descuento;
    }

    /**
     * Set the value of descuento
     *
     * @param descuento new value of descuento
     */
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Detalle() {
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getRecibo() {
        return recibo;
    }

    public void setRecibo(Integer recibo) {
        this.recibo = recibo;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "Detalle{" + "idDetalle=" + idDetalle + ", recibo=" + recibo + ", Cantidad=" + Cantidad + ", subTotal=" + subTotal + ", producto=" + producto + ", mes=" + mes + '}';
    }
}
