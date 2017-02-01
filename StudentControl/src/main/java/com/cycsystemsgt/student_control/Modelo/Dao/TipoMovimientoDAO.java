/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import java.util.List;
import com.cycsystemsgt.student_control.Modelo.Entidades.TipoMovimiento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class TipoMovimientoDAO {
    Transacciones sql = new Transacciones();
    
    public List<TipoMovimiento> obtenerTipoMovimiento(){
        List<TipoMovimiento> lista = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_TipoMovimiento(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            sql.ct.setString(5, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                TipoMovimiento tipo = new TipoMovimiento();
                tipo.setIdTipoMovimiento(rs.getInt("idTipoMovimiento"));
                tipo.setDescripcion(rs.getString("Descripcion"));
                tipo.setSigno(rs.getString("Signo"));
                lista.add(tipo);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public TipoMovimiento obtenerTipoMovimiento(Integer idTipoMovimiento){
        TipoMovimiento tipo = new TipoMovimiento();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_TipoMovimiento(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, idTipoMovimiento);
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            sql.ct.setString(5, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                tipo.setIdTipoMovimiento(rs.getInt("idTipoMovimiento"));
                tipo.setDescripcion(rs.getString("Descripcion"));
                tipo.setSigno(rs.getString("Signo"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return tipo;
    }
}
