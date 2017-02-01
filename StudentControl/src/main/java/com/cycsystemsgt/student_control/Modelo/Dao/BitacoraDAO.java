/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Bitacora;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class BitacoraDAO {
    Transacciones sql = new Transacciones();
    
    public Boolean registrarActividad(Bitacora mBitacora){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Bitacora(?, ?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, mBitacora.getIdBitacora());
            sql.ct.setString(3, mBitacora.getOperacion());
            sql.ct.setString(4, mBitacora.getForma());
            sql.ct.setString(5, mBitacora.getIdRegistro());
            sql.ct.setString(6, mBitacora.getFecha());
            sql.ct.setBoolean(7, mBitacora.getEstado());
            sql.ct.setString(8, mBitacora.getPersona());
            if(sql.ct.executeUpdate() > 0){
                return true;
            }
            sql.ct.close();
            sql.close();
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    
    public Bitacora buscarActividad(int IdBitacora){
        Bitacora mBitacora = new Bitacora();
        sql.open();
        boolean existe = false;
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Bitacora(?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, IdBitacora);
            sql.ct.setString(3, "0");
            sql.ct.setString(4, "0");
            sql.ct.setString(5, "0");
            sql.ct.setBoolean(6, false);
            sql.ct.setString(7, "0");
            sql.ct.setInt(8, 0);
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                existe = true;
                mBitacora.setIdBitacora(rs.getInt("IdBitacora"));
                mBitacora.setOperacion(rs.getString("Operacion"));
                mBitacora.setForma(rs.getString("Forma"));
                mBitacora.setIdRegistro(rs.getString("IdRegistro"));
                mBitacora.setFecha(rs.getString("Fecha"));
                mBitacora.setEstado(rs.getBoolean("Estado"));
                mBitacora.setPersona(rs.getString("Persona"));
            }
            rs.close();
            sql.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        if(existe == true){
            return mBitacora;
        }else{
            return null;
        }
    }
    
    public void ModificarActividad(Bitacora mBitacora){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Bitacora(?, ?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, mBitacora.getIdBitacora());
            sql.ct.setString(3, mBitacora.getOperacion());
            sql.ct.setString(4, mBitacora.getForma());
            sql.ct.setString(5, mBitacora.getIdRegistro());
            sql.ct.setString(6, mBitacora.getFecha());
            sql.ct.setBoolean(7, mBitacora.getEstado());
            sql.ct.setString(8, mBitacora.getPersona());
            if(sql.ct.executeUpdate()> 0){
                JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Student Control",JOptionPane.INFORMATION_MESSAGE);
            }
            sql.close();
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
}
