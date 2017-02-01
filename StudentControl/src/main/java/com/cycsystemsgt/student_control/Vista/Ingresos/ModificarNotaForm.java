/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Vista.Ingresos;

import com.cycsystemsgt.student_control.Controlador.Coordinador;
import com.cycsystemsgt.student_control.Modelo.Dao.CicloDAO;
import com.cycsystemsgt.student_control.Modelo.Entidades.Notas;
import com.cycsystemsgt.student_control.util.ItemComboBox;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lrodas
 */
public class ModificarNotaForm extends javax.swing.JInternalFrame {

    Coordinador coordinador;
    private Boolean nuevo = false;
    private Integer CodigoNota = 0;
    private Integer CodigoMateria = 0;
    private String DescripcionMateria = "";
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ModificarNotaForm() {
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(getClass().getResource("/Fondo3.jpg"));
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        initComponents();
    }
    
    public void setCoordinador(Coordinador coordinador){
        this.coordinador = coordinador;
    }
    
    private void activarCampos(){
        cbUnidad.setEnabled(true);
        txtExamen.setEnabled(true);
        txtZona.setEnabled(true);
        btnBuscar.setEnabled(true);
    }
    
    private void limpiarCampos(){
        CodigoMateria = 0;
        CodigoNota = 0;
        DescripcionMateria = "";
        txtCodigo.setText("");
        txtExamen.setText("");
        txtZona.setText("");
        txtFinal.setText("");
    }
    
