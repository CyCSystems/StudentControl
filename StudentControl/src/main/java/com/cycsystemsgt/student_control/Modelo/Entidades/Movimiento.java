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
public class Movimiento {
    private int idMovimiento;
    private Date fecha;
    private double cantidad;
    private int tipoMovimiento;
    private int producto;
    private int sede;
    private double valorUnidad;
    private double costoUnidad;
    private int proveedor;

    public Movimiento(int idMovimiento, Date fecha, double cantidad, int tipoMovimiento, int producto, int sede, double valorUnidad, double costoUnidad, int proveedor) {
        this.idMovimiento = idMovimiento;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.tipoMovimiento = tipoMovimiento;
        this.producto = producto;
        this.sede = sede;
        this.valorUnidad = valorUnidad;
        this.costoUnidad = costoUnidad;
        this.proveedor = proveedor;
    }

    public Movimiento() {
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public double getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(double valorUnidad) {
        this.valorUnidad = valorUnidad;
    }

    public double getCostoUnidad() {
        return costoUnidad;
    }

    public void setCostoUnidad(double costoUnidad) {
        this.costoUnidad = costoUnidad;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", cantidad=" + cantidad + ", tipoMovimiento=" + tipoMovimiento + ", producto=" + producto + ", sede=" + sede + ", valorUnidad=" + valorUnidad + ", costoUnidad=" + costoUnidad + ", proveedor=" + proveedor + '}';
    }
}
