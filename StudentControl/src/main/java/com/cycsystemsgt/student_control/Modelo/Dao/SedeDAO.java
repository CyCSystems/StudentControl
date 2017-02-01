/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Sede;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class SedeDAO {
    Transacciones sql = new Transacciones();
    
    public List<Sede> obtenerSede(){
        List<Sede> lista = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Sede(?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            sql.ct.setInt(5, 0);
            sql.ct.setString(6, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                Sede sede = new Sede();
                sede.setIdAgencia(rs.getInt("IdAgencia"));
                sede.setAgencia(rs.getString("Agencia"));
                sede.setDireccion(rs.getString("Direccion"));
                sede.setRegion(rs.getInt("Region"));
                lista.add(sede);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public Sede obtenerSede(Integer idSede){
        Sede sede = new Sede();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Sede(?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, idSede);
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            sql.ct.setInt(5, 0);
            sql.ct.setString(6, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                sede.setIdAgencia(rs.getInt("IdAgencia"));
                sede.setAgencia(rs.getString("Agencia"));
                sede.setDireccion(rs.getString("Direccion"));
                sede.setRegion(rs.getInt("Region"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return sede;
    }
}
