/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.TipoDocumento;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class TipoDocumentoDAO {
    Transacciones sql = new Transacciones();
    
    public ArrayList<TipoDocumento> ListaTiposDocumentos(){
        ArrayList<TipoDocumento> ListaTipoDocumento = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_TipoDocumento(?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                TipoDocumento Tipo = new TipoDocumento();
                Tipo.setIdTipoDocumento(rs.getInt("IdTipo"));
                Tipo.setTipo(rs.getString("Tipo"));
                ListaTipoDocumento.add(Tipo);
            }
            rs.close();
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return ListaTipoDocumento;
    }
}
