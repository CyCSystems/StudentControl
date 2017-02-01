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
import com.cycsystemsgt.student_control.Modelo.Entidades.Ciclo;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angel
 */
public class NotasForm extends javax.swing.JInternalFrame {

    private Boolean CreandoNotas = false;
    private Coordinador coordinador;
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public NotasForm() {
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
    
    public void deshabilitarCampos(){
        cbJornada.setEnabled(false);
        cbNivel.setEnabled(false);
        cbSeccion.setEnabled(false);
        cbGrado.setEnabled(false);
        cbMateria.setEnabled(false);
        cbUnidad.setEnabled(false);
        cbAlumno.setEnabled(false);
        txtExamen.setEnabled(false);
        txtZona.setEnabled(false);
        btnAgregar.setEnabled(false);
        tblNotas.setEnabled(false);
    }
    
    public void habilitarCampos(){
        cbJornada.setEnabled(true);
        cbNivel.setEnabled(true);
        cbSeccion.setEnabled(true);
        cbGrado.setEnabled(true);
        cbMateria.setEnabled(true);
        cbUnidad.setEnabled(true);
        cbAlumno.setEnabled(true);
        txtExamen.setEnabled(true);
        txtZona.setEnabled(true);
        btnAgregar.setEnabled(true);
        tblNotas.setEnabled(true);
    }
    
    public void limpiarCampos(){
        int y = 0;
        cbJornada.setSelectedIndex(-1);
        cbNivel.setSelectedIndex(-1);
        cbSeccion.setSelectedIndex(-1);
        cbGrado.setSelectedIndex(-1);
        cbMateria.setSelectedIndex(-1);
        cbUnidad.setSelectedIndex(-1);
        cbAlumno.setSelectedIndex(-1);
        txtExamen.setText("");
        txtZona.setText("");
        txtFinal.setText("");
        DefaultTableModel model = (DefaultTableModel) tblNotas.getModel();
        int row = model.getRowCount();
        for(int x = 0; x < row; x++){
            y = 0;
            model.removeRow(y);
        }
        tblNotas.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotas = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cbAlumno = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtZona = new javax.swing.JTextField();
        txtExamen = new javax.swing.JTextField();
        txtFinal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbJornada = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbNivel = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbSeccion = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbGrado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbMateria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbUnidad = new javax.swing.JComboBox<>();
        lblCiclo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setTitle("Ingreso de Notas");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);

        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Zona", "Examen", "Nota Final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNotas);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Alumno:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Zona:");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Examen:");

        txtZona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtZonaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtZonaKeyReleased(evt);
            }
        });

        txtExamen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExamenKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtExamenKeyReleased(evt);
            }
        });

        txtFinal.setEnabled(false);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Final:");

        btnAgregar.setText("Agregar");
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(223, 223, 223)
                                .addComponent(jLabel9)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel10)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExamen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Jornada:");

        cbJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJornadaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nivel:");

        cbNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNivelActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seccion:");

        cbSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeccionActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Grado:");

        cbGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGradoActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Curso:");

        cbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMateriaActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Unidad:");

        cbUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUnidadActionPerformed(evt);
            }
        });

        lblCiclo.setForeground(new java.awt.Color(255, 255, 255));
        lblCiclo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCiclo.setText("2016");
        lblCiclo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSeccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbNivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setOpaque(false);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
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

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
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
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if(CreandoNotas == true){
            if(JOptionPane.showConfirmDialog(null, "Aun hay cambios pendientes por guardar, desea salir?", "Student Control", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
                limpiarCampos();
                deshabilitarCampos();
                this.hide();
            }
        }else{
            this.hide();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        deshabilitarCampos();
        limpiarCampos();
        CreandoNotas = false;
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblNotas.getModel();
        CicloDAO ciclo = new CicloDAO();
        ArrayList<String> Respuestas = new ArrayList<>();
        ItemComboBox item;
        @SuppressWarnings("UnusedAssignment")
        int Grado = 0;
        @SuppressWarnings("UnusedAssignment")
        int Unidad = 0, Materia = 0;
        @SuppressWarnings("UnusedAssignment")
        Ciclo Ciclo = new Ciclo();
        if(modelo.getRowCount() > 0){
            for(int i = 0; i < modelo.getRowCount(); i++){
                Notas nota = new Notas();
                nota.setIdNota(0);
                nota.setPersona(modelo.getValueAt(i, 0).toString());
                nota.setExamen(Double.parseDouble(modelo.getValueAt(i, 3).toString()));
                nota.setZona(Double.parseDouble(modelo.getValueAt(i, 2).toString()));
                nota.setTotal(Double.parseDouble(modelo.getValueAt(i, 4).toString()));
                nota.setCiclo(ciclo.buscarCiclo(lblCiclo.getText()).getIdCiclo());
                item = (ItemComboBox) cbMateria.getSelectedItem();
                nota.setMateria(Integer.parseInt(item.getID()));
                item = (ItemComboBox) cbUnidad.getSelectedItem();
                nota.setUnidad(Integer.parseInt(item.getID()));
                if(coordinador.guardarNota(nota) == false){
                    Respuestas.add(nota.getPersona());
                }
            }
            if(Respuestas.size() > 0){
                String Codigos = "";
                for(int i = 0; i < Respuestas.size(); i++){
                    Codigos += Respuestas.get(i) + "\n";
                }
                JOptionPane.showMessageDialog(null, "Las notas de los siguientes alumnos no fueron registrar: \n" + Codigos, 
                        "Student Control", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Notas guardadas exitosamente!", "Student Control", JOptionPane.ERROR_MESSAGE);
                deshabilitarCampos();
                limpiarCampos();
                btnGuardar.setEnabled(false);
                btnNuevo.setEnabled(true);
                btnCancelar.setEnabled(false);
            }
            
            if(cbUnidad.getSelectedIndex() != -1 && cbMateria.getSelectedIndex() != -1){
                Ciclo = coordinador.obtenerCiclo(lblCiclo.getText());
                ItemComboBox Item;
                Item = (ItemComboBox) cbGrado.getSelectedItem();
                Grado = Integer.parseInt(Item.getID());
                Item = (ItemComboBox) cbUnidad.getSelectedItem();
                Unidad = Integer.parseInt(Item.getID());
                Item = (ItemComboBox) cbMateria.getSelectedItem();
                Materia = Integer.parseInt(Item.getID());
                coordinador.notasComboAlumnos(Ciclo.getIdCiclo(), Grado, Unidad, Materia);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
        habilitarCampos();
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cbSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeccionActionPerformed
        if(cbNivel.getSelectedIndex() != -1 && cbJornada.getSelectedIndex() != -1 && cbSeccion.getSelectedIndex() != -1){
            ItemComboBox Item;
            int Jornada = 0, Seccion = 0, Nivel = 0;
            Item = (ItemComboBox) cbJornada.getSelectedItem();
            Jornada = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbSeccion.getSelectedItem();
            Seccion = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbNivel.getSelectedItem();
            Nivel = Integer.parseInt(Item.getID());
            coordinador.notasComboGrado(Jornada, Seccion, Nivel);
        }
    }//GEN-LAST:event_cbSeccionActionPerformed

    private void cbJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJornadaActionPerformed
        if(cbNivel.getSelectedIndex() != -1 && cbJornada.getSelectedIndex() != -1 && cbSeccion.getSelectedIndex() != -1){
            ItemComboBox Item;
            int Jornada = 0, Seccion = 0, Nivel = 0;
            Item = (ItemComboBox) cbJornada.getSelectedItem();
            Jornada = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbSeccion.getSelectedItem();
            Seccion = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbNivel.getSelectedItem();
            Nivel = Integer.parseInt(Item.getID());
            coordinador.notasComboGrado(Jornada, Seccion, Nivel);
        }
    }//GEN-LAST:event_cbJornadaActionPerformed

    private void cbNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNivelActionPerformed
        if(cbNivel.getSelectedIndex() != -1 && cbJornada.getSelectedIndex() != -1 && cbSeccion.getSelectedIndex() != -1){
            ItemComboBox Item;
            int Jornada = 0, Seccion = 0, Nivel = 0;
            Item = (ItemComboBox) cbJornada.getSelectedItem();
            Jornada = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbSeccion.getSelectedItem();
            Seccion = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbNivel.getSelectedItem();
            Nivel = Integer.parseInt(Item.getID());
            coordinador.notasComboGrado(Jornada, Seccion, Nivel);
        }
    }//GEN-LAST:event_cbNivelActionPerformed

    private void cbGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGradoActionPerformed
        int Grado = 0;
        int Unidad = 0, Materia = 0;
        Ciclo ciclo = new Ciclo();
        if(cbGrado.getSelectedIndex() != -1 ){
            ItemComboBox Item;
            Item = (ItemComboBox) cbGrado.getSelectedItem();
            Grado = Integer.parseInt(Item.getID());
            ciclo = coordinador.obtenerCiclo(lblCiclo.getText());
            coordinador.notasComboMateria(Grado);            
        }
        
        if(cbUnidad.getSelectedIndex() != -1 && cbMateria.getSelectedIndex() != -1 && cbGrado.getSelectedIndex() != -1){
            ciclo = coordinador.obtenerCiclo(lblCiclo.getText());
            ItemComboBox Item;
            Item = (ItemComboBox) cbGrado.getSelectedItem();
            Grado = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbUnidad.getSelectedItem();
            Unidad = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbMateria.getSelectedItem();
            Materia = Integer.parseInt(Item.getID());
            coordinador.notasComboAlumnos(ciclo.getIdCiclo(), Grado, Unidad, Materia);
        }
    }//GEN-LAST:event_cbGradoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        ArrayList<Boolean> noProcesar = new ArrayList<>();
        if(!"".equals(txtExamen.getText()) && !"".equals(txtZona.getText()) && 
           !"".equals(txtFinal.getText()) && !"0".equals(txtFinal.getText()) &&
           cbAlumno.getSelectedIndex() != -1){
            DefaultTableModel modelo = (DefaultTableModel) tblNotas.getModel();
            ItemComboBox item;
            item = (ItemComboBox) cbAlumno.getSelectedItem();
            for(int i = 0; i < modelo.getRowCount(); i++){
                if(item.getID().equals(modelo.getValueAt(i, 0))){
                    noProcesar.add(true);
                }else{
                    noProcesar.add(false);
                }
            }
            if(!noProcesar.contains(true)){
                Object[] fila = {item.getID(), item.toString(), txtExamen.getText(), txtZona.getText(), txtFinal.getText()};
                modelo.addRow(fila);
                tblNotas.setModel(modelo);
                cbAlumno.setSelectedIndex(-1);
                txtExamen.setText("");
                txtZona.setText("");
                txtFinal.setText("0");
            }else{
                JOptionPane.showMessageDialog(null, "Error: el Alumno especificado ya le ha agregado la nota", "Student Control", JOptionPane.ERROR_MESSAGE);
            }
        }else if("".equals(txtExamen.getText())){
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar la nota del examen", "Estudent Control", JOptionPane.ERROR_MESSAGE);
        }else if("".equals(txtZona.getText())){
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar la zona acumulada", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(cbAlumno.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Error: Debe Seleccionar un alumno para asignar la nota", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Error: Debe completar los datos para guardar la nota", "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtZonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZonaKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtZonaKeyTyped

    private void txtZonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZonaKeyReleased
        if(!"".equals(txtExamen.getText()) && !"".equals(txtZona.getText())){
            txtFinal.setText(String.valueOf(Integer.parseInt(txtExamen.getText()) + Integer.parseInt(txtZona.getText())));
        }
    }//GEN-LAST:event_txtZonaKeyReleased

    private void txtExamenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExamenKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtExamenKeyTyped

    private void txtExamenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExamenKeyReleased
        if(!"".equals(txtExamen.getText()) && !"".equals(txtZona.getText())){
            txtFinal.setText(String.valueOf(Double.parseDouble(txtExamen.getText()) + Double.parseDouble(txtZona.getText())));
        }else{
            txtFinal.setText("0");
        }
    }//GEN-LAST:event_txtExamenKeyReleased

    private void cbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMateriaActionPerformed
        int Grado = 0;
        int Unidad = 0, Materia = 0;
        Ciclo ciclo = new Ciclo();
        if(cbUnidad.getSelectedIndex() != -1 && cbMateria.getSelectedIndex() != -1){
            ciclo = coordinador.obtenerCiclo(lblCiclo.getText());
            ItemComboBox Item;
            Item = (ItemComboBox) cbGrado.getSelectedItem();
            Grado = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbUnidad.getSelectedItem();
            Unidad = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbMateria.getSelectedItem();
            Materia = Integer.parseInt(Item.getID());
            coordinador.notasComboAlumnos(ciclo.getIdCiclo(), Grado, Unidad, Materia);
        }
    }//GEN-LAST:event_cbMateriaActionPerformed

    private void cbUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUnidadActionPerformed
        int Grado = 0;
        int Unidad = 0, Materia = 0;
        Ciclo ciclo = new Ciclo();
        if(cbUnidad.getSelectedIndex() != -1 && cbMateria.getSelectedIndex() != -1){
            ciclo = coordinador.obtenerCiclo(lblCiclo.getText());
            ItemComboBox Item;
            Item = (ItemComboBox) cbGrado.getSelectedItem();
            Grado = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbUnidad.getSelectedItem();
            Unidad = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbMateria.getSelectedItem();
            Materia = Integer.parseInt(Item.getID());
            coordinador.notasComboAlumnos(ciclo.getIdCiclo(), Grado, Unidad, Materia);
        }
    }//GEN-LAST:event_cbUnidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cbAlumno;
    public javax.swing.JComboBox<String> cbGrado;
    public javax.swing.JComboBox<String> cbJornada;
    public javax.swing.JComboBox<String> cbMateria;
    public javax.swing.JComboBox<String> cbNivel;
    public javax.swing.JComboBox<String> cbSeccion;
    public javax.swing.JComboBox<String> cbUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblCiclo;
    private javax.swing.JTable tblNotas;
    private javax.swing.JTextField txtExamen;
    private javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtZona;
    // End of variables declaration//GEN-END:variables
}
