/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Documento;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class DocumentoDAO {
    Transacciones sql = new Transacciones();
    
    public Documento getDocumento(String IdPersona){
        Documento documento = new Documento();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Documento(?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setInt(4, 0);
            sql.ct.setString(5, IdPersona);
            ResultSet rs = sql.ct.executeQuery();
            if(rs.next() == true){
                documento.setIdDocumento(rs.getInt("IdDocumento"));
                documento.setNumero(rs.getString("Numero"));
                documento.setTipoDocumento(rs.getInt("TipoDocumento"));
                documento.setTipo(rs.getString("Tipo"));
                documento.setPersona(rs.getString("Persona"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return documento;
    }
}
