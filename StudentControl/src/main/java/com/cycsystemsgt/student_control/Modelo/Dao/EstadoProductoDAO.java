/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.EstadoProducto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class EstadoProductoDAO {
    Transacciones sql = new Transacciones();
    
    public List<EstadoProducto> obtenerEstadoProducto(){
        List<EstadoProducto> lista = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_EstadoProducto(?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 1);
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                EstadoProducto estado = new EstadoProducto();
                estado.setIdEstado(rs.getInt("IdEstadoProducto"));
                estado.setDescripcion(rs.getString("Descripcion"));
                lista.add(estado);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public EstadoProducto obtenerEstadoProducto(Integer idEstadoProducto){
        EstadoProducto estado = new EstadoProducto();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_EstadoProducto(?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, idEstadoProducto);
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                estado.setIdEstado(rs.getInt("IdEstadoProducto"));
                estado.setDescripcion(rs.getString("Descripcion"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return estado;
    }
}
