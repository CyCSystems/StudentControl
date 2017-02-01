/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.TipoPapeleria;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class TipoPapeleriaDAO {
    Transacciones sql = new Transacciones();
    
    public ArrayList<TipoPapeleria> ListaTipoPepeleria(){
        ArrayList<TipoPapeleria> ListaTipoPapeleria = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_TipoPapeleria(?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                TipoPapeleria tipo = new TipoPapeleria();
                tipo.setIdTipoPapeleria(rs.getInt("IdTipoPapeleria"));
                tipo.setDescripcion(rs.getString("Descripcion"));
                ListaTipoPapeleria.add(tipo);
            }
            rs.close();
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return ListaTipoPapeleria;
    }
}
