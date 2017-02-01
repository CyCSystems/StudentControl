/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Inasistencia;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class InasistenciaDAO {
    Transacciones sql = new Transacciones();
    
    public Boolean registrarInasistencia(Inasistencia Inasistencia, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Inasistencia(?,?,?,?,?,?)");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, Inasistencia.getIdInasistencia());
            sql.ct.setDate(3, Inasistencia.getFechaInasistencia());
            sql.ct.setString(4, Inasistencia.getPersona());
            sql.ct.setInt(5, Inasistencia.getMotivoInasistencia());
            sql.ct.setString(6, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarInasistencia(Inasistencia Inasistencia, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Inasistencia(?,?,?,?,?,?)");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, Inasistencia.getIdInasistencia());
            sql.ct.setDate(3, Inasistencia.getFechaInasistencia());
            sql.ct.setString(4, Inasistencia.getPersona());
            sql.ct.setInt(5, Inasistencia.getMotivoInasistencia());
            sql.ct.setString(6, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public ArrayList<Inasistencia> listaInasistencia(String Alumno){
        ArrayList<Inasistencia> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Inasistencia(?,?,?,?,?,?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setDate(3, Date.valueOf("2016-01-01"));
            sql.ct.setString(4, Alumno);
            sql.ct.setInt(5, 0);
            sql.ct.setString(6, "0");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Inasistencia Inasistencia = new Inasistencia();
                Inasistencia.setIdInasistencia(rs.getInt("IdInasistencia"));
                Inasistencia.setFechaInasistencia(rs.getDate("FechaInasistencia"));
                Inasistencia.setPersona(rs.getString("Persona"));
                Inasistencia.setMotivoInasistencia(rs.getInt("MotivoInasistencia"));
                lista.add(Inasistencia);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public Inasistencia obtenerInasistencia(Integer IdInasistencia){
        Inasistencia Inasistencia = new Inasistencia();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Inasistencia(?,?,?,?,?,?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdInasistencia);
            sql.ct.setDate(3, Date.valueOf("2016-01-01"));
            sql.ct.setString(4, "0");
            sql.ct.setInt(5, 0);
            sql.ct.setString(6, "0");
            ResultSet rs = sql.ct.executeQuery();
            if(rs.next() == true){
                Inasistencia.setIdInasistencia(rs.getInt("IdInasistencia"));
                Inasistencia.setFechaInasistencia(rs.getDate("FechaInasistencia"));
                Inasistencia.setPersona(rs.getString("Persona"));
                Inasistencia.setMotivoInasistencia(rs.getInt("MotivoInasistencia"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return Inasistencia;
    }
}
