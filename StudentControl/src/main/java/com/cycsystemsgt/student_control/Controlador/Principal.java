/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Controlador;

import com.cycsystemsgt.student_control.Modelo.Logica;
import com.cycsystemsgt.student_control.Vista.Menus.LoginForm;
import javax.swing.JOptionPane;


/**
 *
 * @author angel
 */
public class Principal {
    
    private Logica logica;
    private LoginForm login;
    private Coordinador coordinador;
    
    
    public static void main(String args[]){
        Principal principal = new Principal();
        principal.Iniciar();
    }
    
    public void Iniciar(){
        try{
            coordinador = new Coordinador();
            login = new LoginForm();
            logica = new Logica();

            coordinador.setVentanaLogin(login);        
            login.setCoordinador(coordinador);
            logica.setCoordinador(coordinador);
            coordinador.setLogica(logica);

            coordinador.showLogin();
        }catch(NoClassDefFoundError e){
            JOptionPane.showMessageDialog(null, e.getMessage() + " " + e.toString());
            e.printStackTrace();
        }
    }
    
    
    
    
    
}
