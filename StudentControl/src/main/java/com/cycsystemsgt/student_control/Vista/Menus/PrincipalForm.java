/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Vista.Menus;

import com.cycsystemsgt.student_control.Controlador.Coordinador;
import com.cycsystemsgt.student_control.Modelo.Entidades.Persona;
import com.cycsystemsgt.student_control.util.ImagenFondo;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class PrincipalForm extends javax.swing.JFrame {

    private Coordinador coordinador;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public PrincipalForm(Coordinador coordinador) {
        initComponents();
        this.setExtendedState(PrincipalForm.MAXIMIZED_BOTH);
        escritorio.setBorder(new ImagenFondo());
        setIconImage(new ImageIcon(getClass().getResource("/lapiz.png")).getImage());
        this.coordinador = coordinador;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        lblUsuario.setText(coordinador.Datos.getPNombre() + " " + coordinador.Datos.getPApellido());
        lblVersion.setText("2.0.0.0");
        lblRelease.setText("1");
        lblFecha.setText("" + formato.format(new Date()));
    }
    
    public void Acciones(String opc){
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        switch(opc){
            case "11":
                coordinador.showAlumnos();
                break;
            case "211":
                coordinador.showJornadas();
                break;
            case "212":
                coordinador.showNivel();
                break;
            case "213":
                coordinador.showGrado();
                break;
            case "221":
                coordinador.showUnidad();
                break;
            case "222":
                coordinador.showMateria();
                break;
            case "132":
                coordinador.showMotivoInasistencia();
                break;
            case "131":
                coordinador.showInasistencias();
                break;
            case "16":
                coordinador.showAsignacionAlumnos(new Persona());
                break;
            case "12":
                coordinador.showNotasform();
                break;
            case "15":
                coordinador.showmodificarNotaForm();
                break;
            case "42":
                coordinador.showClientesForm();
                break;
            case "411":
                coordinador.showProductosForm();
                break;
            case "45":
                coordinador.showRecibos();
                break;
            case "412":
                coordinador.showMovimientos();
                break;
            default:
                JOptionPane.showMessageDialog(null, "La opcion no se encuentra disponible o no se ha creado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblRelease = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Usuario:");

        lblUsuario.setText("jLabel3");

        jLabel4.setText("Version:");

        lblVersion.setText("jLabel5");

        jLabel6.setText("Release:");

        lblRelease.setText("jLabel7");

        jLabel8.setText("Fecha:");

        lblFecha.setText("jLabel9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVersion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRelease)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblUsuario)
                    .addComponent(jLabel4)
                    .addComponent(lblVersion)
                    .addComponent(jLabel6)
                    .addComponent(lblRelease)
                    .addComponent(jLabel8)
                    .addComponent(lblFecha))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(592, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addGap(0, 338, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblRelease;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblVersion;
    // End of variables declaration//GEN-END:variables

}
