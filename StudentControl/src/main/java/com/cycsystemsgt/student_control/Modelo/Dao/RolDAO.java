/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class RolDAO {
    Transacciones sql = new Transacciones();
    
    public Integer getIdRol(Integer TipoPersona){
        Integer Id = 0;
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Rol(?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setBoolean(4, false);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, TipoPersona);
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                Id = rs.getInt("Id");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return Id;
    }
    
}
