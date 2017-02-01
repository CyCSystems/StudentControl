/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Materia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class MateriaDAO {
    Transacciones sql = new Transacciones();
    
    public ArrayList<Materia> listaMaterias(Integer Grado){
        ArrayList<Materia> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Materia(?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setInt(4, Grado);
            sql.ct.setBoolean(5, true);
            sql.ct.setString(6, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("IdMateria"));
                materia.setDescripcion(rs.getString("Descripcion"));
                materia.setGrado(rs.getInt("Grado"));
                materia.setEstado(rs.getBoolean("Estado"));
                lista.add(materia);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public ArrayList<Materia> listaMateriasActivas(){
        ArrayList<Materia> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Materia(?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setInt(4, 0);
            sql.ct.setBoolean(5, true);
            sql.ct.setString(6, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("IdMateria"));
                materia.setDescripcion(rs.getString("Descripcion"));
                materia.setGrado(rs.getInt("Grado"));
                materia.setEstado(rs.getBoolean("Estado"));
                lista.add(materia);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public Materia obtenerMateria(Integer IdMateria){
        Materia materia = new Materia();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Materia(?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 5);
            sql.ct.setInt(2, IdMateria);
            sql.ct.setString(3, "");
            sql.ct.setInt(4, 0);
            sql.ct.setBoolean(5, true);
            sql.ct.setString(6, "");
            ResultSet rs = sql.ct.executeQuery();
            if(rs.next() == true){
                materia.setIdMateria(rs.getInt("IdMateria"));
                materia.setDescripcion(rs.getString("Descripcion"));
                materia.setGrado(rs.getInt("Grado"));
                materia.setEstado(rs.getBoolean("Estado"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return materia;
    }
    
    public Boolean registrarMateria(Materia mMateria, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Materia(?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, mMateria.getIdMateria());
            sql.ct.setString(3, mMateria.getDescripcion());
            sql.ct.setInt(4, mMateria.getGrado());
            sql.ct.setBoolean(5, mMateria.getEstado());
            sql.ct.setString(6, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarMateria(Materia mMateria, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Materia(?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, mMateria.getIdMateria());
            sql.ct.setString(3, mMateria.getDescripcion());
            sql.ct.setInt(4, mMateria.getGrado());
            sql.ct.setBoolean(5, mMateria.getEstado());
            sql.ct.setString(6, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
