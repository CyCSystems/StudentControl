/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.util;

/**
 *
 * @author angel
 */
public class ItemComboBox {
    private String Value;
    private String Descripcion;

    public ItemComboBox(String Value, String Descripcion) {
        this.Value = Value;
        this.Descripcion = Descripcion;
    }

    public ItemComboBox(String Descripcion) {
        this.Descripcion = Descripcion;
    }
        
    public String getID(){
        return Value;
    }
    
    @Override
    public String toString(){
        return Descripcion;
    }
}
