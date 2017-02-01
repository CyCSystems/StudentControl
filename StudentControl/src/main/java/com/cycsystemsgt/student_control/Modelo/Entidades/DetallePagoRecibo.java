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
public class DetallePagoRecibo {
    private Integer idDetallePago;
    private Double abono;
    private String numeroDocumento;
    private Integer cuota;
    private Integer formaPago;
    private Integer recibo;

    public DetallePagoRecibo(Integer idDetallePago, Double abono, String numeroDocumento, Integer cuota, Integer formaPago, Integer recibo) {
        this.idDetallePago = idDetallePago;
        this.abono = abono;
        this.numeroDocumento = numeroDocumento;
        this.cuota = cuota;
        this.formaPago = formaPago;
        this.recibo = recibo;
    }

    public DetallePagoRecibo() {
    }

    public Integer getIdDetallePago() {
        return idDetallePago;
    }

    public void setIdDetallePago(Integer idDetallePago) {
        this.idDetallePago = idDetallePago;
    }

    public Double getAbono() {
        return abono;
    }

    public void setAbono(Double abono) {
        this.abono = abono;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getCuota() {
        return cuota;
    }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    public Integer getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(Integer formaPago) {
        this.formaPago = formaPago;
    }

    public Integer getRecibo() {
        return recibo;
    }

    public void setRecibo(Integer recibo) {
        this.recibo = recibo;
    }

    @Override
    public String toString() {
        return "DetallePagoRecibo{" + "idDetallePago=" + idDetallePago + ", abono=" + abono + ", numeroDocumento=" + numeroDocumento + ", cuota=" + cuota + ", formaPago=" + formaPago + ", recibo=" + recibo + '}';
    }
}
