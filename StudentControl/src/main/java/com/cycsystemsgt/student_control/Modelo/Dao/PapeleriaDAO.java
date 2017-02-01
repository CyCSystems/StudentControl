/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;


import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Papeleria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class PapeleriaDAO {
    Transacciones sql = new Transacciones();
    
    public Boolean registrarPapeleria(Papeleria mPapeleria){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Papeleria(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, 0);
            sql.ct.setInt(3, mPapeleria.getIdTipoPapeleria());
            sql.ct.setString(4, mPapeleria.getPersona());
            sql.ct.setString(5, mPapeleria.getDescripcion());
            if(sql.ct.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException e){
            return false;
        }
        return false;
    }
    
    public Boolean modificarPapeleria(Papeleria mPapeleria){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Papeleria(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, mPapeleria.getIdPapeleria());
            sql.ct.setInt(3, mPapeleria.getIdTipoPapeleria());
            sql.ct.setString(4, mPapeleria.getPersona());
            sql.ct.setString(5, mPapeleria.getDescripcion());
            if(sql.ct.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException e){
            return false;
        }
        return false;
    }
    
    public Boolean eliminarPapeleria(Integer IdPapeleria){
                sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Papeleria(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdPapeleria);
            sql.ct.setInt(3, 0);
            sql.ct.setString(4, "");
            sql.ct.setString(5, "");
            if(sql.ct.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException e){
            return false;
        }
        return false;
    }
    
    public ArrayList<Papeleria> buscarPapeleria(String IdAlumno){
        ArrayList<Papeleria> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Papeleria(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setInt(3, 0);
            sql.ct.setString(4, IdAlumno);
            sql.ct.setString(5, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                Papeleria papeleria = new Papeleria();
                papeleria.setIdPapeleria(rs.getInt("IdPapeleria"));
                papeleria.setPersona(rs.getString("Persona"));
                papeleria.setIdTipoPapeleria(rs.getInt("IdTipoPapeleria"));
                papeleria.setTipoPapeleria(rs.getString("TipoPapeleria"));
                papeleria.setDescripcion(rs.getString("Descripcion"));
                lista.add(papeleria);
            }
            sql.ct.close();
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
}
