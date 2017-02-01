/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.TipoPersona;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class TipoPersonaDAO {
    Transacciones sql = new Transacciones();
    
    public ArrayList<TipoPersona> ListaTipos(){
        ArrayList<TipoPersona> Lista = new ArrayList<>();        
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_TipoPersona(?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                TipoPersona tipo = new TipoPersona();
                tipo.setIdTipoPersona(rs.getInt("IdTipoPersona"));
                tipo.setDescripcion(rs.getString("Descripcion"));
                Lista.add(tipo);
            }
            rs.close();
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return Lista;
    }
}
