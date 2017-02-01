package com.cycsystemsgt.student_control.Modelo.Entidades;


/**
 *
 * @author Emmanuel Rodas
 */

public class Nivel {
    
    private int IdNivel;
    private String Descripcion;
    private Boolean Estado;

    public Nivel() {
    }

    public int getIdNivel() {
        return IdNivel;
    }

    public void setIdNivel(int IdNivel) {
        this.IdNivel = IdNivel;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }
}
