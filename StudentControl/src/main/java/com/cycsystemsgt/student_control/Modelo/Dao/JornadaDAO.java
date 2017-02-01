/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Jornada;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class JornadaDAO {
    Transacciones sql = new Transacciones();
    
    public ArrayList<Jornada> lista(){
        ArrayList<Jornada> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Jornada(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setBoolean(4, true);
            sql.ct.setString(5, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Jornada jornada = new Jornada();
                jornada.setIdJornada(rs.getInt("IdJornada"));
                jornada.setDescripcion(rs.getString("Descripcion"));
                jornada.setEstado(rs.getBoolean("Estado"));
                lista.add(jornada);
            }
            sql.ct.close();
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public ArrayList<Jornada> listaActivos(){
        ArrayList<Jornada> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Jornada(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 5);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setBoolean(4, true);
            sql.ct.setString(5, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Jornada jornada = new Jornada();
                jornada.setIdJornada(rs.getInt("IdJornada"));
                jornada.setDescripcion(rs.getString("Descripcion"));
                jornada.setEstado(rs.getBoolean("Estado"));
                lista.add(jornada);
            }
            sql.ct.close();
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public Boolean registrarJornada(Jornada jornada, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Jornada(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, jornada.getIdJornada());
            sql.ct.setString(3, jornada.getDescripcion());
            sql.ct.setBoolean(4, jornada.getEstado());
            sql.ct.setString(5, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarJornada(Jornada jornada, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Jornada(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, jornada.getIdJornada());
            sql.ct.setString(3, jornada.getDescripcion());
            sql.ct.setBoolean(4, jornada.getEstado());
            sql.ct.setString(5, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Jornada obtenerJornada(Integer IdJornada){
        Jornada jornada = new Jornada();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Jornada(?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdJornada);
            sql.ct.setString(3, "");
            sql.ct.setBoolean(4, true);
            sql.ct.setInt(5, 0);
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                jornada.setIdJornada(rs.getInt("IdJornada"));
                jornada.setDescripcion(rs.getString("Descripcion"));
                jornada.setEstado(rs.getBoolean("Estado"));
            }
            rs.close();
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return jornada;
    }
}
