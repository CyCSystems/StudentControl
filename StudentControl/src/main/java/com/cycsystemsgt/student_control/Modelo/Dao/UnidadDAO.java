/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Unidad;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class UnidadDAO {
    Transacciones sql = new Transacciones();
    
    public ArrayList<Unidad> listaUnidades(){
        ArrayList<Unidad> listaUnidades = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Unidad(?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Unidad unidad = new Unidad();
                unidad.setIdUnidad(rs.getInt("IdUnidad"));
                unidad.setDescripcion(rs.getString("Descripcion"));
                listaUnidades.add(unidad);
            }
            rs.close();
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return listaUnidades;
    }
    
    public Unidad obtenerUnidad(Integer IdUnidad){
        Unidad unidad = new Unidad();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Unidad(?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                unidad.setIdUnidad(rs.getInt("IdUnidad"));
                unidad.setDescripcion(rs.getString("Descripcion"));
            }
            rs.close();
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return unidad;
    }
    
    public Boolean registrarUnidad(Unidad mUnidad, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Unidad(?, ?, ?, ?)");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, mUnidad.getIdUnidad());
            sql.ct.setString(3, mUnidad.getDescripcion());
            sql.ct.setString(4, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarUnidad(Unidad mUnidad, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Unidad(?, ?, ?, ?)");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, mUnidad.getIdUnidad());
            sql.ct.setString(3, mUnidad.getDescripcion());
            sql.ct.setString(4, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
