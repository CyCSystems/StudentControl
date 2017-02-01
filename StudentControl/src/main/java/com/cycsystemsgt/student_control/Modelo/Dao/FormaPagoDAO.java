/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.FormaPago;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class FormaPagoDAO {
    Transacciones sql = new Transacciones();
    
    public List<FormaPago> obtenerFormaPago(){
        List<FormaPago> lista = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_FormaPago(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setBoolean(4, false);
            sql.ct.setString(5, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                FormaPago formaPago = new FormaPago();
                formaPago.setIdFormaPago(rs.getInt("IdFormaPago"));
                formaPago.setDescripcion(rs.getString("Descripcion"));
                formaPago.setEstado(rs.getBoolean("Estado"));
                lista.add(formaPago);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
}
