/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Telefono;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class TelefonoDAO {
    Transacciones sql = new Transacciones();
    
    public Telefono getTelefono(String IdPersona){
        Telefono telefono = new Telefono();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Telefono(?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setString(4, IdPersona);
            ResultSet rs = sql.ct.executeQuery();
            if(rs.next() == true){
                telefono.setIdTelefono(rs.getInt("IdTelefono"));
                telefono.setTelefono(rs.getString("Numero"));
                telefono.setPersona(rs.getString("Persona"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return telefono;
    }
}
