/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.MotivoInasistencia;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class MotivoInasistenciaDAO {
    Transacciones sql = new Transacciones();
    
    public Boolean registrarMotivoInasistencia(MotivoInasistencia motivo, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_MotivoInasistencia(?, ?, ?, ?)");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, motivo.getIdMotivoInasistencia());
            sql.ct.setString(3, motivo.getDescripcion());
            sql.ct.setString(4, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }   
    }
    
    public Boolean modificarMotivoInasistencia(MotivoInasistencia motivo, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_MotivoInasistencia(?, ?, ?, ?)");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, motivo.getIdMotivoInasistencia());
            sql.ct.setString(3, motivo.getDescripcion());
            sql.ct.setString(4, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }   
    }
    
    public ArrayList<MotivoInasistencia> ListaMotivos(){
        ArrayList<MotivoInasistencia> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_MotivoInasistencia(?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "0");
            sql.ct.setString(4, "0");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                MotivoInasistencia motivo = new MotivoInasistencia();
                motivo.setIdMotivoInasistencia(rs.getInt("IdMotivoInacistencia"));
                motivo.setDescripcion(rs.getString("Descripcion"));
                lista.add(motivo);
            }
            sql.ct.close();
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public MotivoInasistencia obtenerMotivoInasistencia(Integer IdMotivoInasistencia){
        MotivoInasistencia motivo = new MotivoInasistencia();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_MotivoInasistencia(?,?,?,?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdMotivoInasistencia);
            sql.ct.setString(3, "0");
            sql.ct.setString(4, "0");
            ResultSet rs = sql.ct.executeQuery();
            if(rs.next() == true){
                motivo.setIdMotivoInasistencia(rs.getInt("IdMotivoInacistencia"));
                motivo.setDescripcion(rs.getString("Descripcion"));
            }
            sql.ct.close();
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return motivo;
    }
}
