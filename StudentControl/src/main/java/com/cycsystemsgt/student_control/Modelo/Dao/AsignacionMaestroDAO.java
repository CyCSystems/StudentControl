/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Asignacionmaestro;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class AsignacionMaestroDAO {
    
    Transacciones sql = new Transacciones();
    
    public void registrarActividad(Asignacionmaestro mAsignacion){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_AsignacionMaestro(?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, mAsignacion.getIdAsignacion());
            sql.ct.setString(3, mAsignacion.getFechaAsignacion());
            sql.ct.setBoolean(4, mAsignacion.getEstado());
            sql.ct.setString(5, mAsignacion.getPersona());
            sql.ct.setInt(6, mAsignacion.getMateria());
            sql.ct.setInt(7, mAsignacion.getCiclo());
            if(sql.ct.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Asignacion Guardada Exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
            }
            sql.ct.close();
            sql.close();
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Asignacionmaestro buscarActividad(int IdAsignacion){
        Asignacionmaestro mAsignacion = new Asignacionmaestro();
        sql.open();
        boolean existe = false;
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_AsignacionMaestro(?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdAsignacion);
            sql.ct.setString(3, "0");
            sql.ct.setBoolean(4, false);
            sql.ct.setString(5, "0");
            sql.ct.setInt(6, 0);
            sql.ct.setInt(7, 0);
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                existe = true;
                mAsignacion.setIdAsignacion(rs.getInt("IdAsignacion"));
                mAsignacion.setFechaAsignacion(rs.getString("FechaAsignacion"));
                mAsignacion.setEstado(rs.getBoolean("Estado"));
                mAsignacion.setPersona(rs.getString("Persona"));
                mAsignacion.setMateria(rs.getInt("Materia"));
                mAsignacion.setCiclo(rs.getInt("Ciclo"));
            }
            rs.close();
            sql.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        if(existe == true){
            return mAsignacion;
        }else{
            return null;
        }
    }
    
    public void ModificarActividad(Asignacionmaestro mAsignacion){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_AsignacionMaestro(?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, mAsignacion.getIdAsignacion());
            sql.ct.setString(3, mAsignacion.getFechaAsignacion());
            sql.ct.setBoolean(4, mAsignacion.getEstado());
            sql.ct.setString(5, mAsignacion.getPersona());
            sql.ct.setInt(6, mAsignacion.getMateria());
            sql.ct.setInt(7, mAsignacion.getCiclo());
            if(sql.ct.executeUpdate()> 0){
                JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Student Control",JOptionPane.INFORMATION_MESSAGE);
            }
            sql.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarActividad(int IdAsignacion){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_AsignacionMaestro(?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, IdAsignacion);
            sql.ct.setString(3, "0");
            sql.ct.setBoolean(4, false);
            sql.ct.setString(5, "0");
            sql.ct.setInt(6, 0);
            sql.ct.setInt(7, 0);
            if(sql.ct.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Student Control",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }   
    }
            
            
}
