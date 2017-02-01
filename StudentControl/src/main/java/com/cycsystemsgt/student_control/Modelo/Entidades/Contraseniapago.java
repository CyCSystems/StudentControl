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
public class Contraseniapago{
    private Integer idContraseniaPago;
    private String fecha;
    private String fechaCobro;
    private Integer proveedor;

    public Contraseniapago() {
    }

    public Contraseniapago(Integer idContraseniaPago) {
        this.idContraseniaPago = idContraseniaPago;
    }

    public Contraseniapago(Integer idContraseniaPago, String fecha, String fechaCobro) {
        this.idContraseniaPago = idContraseniaPago;
        this.fecha = fecha;
        this.fechaCobro = fechaCobro;
    }

    public Integer getIdContraseniaPago() {
        return idContraseniaPago;
    }

    public void setIdContraseniaPago(Integer idContraseniaPago) {
        this.idContraseniaPago = idContraseniaPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(String fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public Integer getProveedor() {
        return proveedor;
    }

    public void setProveedor(Integer proveedor) {
        this.proveedor = proveedor;
    }
}
