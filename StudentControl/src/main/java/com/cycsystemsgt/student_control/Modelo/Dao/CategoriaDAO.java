/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Categoria;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class CategoriaDAO {
    Transacciones sql = new Transacciones();
    
    public void registrarCategoria(Categoria mCategoria){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Categoria(?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, mCategoria.getIdCategoria());
            sql.ct.setString(3, mCategoria.getDescripcion());
            sql.ct.setInt(4, mCategoria.getCategoriaBase());
            sql.ct.setString(5, mCategoria.getOrdenCategoria());
            sql.ct.setBoolean(6, mCategoria.getEstado());
            if(sql.ct.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Categoria Guardada Exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
            }
            sql.ct.close();
            sql.close();
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Categoria obtenerCategoria(int IdCategoria){
        Categoria categoria = new Categoria();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Categoria(?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdCategoria);
            sql.ct.setString(3, "");
            sql.ct.setInt(4, 0);
            sql.ct.setString(5, "");
            sql.ct.setString(6, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                categoria.setIdCategoria(rs.getInt("IdCategoria"));
                categoria.setDescripcion(rs.getString("Descripcion"));
                categoria.setCategoriaBase(rs.getInt("CategoriaBase"));
                categoria.setOrdenCategoria(rs.getString("OrdenCategoria"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return categoria;
    }
    
    public List<Categoria> obtenerCategoria(){
        List<Categoria> lista = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Categoria(?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setInt(4, 0);
            sql.ct.setString(5, "");
            sql.ct.setString(6, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("IdCategoria"));
                categoria.setDescripcion(rs.getString("Descripcion"));
                categoria.setCategoriaBase(rs.getInt("CategoriaBase"));
                categoria.setOrdenCategoria(rs.getString("OrdenCategoria"));
                lista.add(categoria);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;            
    }
    
    public void modificarCategoria(Categoria mCategoria){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Categoria(?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, mCategoria.getIdCategoria());
            sql.ct.setString(3, mCategoria.getDescripcion());
            sql.ct.setInt(4, mCategoria.getCategoriaBase());
            sql.ct.setString(5, mCategoria.getOrdenCategoria());
            sql.ct.setBoolean(6, mCategoria.getEstado());
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
    
    public void eliminarCategoria(int IdCategoria){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Categoria(?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, IdCategoria);
            sql.ct.setString(3, "0");
            sql.ct.setBoolean(4, false);
            sql.ct.setString(5, "0");
            sql.ct.setInt(6, 0);
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
