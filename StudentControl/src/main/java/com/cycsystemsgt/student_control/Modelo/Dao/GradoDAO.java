/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Grado;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class GradoDAO {
    Transacciones sql = new Transacciones();
    
    public Boolean registrarGrado(Grado grado, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Grado(?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, grado.getIdGrado());
            sql.ct.setString(3, grado.getDescripcion());
            sql.ct.setInt(4, grado.getNivel());
            sql.ct.setInt(5, grado.getJornada());
            sql.ct.setInt(6, grado.getSeccion());
            sql.ct.setBoolean(7, grado.getEstado());
            sql.ct.setString(8, Usuario);
            sql.ct.executeUpdate();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarGrado(Grado grado, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Grado(?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, grado.getIdGrado());
            sql.ct.setString(3, grado.getDescripcion());
            sql.ct.setInt(4, grado.getNivel());
            sql.ct.setInt(5, grado.getJornada());
            sql.ct.setInt(6, grado.getSeccion());
            sql.ct.setBoolean(7, grado.getEstado());
            sql.ct.setString(8, Usuario);
            sql.ct.executeUpdate();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Grado obtenerGrado(Integer IdGrado){
        Grado grado = new Grado();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Grado(?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdGrado);
            sql.ct.setString(3, "");
            sql.ct.setInt(4, 0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, 0);
            sql.ct.setBoolean(7, true);
            sql.ct.setString(8, "0");
            ResultSet rs = sql.ct.executeQuery();
            if(rs.next() == true){
                grado.setIdGrado(rs.getInt("IdGrado"));
                grado.setDescripcion(rs.getString("Descripcion"));
                grado.setNivel(rs.getInt("Nivel"));
                grado.setJornada(rs.getInt("Jornada"));
                grado.setSeccion(rs.getInt("Seccion"));
                grado.setEstado(rs.getBoolean("Estado"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return grado;
    }
    
    public ArrayList<Grado> listaGrados(){
        ArrayList<Grado> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Grado(?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setInt(4, 0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, 0);
            sql.ct.setBoolean(7, true);
            sql.ct.setString(8, "1");
            try (ResultSet rs = sql.ct.executeQuery()) {
                while(rs.next() == true){
                    Grado grado = new Grado();
                    grado.setIdGrado(rs.getInt("IdGrado"));
                    grado.setDescripcion(rs.getString("Descripcion"));
                    grado.setNivel(rs.getInt("Nivel"));
                    grado.setJornada(rs.getInt("Jornada"));
                    grado.setSeccion(rs.getInt("Seccion"));
                    grado.setEstado(rs.getBoolean("Estado"));
                    lista.add(grado);
                }
            }
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }
    
    public ArrayList<Grado> listaGradosActivos(Integer Jornada, Integer Seccion, Integer Nivel){
        ArrayList<Grado> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Grado(?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 5);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setInt(4, Nivel);
            sql.ct.setInt(5, Jornada);
            sql.ct.setInt(6, Seccion);
            sql.ct.setBoolean(7, true);
            sql.ct.setString(8, "1");
            try (ResultSet rs = sql.ct.executeQuery()) {
                while(rs.next() == true){
                    Grado grado = new Grado();
                    grado.setIdGrado(rs.getInt("IdGrado"));
                    grado.setDescripcion(rs.getString("Descripcion"));
                    grado.setNivel(rs.getInt("Nivel"));
                    grado.setJornada(rs.getInt("Jornada"));
                    grado.setSeccion(rs.getInt("Seccion"));
                    grado.setEstado(rs.getBoolean("Estado"));
                    lista.add(grado);
                }
            }
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }
}
