/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Vista.Ingresos;

import com.cycsystemsgt.student_control.Modelo.Entidades.Inasistencia;
import com.cycsystemsgt.student_control.util.ItemComboBox;
import com.cycsystemsgt.student_control.Controlador.Coordinador;
import java.awt.HeadlessException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author angel
 */
public class InasistenciaForm extends javax.swing.JInternalFrame {

    private Boolean Modificando = false;
    private Boolean Nuevo = false;
    private Coordinador coordinador;
    private String[][] Permisos;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public InasistenciaForm(String[][] Permisos) {
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(getClass().getResource("/Fondo3.jpg"));
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        initComponents();
        txtAlumno.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(txtAlumno.getText().matches("^[A-Z]{1}\\d{3}[A-Z]{3}") || txtAlumno.getText().matches("^\\d{1,5}")){
                    coordinador.cargarTablaInasistencias(txtAlumno.getText());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(txtAlumno.getText().matches("^[A-Z]{1}\\d{3}[A-Z]{3}") || txtAlumno.getText().matches("^\\d{1,5}")){
                    coordinador.cargarTablaInasistencias(txtAlumno.getText());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(txtAlumno.getText().matches("^[A-Z]{1}\\d{3}[A-Z]{3}") || txtAlumno.getText().matches("^\\d{1,5}")){
                    coordinador.cargarTablaInasistencias(txtAlumno.getText());
                }
            }
            
        });
        this.Permisos = Permisos;
        for (String[] Forma : Permisos) {
            if("Ingreso de Inasistencias".equals(Forma[0])){
                if("1".equals(Forma[1])){
                    btnNuevo.setEnabled(true);
                }else{
                    btnNuevo.setEnabled(false);
                }
                if("1".equals(Forma[2])){
                    
                }else{
                    
                }
                if("1".equals(Forma[3])){
                    
                }else{
                    
                }
                if("1".equals(Forma[4])){
                    
                }else{
                    
                }
                break;
            }
        }
    }
    
    public void setCoordinador(Coordinador coordinador){
        this.coordinador = coordinador;
    }

    private void activarCampos() {
        dcFecha.setEnabled(true);
        cbMotivo.setEnabled(true);
        btnBuscar.setEnabled(true);
    }

    private void desactivarCampos() {
        dcFecha.setEnabled(false);
        cbMotivo.setEnabled(false);
        btnBuscar.setEnabled(false);
    }

    private void limpiarCampos() {
        txtAlumno.setText("");
        txtCodigo.setText("");
        dcFecha.setDate(null);
        cbMotivo.setSelectedIndex(-1);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAlumno = new javax.swing.JTextField();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbMotivo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInasistencias = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setTitle("Ingreso de Inasistencias por alumno");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Alumno:");

        txtAlumno.setEnabled(false);
        txtAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlumnoKeyTyped(evt);
            }
        });

        dcFecha.setEnabled(false);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha de la Inasistencia:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Motivo:");

        cbMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMotivo.setSelectedIndex(-1);
        cbMotivo.setEnabled(false);

        tblInasistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha", "Alumno", "Motivo"
            }
        ));
        tblInasistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInasistenciasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInasistencias);

        btnBuscar.setText("...");
        btnBuscar.setEnabled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Codigo:");

        txtCodigo.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(21, 21, 21)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(23, 23, 23)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMotivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(btnBuscar))
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setOpaque(false);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalir)
                        .addComponent(btnGuardar)
                        .addComponent(btnNuevo)
                        .addComponent(btnModificar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        activarCampos();
        btnBuscar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        tblInasistencias.setEnabled(false);
        Nuevo = true;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!this.txtAlumno.getText().trim().equals("") && this.dcFecha.getDate() != null &&
                this.cbMotivo.getSelectedIndex() > -1){
            try{
                Inasistencia Inasistencia = new Inasistencia();
                boolean Resultado = false;
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                ItemComboBox item;

                Inasistencia.setIdInasistencia(txtCodigo.getText().equals("") ? 0 : Integer.parseInt(txtCodigo.getText()));
                java.util.Date fechaControl = dcFecha.getDate();
                Date Fecha = new Date(fechaControl.getTime());
                Inasistencia.setFechaInasistencia(Fecha);
                Inasistencia.setPersona(txtAlumno.getText());
                item = (ItemComboBox) cbMotivo.getSelectedItem();
                Inasistencia.setMotivoInasistencia(Integer.parseInt(item.getID()));

                if(Modificando == true){
                    Resultado = coordinador.modificarInasistencia(Inasistencia);
                    Modificando = false;
                }else if(Nuevo == true){
                    Resultado = coordinador.registrarInasistencia(Inasistencia);
                }

                if(Resultado == true){
                    JOptionPane.showMessageDialog(null, "Inasistencia guardad exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
                    coordinador.cargarTablaInasistencias(txtAlumno.getText());
                    desactivarCampos();
                    limpiarCampos();
                    btnBuscar.setEnabled(false);
                    btnGuardar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnNuevo.setEnabled(true);
                    btnModificar.setEnabled(false);
                    tblInasistencias.setEnabled(true);
                    Modificando = false;
                    Nuevo = false;
                }
            }catch(NumberFormatException | HeadlessException e){
                JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            }
        }else if(this.txtAlumno.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar el codigo del alumno", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.dcFecha.getDate() == null){
            JOptionPane.showMessageDialog(null, "Debe ingresar la fecha de la inasistencia", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.cbMotivo.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el motivo de la inasistencia", "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desactivarCampos();
        limpiarCampos();
        btnBuscar.setEnabled(false);
        txtAlumno.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        tblInasistencias.setEnabled(true);
        Modificando = false;
        Nuevo = false;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if(Modificando == true || Nuevo == true){
            int x = JOptionPane.showConfirmDialog(null, "Aun hay cambios pendientes de guardar, Realmente desea Salir?", "Student Control", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(x == JOptionPane.OK_OPTION){
                desactivarCampos();
                limpiarCampos();
                btnGuardar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnNuevo.setEnabled(true);
                btnModificar.setEnabled(false);
                tblInasistencias.setEnabled(true);
                Modificando = false;
                Nuevo = false;
                this.hide();
            }
        }else{
            desactivarCampos();
            limpiarCampos();
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnNuevo.setEnabled(true);
            btnModificar.setEnabled(false);
            tblInasistencias.setEnabled(true);
            Modificando = false;
            Nuevo = false;
            this.hide();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        activarCampos();
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        tblInasistencias.setEnabled(false);
        Modificando = true;
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        coordinador.dialoAlumno.setVisible(true);
        if(!coordinador.dialoAlumno.Alumno.equals("")){
            txtAlumno.setText(coordinador.dialoAlumno.Alumno);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlumnoKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtAlumnoKeyTyped

    private void tblInasistenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInasistenciasMouseClicked
        try{
            int row = tblInasistencias.getSelectedRow();
            ItemComboBox Item;
            if(row > -1){
                String Fecha = tblInasistencias.getValueAt(row, 1).toString();
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date fechaDate = formato.parse(Fecha);
                txtCodigo.setText(tblInasistencias.getValueAt(row, 0).toString());
                txtAlumno.setText(tblInasistencias.getValueAt(row, 2).toString());
                dcFecha.setDate(fechaDate);
                Coordinador.setSelectedValue(cbMotivo, tblInasistencias.getValueAt(row, 3).toString());
                
                for (String[] Forma : Permisos) {
                    if("Ingreso de Inasistencias".equals(Forma[0])){
                        if("1".equals(Forma[3])){
                            txtAlumno.setEnabled(false);
                            btnBuscar.setEnabled(false);
                            btnNuevo.setEnabled(false);
                            btnGuardar.setEnabled(false);
                            btnModificar.setEnabled(true);
                            btnCancelar.setEnabled(true);
                        }
                        break;
                    }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblInasistenciasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cbMotivo;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblInasistencias;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
