/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.AsignacionAlumno;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class AsignacionAlumnoDAO {
    Transacciones sql = new Transacciones();
    
    public Boolean registrarAsignacion(AsignacionAlumno mAsignacion, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_AsignacionAlumno(?, ?, ?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, mAsignacion.getIdAsignacion());
            sql.ct.setDate(3, mAsignacion.getFechaAsignacion());
            sql.ct.setInt(4, mAsignacion.getCiclo());
            sql.ct.setInt(5, mAsignacion.getGrado());
            sql.ct.setString(6, mAsignacion.getPersona());
            sql.ct.setBigDecimal(7, mAsignacion.getInscripcion());
            sql.ct.setBigDecimal(8, mAsignacion.getMensualidad());
            sql.ct.setString(9, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
        
    public Boolean modificarAsignacion(AsignacionAlumno mAsignacion, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_AsignacionAlumno(?, ?, ?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, mAsignacion.getIdAsignacion());
            sql.ct.setDate(3, mAsignacion.getFechaAsignacion());
            sql.ct.setInt(4, mAsignacion.getCiclo());
            sql.ct.setInt(5, mAsignacion.getGrado());
            sql.ct.setString(6, mAsignacion.getPersona());
            sql.ct.setBigDecimal(7, mAsignacion.getInscripcion());
            sql.ct.setBigDecimal(8, mAsignacion.getMensualidad());
            sql.ct.setString(9, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public ArrayList<AsignacionAlumno> listaAsignaciones(Integer Grado){
        ArrayList<AsignacionAlumno> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_AsignacionAlumno(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, 0);
            sql.ct.setDate(3, Date.valueOf("2016-01-01"));
            sql.ct.setInt(4, 0);
            sql.ct.setInt(5, Grado);
            sql.ct.setString(6, "");
            sql.ct.setBigDecimal(7, BigDecimal.valueOf(0.00));
            sql.ct.setBigDecimal(8, BigDecimal.valueOf(0.00));
            sql.ct.setString(9, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                AsignacionAlumno Asignacion = new AsignacionAlumno();
                Asignacion.setIdAsignacion(rs.getInt("IdAsignacion"));
                Asignacion.setFechaAsignacion(rs.getDate("FechaAsignacion"));
                Asignacion.setCiclo(rs.getInt("Ciclo"));
                Asignacion.setGrado(rs.getInt("Grado"));
                Asignacion.setPersona(rs.getString("Persona"));
                Asignacion.setInscripcion(rs.getBigDecimal("Inscripcion"));
                Asignacion.setMensualidad(rs.getBigDecimal("Mensualidad"));
                lista.add(Asignacion);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public AsignacionAlumno buscarAsignacion(String Alumno, Integer Ciclo){
        AsignacionAlumno asignacion = new AsignacionAlumno();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_AsignacionAlumno(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 5);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "2016-01-01");
            sql.ct.setInt(4, Ciclo);
            sql.ct.setInt(5, 1);
            sql.ct.setString(6, Alumno);
            sql.ct.setBigDecimal(7, BigDecimal.valueOf(150.00));
            sql.ct.setBigDecimal(8, BigDecimal.valueOf(150.00));
            sql.ct.setString(9, "1");
            ResultSet rs = sql.ct.executeQuery();
            if(rs.next()){
                asignacion.setIdAsignacion(rs.getInt("IdAsignacion"));
                asignacion.setFechaAsignacion(rs.getDate("FechaAsignacion"));
                asignacion.setCiclo(rs.getInt("Ciclo"));
                asignacion.setGrado(rs.getInt("Grado"));
                asignacion.setPersona(rs.getString("Persona"));
                asignacion.setInscripcion(rs.getBigDecimal("Inscripcion"));
                asignacion.setMensualidad(rs.getBigDecimal("Mensualidad"));
                return asignacion;
            }else{
                return null;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return null;
        }        
    }
}
