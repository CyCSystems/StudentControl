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
public class Aplicacion{

    private Integer idAplicaion;
    private String aplicacion;
    private boolean Estado;
    
    public Aplicacion() {
    }

    public Aplicacion(Integer idAplicaion) {
        this.idAplicaion = idAplicaion;
    }

    public Aplicacion(Integer idAplicaion, String aplicacion) {
        this.idAplicaion = idAplicaion;
        this.aplicacion = aplicacion;
    }

    public Integer getIdAplicaion() {
        return idAplicaion;
    }

    public void setIdAplicaion(Integer idAplicaion) {
        this.idAplicaion = idAplicaion;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public boolean getEstado(){
        return Estado;
    }
    
    public void setEstado(boolean Estado){
        this.Estado = Estado;
    }
}
