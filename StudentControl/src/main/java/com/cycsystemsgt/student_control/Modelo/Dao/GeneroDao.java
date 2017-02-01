/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Entidades.Genero;
import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class GeneroDao {
    
    Transacciones sql;
    
    public GeneroDao(){
        sql = new Transacciones();
    }
    
    public ArrayList<Genero> obtenerGenero(){
        ArrayList<Genero> ListaGenero = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Genero(?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                Genero genero = new Genero();
                genero.setIdGenero(rs.getInt("IdGenero"));
                genero.setDescripcion(rs.getString("Descripcion"));
                ListaGenero.add(genero);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }    
        return ListaGenero;
    }
    
    public Genero BuscarGenero(Integer IdGenero){
        
        return null;
    }
    
}