    private void desactivarCampos(){
        cbUnidad.setEnabled(false);
        txtExamen.setEnabled(false);
        txtZona.setEnabled(false);
        btnBuscar.setEnabled(false);
        tblNotas.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbUnidad = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtExamen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtZona = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFinal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotas = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setTitle("Modificar Nota");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo:");

        txtCodigo.setEnabled(false);

        btnBuscar.setText("...");
        btnBuscar.setEnabled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Unidad:");

        cbUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbUnidad.setEnabled(false);
        cbUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUnidadActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Examen:");

        txtExamen.setEnabled(false);
        txtExamen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExamenKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtExamenKeyReleased(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Zona:");

        txtZona.setEnabled(false);
        txtZona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtZonaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtZonaKeyReleased(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Final:");

        txtFinal.setEnabled(false);

        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Curso", "Examen", "Zona", "Final"
            }
        ));
        tblNotas.setEnabled(false);
        tblNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNotas);

        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregar))
                            .addComponent(cbUnidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtExamen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(btnNuevo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        nuevo = true;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(tblNotas.getRowCount() > 0){
            DefaultTableModel modelo = (DefaultTableModel) tblNotas.getModel();
            ArrayList<Boolean> Respuestas = new ArrayList<>();
            ItemComboBox item;
            for(int i = 0; i < modelo.getRowCount(); i++){
                Notas nota = new Notas();
                CicloDAO ciclo = new CicloDAO();
                item = (ItemComboBox) cbUnidad.getSelectedItem();
                nota.setIdNota(Integer.parseInt(modelo.getValueAt(i, 0).toString()));
                nota.setUnidad(Integer.parseInt(item.getID()));
                nota.setMateria(Integer.parseInt(modelo.getValueAt(i, 1).toString()));
                nota.setPersona(txtCodigo.getText());
                nota.setCiclo(ciclo.obtenerCicloActivo().getIdCiclo());
                nota.setExamen(Double.parseDouble(modelo.getValueAt(i, 3).toString()));
                nota.setZona(Double.parseDouble(modelo.getValueAt(i, 4).toString()));
                nota.setTotal(Double.parseDouble(modelo.getValueAt(i, 5).toString()));
                Respuestas.add(coordinador.modificarNota(nota));
            }
            if(Respuestas.contains(false)){
                JOptionPane.showMessageDialog(null, "Error: algunas de las notas no pudieron guardarse correctamente", "Student Control", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Notas guardadas exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
            }
            
            desactivarCampos();
            limpiarCampos();
            DefaultTableModel limpiar = (DefaultTableModel) tblNotas.getModel();
            limpiar.setRowCount(0);
            this.nuevo = false;
            tblNotas.setModel(limpiar);
            cbUnidad.setSelectedIndex(-1);
            btnNuevo.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desactivarCampos();
        limpiarCampos();
        btnBuscar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnNuevo.setEnabled(true);
        nuevo = false;
        DefaultTableModel modelo = (DefaultTableModel) tblNotas.getModel();
        for(int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(0);
        }
        tblNotas.setModel(modelo);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if(nuevo == true){
            int x = JOptionPane.showConfirmDialog(null, "Aun hay cambios pendientes ¿realmente desea salir?", "Student Control", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(x == JOptionPane.YES_OPTION){
                limpiarCampos();
                desactivarCampos();
                this.hide();
            }
        }else{
            this.hide();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        coordinador.dialoAlumno.setVisible(true);
        if(!coordinador.dialoAlumno.Alumno.equals("")){
            txtCodigo.setText(coordinador.dialoAlumno.Alumno);
            tblNotas.setEnabled(true);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUnidadActionPerformed
        if(cbUnidad.getSelectedIndex() != -1){
            ItemComboBox Item = (ItemComboBox) cbUnidad.getSelectedItem();
            tblNotas.setModel(coordinador.notasAlumno(txtCodigo.getText(), Integer.parseInt(Item.getID())));
        }
    }//GEN-LAST:event_cbUnidadActionPerformed

    private void tblNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNotasMouseClicked
        int row = tblNotas.getSelectedRow();
        if(row >= 0){
            CodigoNota = Integer.parseInt(tblNotas.getValueAt(row, 0).toString());
            CodigoMateria = Integer.parseInt(tblNotas.getValueAt(row, 1).toString());
            DescripcionMateria = tblNotas.getValueAt(row, 2).toString();
            txtExamen.setText(tblNotas.getValueAt(row, 3).toString());
            txtZona.setText(tblNotas.getValueAt(row, 4).toString());
            txtFinal.setText(tblNotas.getValueAt(row, 5).toString());
            DefaultTableModel modelo = (DefaultTableModel) tblNotas.getModel();
            modelo.removeRow(row);
            cbUnidad.setEnabled(false);
            tblNotas.setModel(modelo);
            btnAgregar.setEnabled(true);
        }
    }//GEN-LAST:event_tblNotasMouseClicked

    private void txtExamenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExamenKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtExamenKeyTyped

    private void txtZonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZonaKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtZonaKeyTyped

    private void txtZonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZonaKeyReleased
        if(!txtZona.getText().equals("") && !txtExamen.getText().equals("")){
            double Final = Double.parseDouble(txtZona.getText()) + Double.parseDouble(txtExamen.getText());
            txtFinal.setText(String.valueOf(Final));
        }
    }//GEN-LAST:event_txtZonaKeyReleased

    private void txtExamenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExamenKeyReleased
        if(!txtZona.getText().equals("") && !txtExamen.getText().equals("")){
            double Final = Double.parseDouble(txtZona.getText()) + Double.parseDouble(txtExamen.getText());
            txtFinal.setText(String.valueOf(Final));
        }
    }//GEN-LAST:event_txtExamenKeyReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(!txtZona.getText().trim().equals("") && !txtExamen.getText().trim().equals("")){
            DefaultTableModel modelo = (DefaultTableModel) tblNotas.getModel();
            Object[] fila = {
                CodigoNota,
                CodigoMateria,
                DescripcionMateria,
                txtExamen.getText(),
                txtZona.getText(),
                txtFinal.getText()
            };
            modelo.addRow(fila);
            tblNotas.setModel(modelo);
            limpiarCampos();
            btnAgregar.setEnabled(false);
            cbUnidad.setEnabled(true);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cbUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNotas;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtExamen;
    private javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtZona;
    // End of variables declaration//GEN-END:variables
}
