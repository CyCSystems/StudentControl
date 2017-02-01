/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Movimiento;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class MovimientoDAO {
    Transacciones sql = new Transacciones();
    
    public boolean registrarMovimiento(Movimiento movimiento, String usuario){
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Movimiento(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, movimiento.getIdMovimiento());
            sql.ct.setDate(3, movimiento.getFecha());
            sql.ct.setDouble(4, movimiento.getCantidad());
            sql.ct.setInt(5, movimiento.getTipoMovimiento());
            sql.ct.setInt(6, movimiento.getProducto());
            sql.ct.setInt(7, movimiento.getSede());
            sql.ct.setDouble(8, movimiento.getValorUnidad());
            sql.ct.setDouble(9, movimiento.getCostoUnidad());
            sql.ct.setInt(10, movimiento.getProveedor());
            sql.ct.setString(11, usuario);
            sql.ct.executeUpdate();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean modificarMovimiento(Movimiento movimiento, String usuario){
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Movimiento(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, movimiento.getIdMovimiento());
            sql.ct.setDate(3, movimiento.getFecha());
            sql.ct.setDouble(4, movimiento.getCantidad());
            sql.ct.setInt(5, movimiento.getTipoMovimiento());
            sql.ct.setInt(usuario, movimiento.getProducto());
            sql.ct.setInt(7, movimiento.getSede());
            sql.ct.setDouble(8, movimiento.getValorUnidad());
            sql.ct.setDouble(9, movimiento.getCostoUnidad());
            sql.ct.setInt(10, movimiento.getProveedor());
            sql.ct.setString(11, usuario);
            sql.ct.executeUpdate();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public List<Movimiento> obtenerMovimiento(){
        List<Movimiento> lista = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Movimiento(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 1);
            sql.ct.setDate(3, Date.valueOf("2016-01-01"));
            sql.ct.setDouble(4, 0.0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, 0);
            sql.ct.setInt(7, 0);
            sql.ct.setDouble(8, 0.0);
            sql.ct.setDouble(9, 0.0);
            sql.ct.setInt(10, 0);
            sql.ct.setString(11, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Movimiento movimiento = new Movimiento();
                movimiento.setIdMovimiento(rs.getInt("IdMovimientos"));
                movimiento.setFecha(rs.getDate("Fecha"));
                movimiento.setCantidad(rs.getDouble("Cantidad"));
                movimiento.setTipoMovimiento(rs.getInt("TipoMovimiento"));
                movimiento.setProducto(rs.getInt("Producto"));
                movimiento.setSede(rs.getInt("Sede"));
                movimiento.setValorUnidad(rs.getDouble("ValorUnidad"));
                movimiento.setCostoUnidad(rs.getDouble("CostoUnidad"));
                movimiento.setProveedor(rs.getInt("Proveedor"));
                lista.add(movimiento);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public List<Movimiento> obtenerMovimiento(java.util.Date fecha){
        List<Movimiento> lista = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Movimiento(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 6);
            sql.ct.setInt(2, 1);
            sql.ct.setDate(3, new java.sql.Date(fecha.getTime()));
            sql.ct.setDouble(4, 0.0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, 0);
            sql.ct.setInt(7, 0);
            sql.ct.setDouble(8, 0.0);
            sql.ct.setDouble(9, 0.0);
            sql.ct.setInt(10, 0);
            sql.ct.setString(11, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Movimiento movimiento = new Movimiento();
                movimiento.setIdMovimiento(rs.getInt("IdMovimientos"));
                movimiento.setFecha(rs.getDate("Fecha"));
                movimiento.setCantidad(rs.getDouble("Cantidad"));
                movimiento.setTipoMovimiento(rs.getInt("TipoMovimiento"));
                movimiento.setProducto(rs.getInt("Producto"));
                movimiento.setSede(rs.getInt("Sede"));
                movimiento.setValorUnidad(rs.getDouble("ValorUnidad"));
                movimiento.setCostoUnidad(rs.getDouble("CostoUnidad"));
                movimiento.setProveedor(rs.getInt("Proveedor"));
                lista.add(movimiento);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public Movimiento obtenerMovimiento(int idMovimiento){
        Movimiento movimiento = new Movimiento();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Movimiento(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, idMovimiento);
            sql.ct.setDate(3, Date.valueOf("2016-01-01"));
            sql.ct.setDouble(4, 0.0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, 0);
            sql.ct.setInt(7, 0);
            sql.ct.setDouble(8, 0.0);
            sql.ct.setDouble(9, 0.0);
            sql.ct.setInt(10, 0);
            sql.ct.setString(11, "");
            sql.ct.executeUpdate();
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                movimiento.setIdMovimiento(rs.getInt("IdMovimientos"));
                movimiento.setFecha(rs.getDate("Fecha"));
                movimiento.setCantidad(rs.getDouble("Cantidad"));
                movimiento.setTipoMovimiento(rs.getInt("TipoMovimiento"));
                movimiento.setProducto(rs.getInt("Producto"));
                movimiento.setSede(rs.getInt("Sede"));
                movimiento.setValorUnidad(rs.getDouble("ValorUnidad"));
                movimiento.setCostoUnidad(rs.getDouble("CostoUnidad"));
                movimiento.setProveedor(rs.getInt("Proveedor"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return movimiento;
    }
    
    public Movimiento obtenerPrecioActual(int producto){
        Movimiento movimiento = new Movimiento();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Movimiento(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 5);
            sql.ct.setInt(2, 1);
            sql.ct.setDate(3, Date.valueOf("2016-01-01"));
            sql.ct.setDouble(4, 0.0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, producto);
            sql.ct.setInt(7, 0);
            sql.ct.setDouble(8, 0.0);
            sql.ct.setDouble(9, 0.0);
            sql.ct.setInt(10, 0);
            sql.ct.setString(11, "");
            sql.ct.executeUpdate();
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                movimiento.setFecha(rs.getDate("Fecha"));
                movimiento.setValorUnidad(rs.getDouble("ValorUnidad"));
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return movimiento;
    }
}
