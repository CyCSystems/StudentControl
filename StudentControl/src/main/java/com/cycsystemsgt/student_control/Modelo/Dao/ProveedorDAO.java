/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author angel
 */
public class ProveedorDAO {
    Transacciones sql = new Transacciones();
    
    public List<Proveedor> obtenerProveedor(){
        List<Proveedor> lista = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Proveedor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 1);
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            sql.ct.setString(5, "");
            sql.ct.setString(6, "");
            sql.ct.setString(7, "");
            sql.ct.setInt(8, 0);
            sql.ct.setInt(9, 0);
            sql.ct.setString(10, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("IdProveedor"));
                proveedor.setNombre(rs.getString("Nombre"));
                proveedor.setContacto(rs.getString("Contacto"));
                proveedor.setCargoContacto(rs.getString("CargoContacto"));
                proveedor.setDireccion(rs.getString("Direccion"));
                proveedor.setTelefono(rs.getString("Telefono"));
                proveedor.setFormaPago(rs.getInt("FormaPago"));
                proveedor.setDiaPago("FechaPago");
                lista.add(proveedor);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public Proveedor obtenerProveedor(Integer idProveedor){
        Proveedor proveedor = new Proveedor();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Proveedor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, idProveedor);
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            sql.ct.setString(5, "");
            sql.ct.setString(6, "");
            sql.ct.setString(7, "");
            sql.ct.setInt(8, 0);
            sql.ct.setInt(9, 0);
            sql.ct.setString(10, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){                
                proveedor.setIdProveedor(rs.getInt("IdProveedor"));
                proveedor.setNombre(rs.getString("Nombre"));
                proveedor.setContacto(rs.getString("Contacto"));
                proveedor.setCargoContacto(rs.getString("CargoContacto"));
                proveedor.setDireccion(rs.getString("Direccion"));
                proveedor.setTelefono(rs.getString("Telefono"));
                proveedor.setFormaPago(rs.getInt("FormaPago"));
                proveedor.setDiaPago("FechaPago");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return proveedor;
    }
}
