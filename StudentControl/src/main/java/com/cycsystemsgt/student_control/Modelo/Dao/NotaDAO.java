/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Notas;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class NotaDAO {

    Transacciones sql = new Transacciones();
    
    public Boolean registrarNota(Notas Nota, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Notas(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, Nota.getIdNota());
            sql.ct.setString(3, Nota.getPersona());
            sql.ct.setInt(4, Nota.getUnidad());
            sql.ct.setDouble(5, Nota.getZona());
            sql.ct.setDouble(6, Nota.getExamen());
            sql.ct.setDouble(7, Nota.getTotal());
            sql.ct.setInt(8, Nota.getMateria());
            sql.ct.setInt(9, Nota.getCiclo());
            sql.ct.setInt(10, 0);
            sql.ct.setString(11, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarNota(Notas Nota, String Usuario){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Notas(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, Nota.getIdNota());
            sql.ct.setString(3, Nota.getPersona());
            sql.ct.setInt(4, Nota.getUnidad());
            sql.ct.setDouble(5, Nota.getZona());
            sql.ct.setDouble(6, Nota.getExamen());
            sql.ct.setDouble(7, Nota.getTotal());
            sql.ct.setInt(8, Nota.getMateria());
            sql.ct.setInt(9, Nota.getCiclo());
            sql.ct.setInt(10, 0);
            sql.ct.setString(11, Usuario);
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public ArrayList<Notas> notasAlumno(String IdAlumno, Integer Unidad){
        ArrayList<Notas> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Notas(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, IdAlumno);
            sql.ct.setInt(4, Unidad);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, 0);
            sql.ct.setInt(7, 0);
            sql.ct.setInt(8, 0);
            sql.ct.setInt(9, 0);
            sql.ct.setInt(10, 0);
            sql.ct.setString(11, "0");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Notas Nota = new Notas();
                Nota.setIdNota(rs.getInt("IdNota"));
                Nota.setPersona(rs.getString("Persona"));
                Nota.setUnidad(rs.getInt("Unidad"));
                Nota.setZona(rs.getDouble("Zona"));
                Nota.setExamen(rs.getDouble("Examen"));
                Nota.setTotal(rs.getDouble("Total"));
                Nota.setMateria(rs.getInt("Materia"));
                Nota.setCiclo(rs.getInt("Ciclo"));
                lista.add(Nota);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
}
