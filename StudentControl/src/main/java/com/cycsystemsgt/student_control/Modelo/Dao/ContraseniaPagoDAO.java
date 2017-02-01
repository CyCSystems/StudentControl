/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Contraseniapago;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class ContraseniaPagoDAO {
    Transacciones sql = new Transacciones();
    
    public void registrarActividad(Contraseniapago mCPago){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_ContraseniaPago(?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, mCPago.getIdContraseniaPago());
            sql.ct.setInt(3, mCPago.getProveedor());
            sql.ct.setString(4, mCPago.getFecha());
            sql.ct.setString(5, mCPago.getFechaCobro());
            if(sql.ct.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Contraseña Guardada Exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
            }
            sql.ct.close();
            sql.close();
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Contraseniapago buscarActividad(int IdContrasenia){
        Contraseniapago mCPago = new Contraseniapago();
        sql.open();
        boolean existe = false;
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_ContraseniaPago(?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdContrasenia);
            sql.ct.setInt(3, 0);
            sql.ct.setDate(4, Date.valueOf("2016-01-01"));
            sql.ct.setDate(5, Date.valueOf("2016-01-01"));
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                existe = true;
                mCPago.setIdContraseniaPago(rs.getInt("IdContraseniaPago"));
                mCPago.setProveedor(rs.getInt("Proveedor"));
                mCPago.setFecha(rs.getString("Fecha"));
                mCPago.setFechaCobro(rs.getString("FechaCobro"));
            }
            rs.close();
            sql.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        if(existe == true){
            return mCPago;
        }else{
            return null;
        }
    }
    
    public void ModificarActividad(Contraseniapago mCPago){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_ContraseniaPago(?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, mCPago.getIdContraseniaPago());
            sql.ct.setInt(3, mCPago.getProveedor());
            sql.ct.setString(4, mCPago.getFecha());
            sql.ct.setString(5, mCPago.getFechaCobro());
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
    
    public void EliminarActividad(int IdContrasenia){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_ContraseniaPago(?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdContrasenia);
            sql.ct.setInt(3, 0);
            sql.ct.setDate(4, Date.valueOf("2016-01-01"));
            sql.ct.setDate(5, Date.valueOf("2016-01-01"));
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
