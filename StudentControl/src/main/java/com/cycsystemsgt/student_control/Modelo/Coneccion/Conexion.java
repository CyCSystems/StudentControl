/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Modelo.Coneccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class Conexion {
    
    private static Connection conexion = null;
    private static final String driver="com.mysql.jdbc.Driver"; //el driver varia segun la DB que usemos
    private static final String url="jdbc:mysql://localhost:3306/studentcontrol?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //private static final String url="jdbc:mysql://192.168.1.4:3306/studentcontrol";
    private static final String pwd="Admin2016";
    private static final String usr="root";

    private Conexion() {
    } 
    
    /**
     * 
     * @return Coneccion a la base Student Control
     */
    public static Connection getConexion(){
        try{
            if(conexion == null){
                Class.forName(driver);
                conexion = DriverManager.getConnection(url, usr, pwd);
            }
            //JOptionPane.showMessageDialog(null, "Conexion establecida");
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error cargando driver: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Conectando a Base de Datos: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
    
}
