/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Entidades;

import java.util.Date;


/**
 *
 * @author angel
 */
public class Persona {
    private String idPersona;
    private String pNombre;
    private String sNombre;
    private String tNombre;
    private String pApellido;
    private String sApellido;
    private Date fechaNacimiento;
    private String direccion;
    private String personacol;
    private Date fechaIngreso;
    private boolean estado;
    private String usuario;
    private String pass;
    private Boolean pagaExtras;
    private int genero;
    private String encargado;
    private int rol;
    private int tipoPersona;
    
    public Persona() {
    }

    public Persona(String idPersona) {
        this.idPersona = idPersona;
    }
    
    public Persona(String idPersona, String pNombre, String pApellido) {
        this.idPersona = idPersona;
        this.pNombre = pNombre;
        this.pApellido = pApellido;
    }

    public Persona(String idPersona, String pNombre, String sNombre, String tNombre, String pApellido, String sApelido, Date fechaNacimiento, String direccion, String personacol, Date fechaIngreso, boolean estado) {
        this.idPersona = idPersona;
        this.pNombre = pNombre;
        this.sNombre = sNombre;
        this.tNombre = tNombre;
        this.pApellido = pApellido;
        this.sApellido = sApelido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.personacol = personacol;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getPNombre() {
        return pNombre;
    }

    public void setPNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getSNombre() {
        return sNombre;
    }

    public void setSNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getTNombre() {
        return tNombre;
    }

    public void setTNombre(String tNombre) {
        this.tNombre = tNombre;
    }

    public String getPApellido() {
        return pApellido;
    }

    public void setPApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getSApelido() {
        return sApellido;
    }

    public void setSApelido(String sApelido) {
        this.sApellido = sApelido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPersonacol() {
        return personacol;
    }

    public void setPersonacol(String personacol) {
        this.personacol = personacol;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getPagaExtras() {
        return pagaExtras;
    }

    public void setPagaExtras(Boolean pagaExtras) {
        this.pagaExtras = pagaExtras;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(int tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    
    
}
