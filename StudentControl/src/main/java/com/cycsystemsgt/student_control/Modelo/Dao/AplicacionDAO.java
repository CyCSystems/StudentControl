/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Aplicacion;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class AplicacionDAO {
    private Transacciones sql = new Transacciones();
    private String Query = "";
    
    public void registrarAplicacion(Aplicacion app){
        sql.open();
        try{
            Query = "call studentcontrol.sp_Crud_Aplicacion(?, ?, ?, ?);";
            sql.ct = sql.conexion.prepareCall(Query);
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, app.getIdAplicaion());
            sql.ct.setString(3, app.getAplicacion());
            sql.ct.setBoolean(4, app.getEstado());
            if(sql.ct.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Aplicacion Guardada Exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Aplicacion buscarAplicacion(int IdAplicacion){
        Aplicacion mAplicacion = new Aplicacion();
        boolean existe = false;
        sql.open();
        try{
            Query = "";
            Query = "call studentcontrol.sp_Crud_Aplicacion(?, ?, ?, ?);";
            sql.ct = sql.conexion.prepareCall(Query);
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdAplicacion);
            sql.ct.setString(3, "0");
            sql.ct.setBoolean(4, false);
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                existe = true;
                mAplicacion.setIdAplicaion(rs.getInt("IdAplicacion"));
                mAplicacion.setAplicacion(rs.getString("Aplicacion"));
                mAplicacion.setEstado(rs.getBoolean("Estado"));
            }
            rs.close();
            sql.ct.close();
            sql.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        if(existe == true){
            return mAplicacion;
        }else{
            return null;
        }
    }
    
    public void ModificarActividad(Aplicacion app){
        sql.open();
        try{
            Query = "call studentcontrol.sp_Crud_Aplicacion(?, ?, ?, ?);";
            sql.ct = sql.conexion.prepareCall(Query);
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, app.getIdAplicaion());
            sql.ct.setString(3, app.getAplicacion());
            sql.ct.setBoolean(4, app.getEstado());
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
    
    public void EliminarActividad(int IdAplicacion){
        sql.open();
        try{
            Query = "";
            Query = "call studentcontrol.sp_Crud_Aplicacion(?, ?, ?, ?);";
            sql.ct = sql.conexion.prepareCall(Query);
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdAplicacion);
            sql.ct.setString(3, "0");
            sql.ct.setBoolean(4, false);
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
