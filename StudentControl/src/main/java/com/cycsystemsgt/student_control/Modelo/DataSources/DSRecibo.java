/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.DataSources;

import com.cycsystemsgt.student_control.Controlador.Coordinador;
import com.cycsystemsgt.student_control.Modelo.Entidades.Detalle;
import com.cycsystemsgt.student_control.Modelo.Entidades.Recibo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author angel
 */
public class DSRecibo implements JRDataSource {
    private List<Detalle> detalle = new ArrayList<>();
    private int indiceDetalleActual = -1;
    private Recibo recibo = null;
    private final Coordinador coordinador;
    private final String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto"," ;Septiembre"
            ,"Octubre","Noviembre","Diciemrbre"};
    private Double sumaSubTotal = 0.0;
    private double sumaDescuento;
    DecimalFormat formato = new DecimalFormat("#,##0.00");
    
    public DSRecibo(Coordinador coordinador, List<Detalle> detalle, Recibo recibo) {
        this.recibo = recibo;
        this.detalle = detalle;
        this.coordinador = coordinador;
        detalle.stream().forEach((det) -> {
            if(det.getMes() != null){
                sumaSubTotal = sumaSubTotal + det.getSubTotal();
            }else{
                if(recibo.getDescuento() > 0){
                    sumaDescuento = sumaDescuento + ((recibo.getDescuento() / 100) * (coordinador.obtenerPrecioActual(det.getProducto()).getValorUnidad() * det.getCantidad()));
                }else if(det.getDescuento() > 0){
                    sumaDescuento = sumaDescuento + ((det.getDescuento() / 100) * (coordinador.obtenerPrecioActual(det.getProducto()).getValorUnidad() * det.getCantidad()));
                }
            }
        });
    }

    @SuppressWarnings({"empty-statement", "UnusedAssignment"})
    @Override
    public Object getFieldValue(JRField jrf) throws JRException
    {
        Object valor = null;

        if (null != jrf.getName())
        switch (jrf.getName()) {
            case "IdRecibo":
                if(recibo.getIdRecibo() < 10){
                    valor = "000" + recibo.getIdRecibo();
                }else if(recibo.getIdRecibo() < 100){
                    valor = "00" + recibo.getIdRecibo();
                }else if(recibo.getIdRecibo() < 1000){
                    valor = recibo.getIdRecibo().toString();
                }                
                break;
            case "fechaVenta":
                valor = recibo.getFechaVenta();
                break;
            case "total":
                String total ="Q " + recibo.getTotal().toString();
                valor = total;
                break;
            case "estado":
                valor = recibo.getEstado().toString();
                break;
            case "cliente":
                valor = coordinador.buscarPersona(recibo.getCliente().toString()).getPNombre() + " " + coordinador.buscarPersona(recibo.getCliente().toString()).getPApellido();
                break;
            case "usuario":
                valor = coordinador.buscarPersona(recibo.getEmpleado().toString()).getPNombre() + " " + coordinador.buscarPersona(recibo.getEmpleado().toString()).getPApellido();
                break;
            case "cuotas":
                valor = recibo.getCoutas().toString();
                break;
            case "Cantidad":
                valor = detalle.get(indiceDetalleActual).getCantidad().toString();
                break;
            case "subTotal":
                String subTotal = "Q " +  (detalle.get(indiceDetalleActual).getSubTotal());
                valor = subTotal;
                break;
            case "producto":
                valor = (detalle.get(indiceDetalleActual).getProducto() == null ? meses[detalle.get(indiceDetalleActual).getMes() - 1] : coordinador.obtenerProducto(detalle.get(indiceDetalleActual).getProducto()).getDescripcion());
                break;
            case "direccion":
                valor = coordinador.buscarPersona(recibo.getEmpleado().toString()).getDireccion();
                break;
            case "mora":
                valor = (detalle.get(indiceDetalleActual).getMes() != null ? "Mora" : "Descuento");
                break;
            case "valorMora":
                if(detalle.get(indiceDetalleActual).getMes() != null){
                    valor = "Q " + (recibo.getTotal() - sumaSubTotal);
                }else{
                    valor = "Q." + sumaDescuento;
                }
                break;
            case "Alumno":
                valor = coordinador.buscarPersona(recibo.getAlumno()).getPNombre() + " " + coordinador.buscarPersona(recibo.getAlumno()).getPApellido();
                break;
            default:
                break;
        };
        return valor;
    }
    
    @Override
    public boolean next() throws JRException {
        return ++indiceDetalleActual < detalle.size();
    }
    
    public void addRecibo(Detalle detalle, Recibo recibo)
    {
        this.detalle.add(detalle);
        if(this.recibo == null){
            this.recibo = recibo;
        }
    }
}
