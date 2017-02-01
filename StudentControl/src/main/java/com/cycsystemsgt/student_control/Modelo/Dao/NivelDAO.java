/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Nivel;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class NivelDAO {
    Transacciones sql = new Transacciones();
    
    public Boolean registrarNivel(Nivel mnivel, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Nivel(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, mnivel.getIdNivel());
            sql.ct.setString(3, mnivel.getDescripcion());
            sql.ct.setBoolean(4, mnivel.getEstado());
            sql.ct.setString(5, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarNivel(Nivel mNivel, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Nivel(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, mNivel.getIdNivel());
            sql.ct.setString(3, mNivel.getDescripcion());
            sql.ct.setBoolean(4, mNivel.getEstado());
            sql.ct.setString(5, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Nivel obtenerNivel(Integer IdNivel){
        Nivel nivel = new Nivel();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Nivel(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdNivel);
            sql.ct.setString(3, "");
            sql.ct.setBoolean(4, true);
            sql.ct.setInt(5, 0);
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                nivel.setIdNivel(rs.getInt("IdNivel"));
                nivel.setDescripcion(rs.getString("Descripcion"));
                nivel.setEstado(rs.getBoolean("Estado"));
            }
            rs.close();
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return nivel;
    }
    
    public ArrayList<Nivel> listaNivel(){
        ArrayList<Nivel> listaNivel = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Nivel(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setBoolean(4, true);
            sql.ct.setString(5, "0");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Nivel nivel = new Nivel();
                nivel.setIdNivel(rs.getInt("IdNivel"));
                nivel.setDescripcion(rs.getString("Descripcion"));
                nivel.setEstado(rs.getBoolean("Estado"));
                listaNivel.add(nivel);
            }
            rs.close();
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return listaNivel;
    }
    
    public ArrayList<Nivel> listaNivelActivos(){
        ArrayList<Nivel> listaNivel = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Nivel(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 5);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setBoolean(4, true);
            sql.ct.setString(5, "0");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Nivel nivel = new Nivel();
                nivel.setIdNivel(rs.getInt("IdNivel"));
                nivel.setDescripcion(rs.getString("Descripcion"));
                nivel.setEstado(rs.getBoolean("Estado"));
                listaNivel.add(nivel);
            }
            rs.close();
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return listaNivel;
    }
    
    
}
