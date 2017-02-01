/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */

package com.cycsystemsgt.student_control.Modelo.Dao;

import com.cycsystemsgt.student_control.Modelo.Coneccion.Transacciones;
import com.cycsystemsgt.student_control.Modelo.Entidades.Documento;
import com.cycsystemsgt.student_control.Modelo.Entidades.Telefono;
import com.cycsystemsgt.student_control.Modelo.Entidades.Persona;
import com.cycsystemsgt.student_control.Modelo.Entidades.DatosLogin;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class PersonaDAO {
    
    Transacciones sql = new Transacciones();
    
    /**
     *
     * @param Operacion
     * @param Alumno
     * @param Encargado
     * @param telefono
     * @param documento
     * @param Persona
     * @return
     */
    public Boolean registrarAlumno(Integer Operacion, Persona Alumno, Persona Encargado, Telefono telefono, Documento documento, String Persona){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        boolean Resultado = false;
        sql.open();
        try{
                sql.ct = sql.conexion.prepareCall("CALL sp_Registrar_Alumno(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setString(1, Encargado.getIdPersona());
            sql.ct.setString(2, Encargado.getPNombre());
            sql.ct.setString(3, Encargado.getSNombre());
            sql.ct.setString(4, Encargado.getPApellido());
            sql.ct.setString(5, Encargado.getSApelido());
            sql.ct.setBoolean(6, Encargado.getEstado());
            sql.ct.setString(7, Encargado.getDireccion());
            sql.ct.setInt(8, Encargado.getGenero());
            sql.ct.setInt(9, Encargado.getRol());
            sql.ct.setString(10, Encargado.getUsuario());
            sql.ct.setString(11, Encargado.getPass());
            sql.ct.setString(12, Alumno.getIdPersona());
            sql.ct.setString(13, Alumno.getPNombre());
            sql.ct.setString(14, Alumno.getSNombre());
            sql.ct.setString(15, Alumno.getTNombre());
            sql.ct.setString(16, Alumno.getPApellido());
            sql.ct.setString(17, Alumno.getSApelido());
            sql.ct.setBoolean(18, Alumno.getEstado());
            sql.ct.setInt(19, Alumno.getGenero());
            sql.ct.setDate(20, Date.valueOf(formato.format(Alumno.getFechaNacimiento())));
            sql.ct.setDate(21, Date.valueOf(formato.format(Alumno.getFechaIngreso())));
            sql.ct.setInt(22, documento.getTipoDocumento());
            sql.ct.setString(23, documento.getNumero());
            sql.ct.setString(24, telefono.getTelefono());
            sql.ct.setInt(25, Operacion);
            sql.ct.setString(26, Persona);
            sql.ct.executeUpdate();
            Resultado = true;
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            Resultado = false;
        }
        return Resultado;
    }
    
    public Boolean registrarPersona(Persona mPersona){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Persona(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 1);
            sql.ct.setString(2, mPersona.getIdPersona());
            sql.ct.setString(3, mPersona.getPNombre());
            sql.ct.setString(4, mPersona.getSNombre());
            sql.ct.setString(5, mPersona.getTNombre());
            sql.ct.setString(6, mPersona.getPApellido());
            sql.ct.setString(7, mPersona.getSApelido());
            sql.ct.setDate(8, (Date) mPersona.getFechaNacimiento());
            sql.ct.setString(9, mPersona.getDireccion());
            sql.ct.setInt(10, mPersona.getGenero());
            sql.ct.setDate(11, (Date) mPersona.getFechaIngreso());
            sql.ct.setBoolean(12, mPersona.getEstado());
            sql.ct.setInt(13, mPersona.getRol());
            sql.ct.setString(14, mPersona.getUsuario());
            sql.ct.setString(15, mPersona.getPass());
            if("0".equals(mPersona.getEncargado())){
                sql.ct.setNull(16, 0);
            }else{
                sql.ct.setString(16, mPersona.getEncargado());
            }
            
            sql.ct.setBoolean(17, mPersona.getPagaExtras());    
            if(sql.ct.executeUpdate() > 0){
                return true;
            }
            sql.ct.close();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error; " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        } 
        return false;
    }
    
    public Integer generarCodigo(){
        sql.open();
        int newId = 0;
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Proximo_Codigo_Persona()");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next()){
                newId = rs.getInt("Id");
            }
            rs.close();
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        if(newId != 0){
            return newId;
        }else{
            return 0;
        }
    }
    
    public Persona buscarPersona(String IdPersona){
        Persona persona = new Persona();
        sql.open();
        boolean existe = false;
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Persona(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 6);
            sql.ct.setString(2, IdPersona);
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            sql.ct.setString(5, "");
            sql.ct.setString(6, "");
            sql.ct.setString(7, "");
            sql.ct.setDate(8, Date.valueOf("2016-01-01"));
            sql.ct.setString(9, "");
            sql.ct.setInt(10, 0);
            sql.ct.setDate(11, Date.valueOf("2016-01-01"));
            sql.ct.setBoolean(12, false);
            sql.ct.setInt(13, 0);
            sql.ct.setString(14, "");
            sql.ct.setString(15, "");
            sql.ct.setString(16, "");
            sql.ct.setBoolean(17, true);
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                existe = true;
                persona.setIdPersona(rs.getString("IdPersona"));
                persona.setPNombre(rs.getString("PNombre"));
                persona.setSNombre(rs.getString("SNombre"));
                persona.setTNombre(rs.getString("TNombre"));
                persona.setPApellido(rs.getString("PApellido"));
                persona.setSApelido(rs.getString("SApellido"));
                persona.setDireccion(rs.getString("Direccion"));
                persona.setFechaNacimiento(rs.getDate("FechaNacimiento"));
                persona.setGenero(rs.getInt("Genero"));
                persona.setFechaIngreso(rs.getDate("FechaIngreso"));
                persona.setEstado(rs.getBoolean("Estado"));
                persona.setRol(rs.getInt("Rol"));
                persona.setUsuario(rs.getString("Usuario"));
                persona.setPass(rs.getString("Pass"));
                persona.setEncargado(rs.getString("Encargado"));
                persona.setPagaExtras(rs.getBoolean("PagaExtras"));
                persona.setTipoPersona(rs.getInt("TipoPersona"));
            }
            rs.close();
            sql.ct.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        if(existe == true){
            return persona;
        }else{
            return persona;
        }
    }
    
    public ArrayList<String> buscarAlumno(String IdPersona){
        ArrayList<String> Alumno = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Persona(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 3);
            sql.ct.setString(2, IdPersona);
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            sql.ct.setString(5, "");
            sql.ct.setString(6, "");
            sql.ct.setString(7, "");
            sql.ct.setDate(8, Date.valueOf("2016-01-01"));
            sql.ct.setString(9, "");
            sql.ct.setInt(10, 0);
            sql.ct.setDate(11, Date.valueOf("2016-01-01"));
            sql.ct.setBoolean(12, false);
            sql.ct.setInt(13, 0);
            sql.ct.setString(14, "");
            sql.ct.setString(15, "");
            sql.ct.setString(16, "");
            sql.ct.setBoolean(17, true);
            ResultSet rs = sql.ct.executeQuery();
            if(rs.next() == true){
                Alumno.add(rs.getString("IdPersona"));
                Alumno.add(rs.getString("PNombre"));
                Alumno.add(rs.getString("SNombre"));
                Alumno.add(rs.getString("TNombre"));
                Alumno.add(rs.getString("PApellido"));
                Alumno.add(rs.getString("SApellido"));
                Alumno.add(rs.getString("FechaNacimiento"));
                Alumno.add(rs.getString("Genero"));
                Alumno.add(rs.getString("FechaIngreso"));
                Alumno.add(rs.getString("Estado"));
                Alumno.add(rs.getString("Encargado"));
                Alumno.add(rs.getString("EPNombre"));
                Alumno.add(rs.getString("ESNombre"));
                Alumno.add(rs.getString("EPApellido"));
                Alumno.add(rs.getString("ESApellido"));
                Alumno.add(rs.getString("Direccion"));
                Alumno.add(rs.getString("EGenero"));
                Alumno.add(rs.getString("EEstado"));
                Alumno.add(rs.getString("TipoPersona"));
                Alumno.add(rs.getString("Documento"));
                Alumno.add(rs.getString("Tipo"));
            }
            rs.close();
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return Alumno;
    }
        
    public ArrayList<Persona> listaEncargados(){
        ArrayList<Persona> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Persona(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 5);
            sql.ct.setString(2, "");
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            sql.ct.setString(5, "");
            sql.ct.setString(6, "");
            sql.ct.setString(7, "");
            sql.ct.setString(8, "2016-01-01");
            sql.ct.setString(9, "");
            sql.ct.setInt(10, 0);
            sql.ct.setString(11, "2016-01-01");
            sql.ct.setBoolean(12, false);
            sql.ct.setInt(13, 0);
            sql.ct.setString(14, "");
            sql.ct.setString(15, "");
            sql.ct.setInt(16, 0);
            sql.ct.setBoolean(17, false);
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Persona persona = new Persona();
                persona.setIdPersona(rs.getString("IdPersona"));
                persona.setPNombre(rs.getString("PNombre"));
                persona.setSNombre(rs.getString("SNombre"));
                persona.setPApellido(rs.getString("PApellido"));
                persona.setSApelido(rs.getString("SApellido"));
                persona.setEstado(rs.getBoolean("Estado"));
                lista.add(persona);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE );
        }
        return lista;
    }
    
    public ArrayList<Persona> ListaPersona(){
        ArrayList<Persona> Lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Persona(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 4);
            sql.ct.setString(2, "");
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            sql.ct.setString(5, "");
            sql.ct.setString(6, "");
            sql.ct.setString(7, "");
            sql.ct.setString(8, "2016-01-01");
            sql.ct.setString(9, "");
            sql.ct.setInt(10, 0);
            sql.ct.setString(11, "2016-01-01");
            sql.ct.setBoolean(12, false);
            sql.ct.setInt(13, 0);
            sql.ct.setString(14, "");
            sql.ct.setString(15, "");
            sql.ct.setInt(16, 0);
            sql.ct.setBoolean(17, false);
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Persona persona = new Persona();
                persona.setIdPersona(rs.getString("IdPersona"));
                persona.setPNombre(rs.getString("PNombre"));
                persona.setPApellido(rs.getString("PApellido"));
                Lista.add(persona);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return Lista;
    }
    
    public void ModificarPersona(Persona mPersona){
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("call studentcontrol.sp_Crud_Persona(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            sql.ct.setInt(1, 2);
            sql.ct.setString(2, mPersona.getIdPersona());
            sql.ct.setString(3, mPersona.getPNombre());
            sql.ct.setString(4, mPersona.getSNombre());
            sql.ct.setString(5, mPersona.getPApellido());
            sql.ct.setString(6, mPersona.getSApelido());
            sql.ct.setDate(7, (Date) mPersona.getFechaNacimiento());
            sql.ct.setString(8, mPersona.getDireccion());
            sql.ct.setInt(9, mPersona.getGenero());
            sql.ct.setDate(10, (Date) mPersona.getFechaIngreso());
            sql.ct.setBoolean(11, mPersona.getEstado());
            sql.ct.setInt(12, mPersona.getRol());
            sql.ct.setString(13, mPersona.getUsuario());
            sql.ct.setString(14, mPersona.getPass());
            sql.ct.setString(15, mPersona.getEncargado());
            sql.ct.setBoolean(16, mPersona.getPagaExtras());
            if(sql.ct.executeUpdate()> 0){
                JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Student Control",JOptionPane.INFORMATION_MESSAGE);
            }
            sql.close();
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String[][] ObtenerMenus(String Usuario, String Pass){
        String[][] Opciones = null;
        int NumCols = 0;
        int NumRows = 0;
        int ContadorCols = 0;
        int ContadorRows = 0;
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Login(?,MD5(?))");
            sql.ct.setString(1, Usuario);
            sql.ct.setString(2, Pass);
            ResultSet rs = sql.ct.executeQuery();
            if(rs.last()){
                ResultSetMetaData rsmd = rs.getMetaData();
                NumCols = rsmd.getColumnCount();
                NumRows = rs.getRow();
                Opciones = new String[NumRows][NumCols];
                rs.beforeFirst();
                while(rs.next()){
                    for(ContadorCols = 0; ContadorCols < NumCols; ContadorCols++){
                        if(ContadorCols == 0){
                            Opciones[ContadorRows][ContadorCols] = rs.getString("Posicion");
                        }else{
                            Opciones[ContadorRows][ContadorCols] = rs.getString("Opcion");
                        }
                    }
                    ContadorRows++;
                }
            }
            sql.ct.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return Opciones;
    }
    
    public DatosLogin ObtenerDatosUsuario(String Usuario, String Pass){
        DatosLogin Datos = new DatosLogin();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Login(?,MD5(?))");
            sql.ct.setString(1, Usuario);
            sql.ct.setString(2, Pass);
            ResultSet rs = sql.ct.executeQuery();
            if(rs.next()){
                Datos.setIdPersona(rs.getString("IdPersona"));
                Datos.setPNombre(rs.getString("PNombre"));
                Datos.setPApellido(rs.getString("PApellido"));
                Datos.setRol(rs.getString("Rol"));
                Datos.setEstadoPersona(rs.getBoolean("EstadoPersona"));
                Datos.setEstadoRol(rs.getBoolean("EstadoRol"));
                Datos.setDepartamento(rs.getString("Departamento"));
                Datos.setTipoDepartamento(rs.getString("TipoDepartamento"));
            }
            sql.ct.close();
            rs.close();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        if(Datos != null){
            return Datos;
        }else{
            return null;
        }
    }
    
    public String[][] ObtenerPermisos(String Usuario, String Pass){
        String[][] Permisos = null;
        int ContadorRows = 0;
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Login(?,MD5(?))");
            sql.ct.setString(1, Usuario);
            sql.ct.setString(2, Pass);
            ResultSet rs = sql.ct.executeQuery();
            rs.last();
            Permisos = new String[rs.getRow()][5];
            rs.beforeFirst();
            while(rs.next()){
                Permisos[ContadorRows][0] = rs.getString("Opcion");
                Permisos[ContadorRows][1] = rs.getString("Altas");
                Permisos[ContadorRows][2] = rs.getString("Bajas");
                Permisos[ContadorRows][3] = rs.getString("Cambios");
                Permisos[ContadorRows][4] = rs.getString("Imprimir");
                ContadorRows++;
            }
            sql.ct.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return Permisos;
    }
    
    public ArrayList<Persona> obtenerAlumnos(Integer Grado){
        ArrayList<Persona> lista = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_AsignacionAlumno(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 6);
            sql.ct.setInt(2, 0);
            sql.ct.setDate(3, Date.valueOf("2016-01-01"));
            sql.ct.setInt(4, 0);
            sql.ct.setInt(5, Grado);
            sql.ct.setString(6, "");
            sql.ct.setBigDecimal(7, BigDecimal.valueOf(0.00));
            sql.ct.setBigDecimal(8, BigDecimal.valueOf(0.00));
            sql.ct.setString(9, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Persona persona = new Persona();
                persona.setIdPersona(rs.getString("IdPersona"));
                persona.setPNombre(rs.getString("PNombre"));
                persona.setTNombre(rs.getString("SNombre"));
                persona.setPApellido(rs.getString("PApellido"));
                persona.setSApelido(rs.getString("SApellido"));
                persona.setEstado(rs.getBoolean("Estado"));                
                lista.add(persona);
            }
            sql.ct.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public ArrayList<Persona> ListaAlumnos(Integer Grado, Integer Ciclo, Integer Unidad, Integer Materia){
        ArrayList<Persona> Lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Notas(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 5);
            sql.ct.setInt(2, 0);
            sql.ct.setString(3, "");
            sql.ct.setInt(4, Unidad);
            sql.ct.setBigDecimal(5, BigDecimal.valueOf(0.0));
            sql.ct.setBigDecimal(6, BigDecimal.valueOf(0.0));
            sql.ct.setBigDecimal(7, BigDecimal.valueOf(0.0));
            sql.ct.setInt(8, Materia);
            sql.ct.setInt(9, Ciclo);
            sql.ct.setInt(10, Grado);
            sql.ct.setString(11, "");
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Persona persona = new Persona();
                persona.setIdPersona(rs.getString("IdPersona"));
                persona.setPNombre(rs.getString("PNombre"));
                persona.setTNombre(rs.getString("TNombre"));
                persona.setPApellido(rs.getString("PApellido"));
                persona.setSApelido(rs.getString("SApellido"));
                persona.setEstado(rs.getBoolean("Estado"));                
                Lista.add(persona);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return Lista;
    }
    
    public Boolean registrarCliente (Persona persona, Telefono telefono, String usuario){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Registrar_Cliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 1);
            sql.ct.setString(2, persona.getIdPersona());
            sql.ct.setString(3, persona.getPNombre());
            sql.ct.setString(4, persona.getSNombre());
            sql.ct.setString(5, persona.getPApellido());
            sql.ct.setString(6, persona.getSApelido());
            sql.ct.setDate(7, Date.valueOf(formato.format(persona.getFechaNacimiento())));
            sql.ct.setString(8, persona.getDireccion());
            sql.ct.setInt(9, persona.getGenero());
            sql.ct.setInt(10, persona.getRol());
            sql.ct.setString(11, usuario);
            sql.ct.setString(12, telefono.getTelefono());
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarCliente (Persona persona, Telefono telefono, String usuario){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Registrar_Cliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 2);
            sql.ct.setString(2, persona.getIdPersona());
            sql.ct.setString(3, persona.getPNombre());
            sql.ct.setString(4, persona.getSNombre());
            sql.ct.setString(5, persona.getPApellido());
            sql.ct.setString(6, persona.getSApelido());
            sql.ct.setDate(7, Date.valueOf(formato.format(persona.getFechaNacimiento())));
            sql.ct.setString(8, persona.getDireccion());
            sql.ct.setInt(9, persona.getGenero());
            sql.ct.setInt(10, persona.getRol());
            sql.ct.setString(11, usuario);
            sql.ct.setString(12, telefono.getTelefono());
            sql.ct.executeUpdate();
            sql.ct.close();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public ArrayList<Persona> obtenerClientes(){
        ArrayList<Persona> lista = new ArrayList<>();
        sql.open();
        try{
            sql.ct = sql.conexion.prepareCall("CALL sp_Crud_Persona(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sql.ct.setInt(1, 7);
            sql.ct.setString(2, "");
            sql.ct.setString(3, "");
            sql.ct.setString(4, "");
            sql.ct.setString(5, "");
            sql.ct.setString(6, "");
            sql.ct.setString(7, "");
            sql.ct.setString(8, "2016-01-01");
            sql.ct.setString(9, "");
            sql.ct.setInt(10, 0);
            sql.ct.setString(11, "2016-01-01");
            sql.ct.setBoolean(12, false);
            sql.ct.setInt(13, 0);
            sql.ct.setString(14, "");
            sql.ct.setString(15, "");
            sql.ct.setInt(16, 0);
            sql.ct.setBoolean(17, false);
            ResultSet rs = sql.ct.executeQuery();
            while(rs.next() == true){
                Persona persona = new Persona();
                persona.setIdPersona(rs.getString("IdPersona"));
                persona.setPNombre(rs.getString("PNombre"));
                persona.setSNombre(rs.getString("SNombre"));
                persona.setPApellido(rs.getString("PApellido"));
                persona.setSApelido(rs.getString("SApellido"));
                persona.setFechaNacimiento(rs.getDate("FechaNacimiento"));
                persona.setDireccion(rs.getString("Direccion"));
                persona.setGenero(rs.getInt("Genero"));
                persona.setEstado(rs.getBoolean("Estado"));
                persona.setRol(rs.getInt("Rol"));
                lista.add(persona);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE );
        }
        return lista;
    }
    
    public ArrayList<String> obtenerMes(String Alumno){
        ArrayList<String> lista = new ArrayList<>();
        try{
            sql.open();
            sql.ct = sql.conexion.prepareCall("CALL sp_Obtener_Mes(?)");
            sql.ct.setString(1, Alumno);
            ResultSet rs = sql.ct.executeQuery();
            if(rs.next()==true){
                lista.add(rs.getString("Estado"));
                lista.add(rs.getString("valor"));
                lista.add(rs.getString("mora"));
                lista.add(rs.getString("cuotas"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
}
