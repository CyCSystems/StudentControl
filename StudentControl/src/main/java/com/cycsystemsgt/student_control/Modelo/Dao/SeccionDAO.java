/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Seccion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class SeccionDAO {
    Transacciones sql = new Transacciones();
    
    public ArrayList<Seccion> listaSecciones(){
        ArrayList<Seccion> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Seccion(?, ?, ?);");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Seccion seccion = new Seccion();
                seccion.setIdSeccion(rs.getInt("IdSeccion"));
                seccion.setDescripcion(rs.getString("Descripcion"));
                lista.add(seccion);
            }
            sql.ct.close();
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public Seccion obtenerSeccion(Integer IdSeccion){
        Seccion seccion = new Seccion();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Seccion(?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdSeccion);
            sql.ct.setString(3, "");
            ResultSet rs = sql.ct.executeQuery();
            if(rs.next() == true){
                seccion.setIdSeccion(rs.getInt("IdSeccion"));
                seccion.setDescripcion(rs.getString("Descripcion"));
            }
            sql.ct.close();
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return seccion;
    }
}
