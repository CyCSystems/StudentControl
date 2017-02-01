/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Coneccion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class Transacciones {
    
    public Connection conexion = null;
    public CallableStatement ct;
    
    public Transacciones(){
        conexion = null;
    }
       
    public void beginTransaccion(){
        try {
            conexion.setAutoCommit(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void commit(){
        try {
            conexion.commit();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error: " + ex.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Abre una nueva coneccion
     */
    public void open(){
        conexion = Conexion.getConexion();
    }
    
    /**
     * Cierra la actual Coneccion
     */
    public void close(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
}
