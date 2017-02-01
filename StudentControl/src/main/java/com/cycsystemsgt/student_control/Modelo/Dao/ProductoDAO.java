/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class ProductoDAO {
    
    Transacciones sql = new Transacciones();
    public Boolean registrarProducto(Producto producto, String usuario){
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Producto(?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, producto.getIdProducto());
            sql.ct.setString(3, producto.getDescripcion());
            sql.ct.setDouble(4, producto.getExistencias());
            sql.ct.setInt(5, producto.getCategoria());
            sql.ct.setInt(6, producto.getEstado());
            sql.ct.setString(7, usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Stucent Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarProducto(Producto producto, String usuario){
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Producto(?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, producto.getIdProducto());
            sql.ct.setString(3, producto.getDescripcion());
            sql.ct.setDouble(4, producto.getExistencias());
            sql.ct.setInt(5, producto.getCategoria());
            sql.ct.setInt(6, producto.getEstado());
            sql.ct.setString(7, usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Stucent Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public List<Producto> obtenerProducto(){
        List<Producto> lista = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Producto(?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setDouble(4, 0.0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, 0);
            sql.ct.setString(7, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("IdProducto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setExistencias(rs.getDouble("Existencias"));
                producto.setCategoria(rs.getInt("Categoria"));
                producto.setEstado(rs.getInt("Estado"));
                lista.add(producto);
            }
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Stucent Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public List<Producto> obtenerProducto(Integer Estado){
        List<Producto> lista = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Producto(?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 5);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setDouble(4, 0.0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, Estado);
            sql.ct.setString(7, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("IdProducto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setExistencias(rs.getDouble("Existencias"));
                producto.setCategoria(rs.getInt("Categoria"));
                producto.setEstado(rs.getInt("Estado"));
                lista.add(producto);
            }
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Stucent Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public Producto obtenerProducto(Long idProducto){
        Producto producto = new Producto();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Producto(?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, (int) (long) idProducto);
            sql.ct.setString(3, "");
            sql.ct.setDouble(4, 0.0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, 0);
            sql.ct.setString(7, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                producto.setIdProducto(rs.getInt("IdProducto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setExistencias(rs.getDouble("Existencias"));
                producto.setCategoria(rs.getInt("Categoria"));
                producto.setEstado(rs.getInt("Estado"));
            }
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Stucent Control", JOptionPane.ERROR_MESSAGE);
        }
        return producto;
    }
    
    public Producto obtenerProducto(int categoria){
        Producto producto = new Producto();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Producto(?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 6);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setDouble(4, 0.0);
            sql.ct.setInt(5, categoria);
            sql.ct.setInt(6, 0);
            sql.ct.setString(7, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                producto.setIdProducto(rs.getInt("IdProducto"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setExistencias(rs.getDouble("Existencias"));
                producto.setCategoria(rs.getInt("Categoria"));
                producto.setEstado(rs.getInt("Estado"));
            }
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Stucent Control", JOptionPane.ERROR_MESSAGE);
        }
        return producto;
    }
}
