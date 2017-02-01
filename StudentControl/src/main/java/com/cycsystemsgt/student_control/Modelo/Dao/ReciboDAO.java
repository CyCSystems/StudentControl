/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Detalle;
import com.cycsystemsgt.student_control.Modelo.Entidades.DetallePagoRecibo;
import com.cycsystemsgt.student_control.Modelo.Entidades.Recibo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class ReciboDAO {
    Transacciones sql = new Transacciones();
    
    public Boolean registrarRecibo(Recibo recibo, List<Detalle> detalles, DetallePagoRecibo detallePago, Integer usuario){
        int resultadoMaestro = 0;
        try{
            sql.open();
            sql.conexion.setAutoCommit(false);
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Recibo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 1);
            sql.ct.setInt(2, recibo.getIdRecibo());
            sql.ct.setTimestamp(3, recibo.getFechaVenta());
            sql.ct.setDouble(4, recibo.getDescuento());
            sql.ct.setDouble(5, recibo.getTotal());
            sql.ct.setBoolean(6, recibo.getEstado());
            sql.ct.setString(7, recibo.getCliente().toString());
            sql.ct.setString(8, recibo.getEmpleado().toString());
            sql.ct.setInt(9, recibo.getCoutas());
            if(recibo.getAlumno() == null){
                sql.ct.setNull(10, java.sql.Types.VARCHAR);
            }else{
                sql.ct.setString(10, recibo.getAlumno());
            }
            if(detallePago.getNumeroDocumento() == null){
                sql.ct.setNull(11, java.sql.Types.VARCHAR);
            }else{
                sql.ct.setString(11, detallePago.getNumeroDocumento());
            }
            sql.ct.setInt(12, detallePago.getFormaPago());
            resultadoMaestro = sql.ct.executeUpdate();
            if(resultadoMaestro > 0){
                for(Detalle detalle : detalles){
                    sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Detalle(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    sql.ct.setInt(1, 1);
                    sql.ct.setInt(2, 0);
                    sql.ct.setInt(3, recibo.getIdRecibo());
                    sql.ct.setInt(4, detalle.getCantidad());
                    sql.ct.setDouble(5, detalle.getDescuento());
                    sql.ct.setDouble(6, detalle.getSubTotal());
                    if(detalle.getProducto() == null){
                        sql.ct.setNull(7, java.sql.Types.INTEGER);
                    }else{
                        sql.ct.setInt(7, detalle.getProducto());
                    }
                    if(detalle.getMes() == null){
                        sql.ct.setNull(8, java.sql.Types.STRUCT);
                    }else{
                        sql.ct.setInt(8, detalle.getMes());
                    }
                    sql.ct.setInt(9, usuario);
                    sql.ct.executeUpdate();
                }
            }
            sql.conexion.commit();
            sql.conexion.setAutoCommit(true);
            return true;
        }catch(SQLException e){
            try {
                sql.conexion.rollback();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(ReciboDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public String obtenerCorrelativoRecibo(){
        String correlativo = "";
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Recibo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 5);
            sql.ct.setInt(2, 0);
            sql.ct.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            sql.ct.setDouble(4, 0.0);
            sql.ct.setDouble(5, 0.0);
            sql.ct.setBoolean(6, false);
            sql.ct.setString(7, "");
            sql.ct.setString(8, "");
            sql.ct.setInt(9, 0);
            sql.ct.setNull(10, java.sql.Types.VARCHAR);
            sql.ct.setNull(11, java.sql.Types.VARCHAR);
            sql.ct.setNull(12, java.sql.Types.INTEGER);
            
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                if(rs.getInt("Codigo") < 10){
                    correlativo = "000" + rs.getInt("Codigo");
                }else if(rs.getInt("Codigo") < 100){
                    correlativo = "00" + rs.getInt("Codigo");
                }else if(rs.getInt("Codigo") < 1000){
                    correlativo = "0" + rs.getInt("Codigo");
                }else{
                    correlativo = rs.getString("Codigo");    
                }
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return correlativo;
    }
}
