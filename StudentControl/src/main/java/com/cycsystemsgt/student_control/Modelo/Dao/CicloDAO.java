/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Ciclo;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class CicloDAO {
    Transacciones sql = new Transacciones();
    
    public void registrarCiclo(Ciclo mCiclo){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Ciclo(?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, mCiclo.getIdCiclo());
            sql.ct.setString(3, mCiclo.getCiclo());
            sql.ct.setInt(4, mCiclo.getCantidadUnidades());
            sql.ct.setInt(5, mCiclo.getNotaMinima());
            sql.ct.setInt(6, mCiclo.getDiaPago());
            sql.ct.setBigDecimal(7, mCiclo.getMoraDia());
            sql.ct.setBoolean(8, mCiclo.getEstado());
            if(sql.ct.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Ciclo Guardado Exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
            }
            sql.ct.close();
            sql.close();
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Ciclo buscarCiclo(int IdCiclo){
        Ciclo mCiclo = new Ciclo();
        sql.open();
        boolean existe = false;
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Ciclo(?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, IdCiclo);
            sql.ct.setString(3, "0");
            sql.ct.setInt(4, 0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, 0);
            sql.ct.setBigDecimal(7, BigDecimal.valueOf(0));
            sql.ct.setBoolean(8, false);
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                existe = true;
                mCiclo.setIdCiclo(rs.getInt("IdCiclo"));
                mCiclo.setCiclo(rs.getString("Ciclo"));
                mCiclo.setCantidadUnidades(rs.getInt("CantidadUnidades"));
                mCiclo.setNotaMinima(rs.getInt("NotaMinima"));
                mCiclo.setDiaPago(rs.getInt("DiaPago"));
                mCiclo.setMoraDia(rs.getBigDecimal("MoraDia"));
                mCiclo.setEstado(rs.getBoolean("Estado"));
            }
            rs.close();
            sql.ct.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        if(existe == true){
            return mCiclo;
        }else{
            return null;
        }
    }
    
    public Ciclo buscarCiclo(String Ciclo){
        Ciclo mCiclo = new Ciclo();
        sql.open();
        boolean existe = false;
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Ciclo(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, Ciclo);
            sql.ct.setInt(4, 0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, 0);
            sql.ct.setBigDecimal(7, BigDecimal.valueOf(0));
            sql.ct.setBoolean(8, false);
            sql.ct.setString(9, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                existe = true;
                mCiclo.setIdCiclo(rs.getInt("IdCiclo"));
                mCiclo.setCiclo(rs.getString("Ciclo"));
                mCiclo.setCantidadUnidades(rs.getInt("CantidadUnidades"));
                mCiclo.setNotaMinima(rs.getInt("NotaMinima"));
                mCiclo.setDiaPago(rs.getInt("DiaPago"));
                mCiclo.setMoraDia(rs.getBigDecimal("MoraDia"));
                mCiclo.setEstado(rs.getBoolean("Estado"));
            }
            rs.close();
            sql.ct.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        if(existe == true){
            return mCiclo;
        }else{
            return null;
        }
    }
    
    public void modificarCiclo(Ciclo mCiclo){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Ciclo(?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 2);
            sql.ct.setInt(2, mCiclo.getIdCiclo());
            sql.ct.setString(3, mCiclo.getCiclo());
            sql.ct.setInt(4, mCiclo.getCantidadUnidades());
            sql.ct.setInt(5, mCiclo.getNotaMinima());
            sql.ct.setInt(6, mCiclo.getDiaPago());
            sql.ct.setBigDecimal(7, mCiclo.getMoraDia());
            sql.ct.setBoolean(8, mCiclo.getEstado());
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
    
    public void eliminarCiclo(int IdCiclo){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Ciclo(?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 3);
            sql.ct.setInt(2, IdCiclo);
            sql.ct.setString(3, "0");
            sql.ct.setInt(4, 0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, 0);
            sql.ct.setBigDecimal(7, BigDecimal.valueOf(0));
            sql.ct.setBoolean(8, false);
            if(sql.ct.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Student Control",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    public Ciclo obtenerCicloActivo(){
        Ciclo ciclo = new Ciclo();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Ciclo(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setInt(4, 0);
            sql.ct.setInt(5, 0);
            sql.ct.setInt(6, 0);
            sql.ct.setInt(7, 0);
            sql.ct.setBoolean(8, false);
            sql.ct.setString(9, "");
            ResultSet rs = sql.ct.executeQuery();
            if(rs.next() == true){
                ciclo.setIdCiclo(rs.getInt("IdCiclo"));
                ciclo.setCiclo(rs.getString("Ciclo"));
                ciclo.setCantidadUnidades(rs.getInt("CantidadUnidades"));
                ciclo.setNotaMinima(rs.getInt("NotaMinima"));
                ciclo.setDiaPago(rs.getInt("DiaPago"));
                ciclo.setMoraDia(rs.getBigDecimal("MoraDia"));
                ciclo.setEstado(rs.getBoolean("Estado"));
            }
            rs.close();
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return ciclo;        
    }
    
}
