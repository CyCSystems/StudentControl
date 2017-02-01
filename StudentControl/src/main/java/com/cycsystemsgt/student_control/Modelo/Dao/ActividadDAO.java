/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Actividad;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class ActividadDAO {
    
    private Transacciones sql = new Transacciones();
    
    public void registrarActividad(Actividad mActividad){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Actividad(?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, mActividad.getIdActividad());
            sql.ct.setString(3, mActividad.getDescripcion());
            sql.ct.setString(4, mActividad.getFechaInicio());
            sql.ct.setString(5, mActividad.getFechaFin());
            sql.ct.setInt(6, mActividad.getGrado());
            sql.ct.setBoolean(7, mActividad.getEstado());
            if(sql.ct.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Actividad Guardada Exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
            }
            sql.ct.close();
            sql.close();
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Actividad buscarActividad(int IdActividad){
        Actividad mActividad = new Actividad();
        sql.open();
        boolean existe = false;
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Actividad(?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdActividad);
            sql.ct.setString(3, "0");
            sql.ct.setString(4, "2016-01-01");
            sql.ct.setString(5, "2016-01-01");
            sql.ct.setInt(6, 0);
            sql.ct.setBoolean(7, false);
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                existe = true;
                mActividad.setIdActividad(rs.getInt("IdActividad"));
                mActividad.setDescripcion(rs.getString("Descripcion"));
                mActividad.setFechaInicio(rs.getString("FechaInicio"));
                mActividad.setFechaFin(rs.getString("FechaFin"));
                mActividad.setGrado(rs.getInt("Grado"));
            }
            rs.close();
            sql.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        if(existe == true){
            return mActividad;
        }else{
            return null;
        }
    }
    
    public void ModificarActividad(Actividad mActividad){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Actividad(?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, mActividad.getIdActividad());
            sql.ct.setString(3, mActividad.getDescripcion());
            sql.ct.setString(4, mActividad.getFechaInicio());
            sql.ct.setString(5, mActividad.getFechaFin());
            sql.ct.setInt(6, mActividad.getGrado());
            sql.ct.setBoolean(7, mActividad.getEstado());
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
    
    public void EliminarActividad(int IdActividad){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Actividad(?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, IdActividad);
            sql.ct.setString(3, "0");
            sql.ct.setString(4, "2016-01-01");
            sql.ct.setString(5, "2016-01-01");
            sql.ct.setInt(6, 0);
            sql.ct.setBoolean(7, false);
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
