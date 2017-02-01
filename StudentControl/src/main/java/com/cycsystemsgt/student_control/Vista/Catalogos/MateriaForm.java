/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Vista.Catalogos;


import com.cycsystemsgt.student_control.Modelo.Entidades.Grado;
import com.cycsystemsgt.student_control.Modelo.Entidades.Materia;
import com.cycsystemsgt.student_control.util.ItemComboBox;
import com.cycsystemsgt.student_control.Controlador.Coordinador;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author angel
 */
public class MateriaForm extends javax.swing.JInternalFrame {

    private Boolean ModificandoNivel = false;
    private Coordinador coordinador;
    
    public MateriaForm() {
         ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(getClass().getResource("/Fondo3.jpg"));
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        initComponents();
    }
    
    private void activarCampos() {
        txtMateria.setEnabled(true);
        cbEstado.setEnabled(true);
    }
    
    public void setCoordinador(Coordinador coordinador){
        this.coordinador = coordinador;
    }
    
    private void desactivarCampos(){
        txtMateria.setEnabled(false);
        cbEstado.setEnabled(false);
    }
    
    private void limpiarCampos(){
        txtCodigo.setText("");
        txtMateria.setText("");
        cbEstado.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMateria = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtMateria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbJornada = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbSeccion = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbGrado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbNivel = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setTitle("Administracion de Cursos por Grado");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);

        tblMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Curso", "Grado", "Estado"
            }
        ));
        tblMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMateriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMateria);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo:");

        txtCodigo.setEnabled(false);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Estado:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cbEstado.setEnabled(false);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Curso:");

        txtMateria.setEnabled(false);
        txtMateria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMateriaKeyTyped(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jornada:");

        cbJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJornadaActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seccion:");

        cbSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeccionActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Grado:");

        cbGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGradoActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nivel:");

        cbNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNivelActionPerformed(evt);
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
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMateria)
                            .addComponent(cbNivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSeccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setOpaque(false);

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

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
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
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSalir)
                                .addComponent(btnGuardar)
                                .addComponent(btnModificar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        activarCampos();
        cbJornada.setSelectedIndex(-1);
        cbSeccion.setSelectedIndex(-1);
        cbNivel.setSelectedIndex(-1);
        cbGrado.setSelectedIndex(-1);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        tblMateria.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!txtMateria.getText().trim().equals("") && cbGrado.getSelectedIndex() != -1 && cbEstado.getSelectedIndex() != -1){
            Materia materia = new Materia();
            boolean Resultado = false;
            ItemComboBox Item;
            materia.setIdMateria(Integer.parseInt("".equals(txtCodigo.getText()) ? "0" : txtCodigo.getText()));
            materia.setDescripcion(txtMateria.getText());
            materia.setEstado((cbEstado.getSelectedIndex() == 0));
            Item = (ItemComboBox) cbGrado.getSelectedItem();
            materia.setGrado(Integer.parseInt(Item.getID()));
            if(ModificandoNivel == false){
                if(cbEstado.getSelectedIndex() != -1){
                    if(coordinador.registrarMateria(materia) == true){
                        Resultado = true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Error: Guardando Materia intente de nuevo\nsí persiste el error comuniquese con el administrador", "Student Control", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    Resultado = false;
                    JOptionPane.showMessageDialog(null, "Error: Debe elegir el estado del Materia", "Student Control", JOptionPane.ERROR_MESSAGE);
                }
            }else if(ModificandoNivel == true){
                if(coordinador.modificarMateria(materia) == true){
                    Resultado = true;
                }else{
                    Resultado = false;
                    JOptionPane.showMessageDialog(null, "Error: Guardando Materia intente de nuevo\nsí persiste el error comuniquese con el administrador", "Student Control", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(Resultado == true){
                JOptionPane.showMessageDialog(null, "Materia guardada exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
                desactivarCampos();
                limpiarCampos();
                coordinador.cargarNivel();
                btnGuardar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnNuevo.setEnabled(true);
                btnModificar.setEnabled(false);
                tblMateria.setEnabled(true);
                ModificandoNivel = false;
                if(cbGrado.getSelectedIndex() != -1){
                    Item = (ItemComboBox) cbGrado.getSelectedItem();
                    coordinador.cargarTblMateria(Integer.parseInt(Item.getID()));
                }

            }
        }else if(txtMateria.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe especificar el nombre del curso", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(cbGrado.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el grado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(cbEstado.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el estado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        activarCampos();
        cbJornada.setEnabled(true);
        cbSeccion.setEnabled(true);
        cbNivel.setEnabled(true);
        cbGrado.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        tblMateria.setEnabled(false);
        ModificandoNivel = true;
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desactivarCampos();
        limpiarCampos();
        cbJornada.setEnabled(true);
        cbSeccion.setEnabled(true);
        cbNivel.setEnabled(true);
        cbGrado.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        tblMateria.setEnabled(true);
        ModificandoNivel = false;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if(ModificandoNivel == false){
            limpiarCampos();
            ModificandoNivel = false;
            desactivarCampos();
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnNuevo.setEnabled(true);
            btnModificar.setEnabled(false);
            tblMateria.setEnabled(true);
            this.hide();
        }else{
            int i = JOptionPane.showConfirmDialog(null, "Aun hay Cambios pendientes, realmente desea salir?", "Student Control", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if(i == JOptionPane.OK_OPTION){
                limpiarCampos();
                ModificandoNivel = false;
                desactivarCampos();
                btnGuardar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnNuevo.setEnabled(true);
                btnModificar.setEnabled(false);
                tblMateria.setEnabled(true);
                this.hide();
            }
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNivelActionPerformed
        if(cbJornada.getSelectedIndex() != -1 && cbSeccion.getSelectedIndex() != -1 && cbNivel.getSelectedIndex() != -1){
            ItemComboBox Item;
            int Jornada = 0, Seccion = 0, Nivel = 0;
            Item = (ItemComboBox) cbJornada.getSelectedItem();
            Jornada = Integer.parseInt(Item.getID());
            Item =  (ItemComboBox) cbSeccion.getSelectedItem();
            Seccion = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbNivel.getSelectedItem();
            Nivel = Integer.parseInt(Item.getID());
            coordinador.gradoComboGrado(Jornada, Seccion, Nivel);
            if(cbGrado.getSelectedIndex() != -1){
                Item = (ItemComboBox) cbGrado.getSelectedItem();
                coordinador.cargarTblMateria(Integer.parseInt(Item.getID()));
            }
        }else{
            tblMateria.removeAll();
        }
    }//GEN-LAST:event_cbNivelActionPerformed

    private void cbGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGradoActionPerformed
        if(cbGrado.getSelectedIndex() != -1){
            ItemComboBox Item;
            Item = (ItemComboBox) cbGrado.getSelectedItem();
            coordinador.cargarTblMateria(Integer.parseInt(Item.getID()));
        }
    }//GEN-LAST:event_cbGradoActionPerformed

    private void tblMateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMateriaMouseClicked
        if(tblMateria.getSelectedRow() >= 0){
            int Row = tblMateria.getSelectedRow();
            Grado grado = new Grado();
            
            txtCodigo.setText(tblMateria.getValueAt(Row, 0).toString());
            txtMateria.setText(tblMateria.getValueAt(Row, 1).toString());
            cbEstado.setSelectedItem(tblMateria.getValueAt(Row, 3).toString());
            grado = coordinador.obtenerGrado(Integer.parseInt(tblMateria.getValueAt(Row, 0).toString()));
            Coordinador.setSelectedValue(cbJornada, grado.getJornada());
            Coordinador.setSelectedValue(cbSeccion, grado.getSeccion());
            Coordinador.setSelectedValue(cbNivel, grado.getNivel());
            Coordinador.setSelectedValue(cbGrado, grado.getIdGrado());
            cbJornada.setEnabled(false);
            cbSeccion.setEnabled(false);
            cbNivel.setEnabled(false);
            cbGrado.setEnabled(false);
            btnGuardar.setEnabled(false);
            btnNuevo.setEnabled(false);
            btnModificar.setEnabled(true);
            btnCancelar.setEnabled(true);
        }
        
    }//GEN-LAST:event_tblMateriaMouseClicked

    private void cbJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJornadaActionPerformed
        if(cbJornada.getSelectedIndex() != -1 && cbSeccion.getSelectedIndex() != -1 && cbNivel.getSelectedIndex() != -1){
            ItemComboBox Item;
            int Jornada = 0, Seccion = 0, Nivel = 0;
            Item = (ItemComboBox) cbJornada.getSelectedItem();
            Jornada = Integer.parseInt(Item.getID());
            Item =  (ItemComboBox) cbSeccion.getSelectedItem();
            Seccion = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbNivel.getSelectedItem();
            Nivel = Integer.parseInt(Item.getID());
            coordinador.gradoComboGrado(Jornada, Seccion, Nivel);   
            if(cbGrado.getSelectedIndex() != -1){
                Item = (ItemComboBox) cbGrado.getSelectedItem();
                coordinador.cargarTblMateria(Integer.parseInt(Item.getID()));
            }
        }else{
            tblMateria.removeAll();
        }
//        if(cbGrado.getSelectedIndex() != -1){
//            ItemComboBox Item;
//            Item = (ItemComboBox) cbGrado.getSelectedItem();
//            coordinador.cargarTblMateria(Integer.parseInt(Item.getID()));
//        }
    }//GEN-LAST:event_cbJornadaActionPerformed

    private void cbSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeccionActionPerformed
        if(cbJornada.getSelectedIndex() != -1 && cbSeccion.getSelectedIndex() != -1 && cbNivel.getSelectedIndex() != -1){
            ItemComboBox Item;
            int Jornada = 0, Seccion = 0, Nivel = 0;
            Item = (ItemComboBox) cbJornada.getSelectedItem();
            Jornada = Integer.parseInt(Item.getID());
            Item =  (ItemComboBox) cbSeccion.getSelectedItem();
            Seccion = Integer.parseInt(Item.getID());
            Item = (ItemComboBox) cbNivel.getSelectedItem();
            Nivel = Integer.parseInt(Item.getID());
            coordinador.gradoComboGrado(Jornada, Seccion, Nivel);
            if(cbGrado.getSelectedIndex() != -1){
                Item = (ItemComboBox) cbGrado.getSelectedItem();
                coordinador.cargarTblMateria(Integer.parseInt(Item.getID()));
            }
        }else{
            tblMateria.removeAll();
        }
    }//GEN-LAST:event_cbSeccionActionPerformed

    private void txtMateriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMateriaKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtMateriaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cbEstado;
    public javax.swing.JComboBox<String> cbGrado;
    public javax.swing.JComboBox<String> cbJornada;
    public javax.swing.JComboBox<String> cbNivel;
    public javax.swing.JComboBox<String> cbSeccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblMateria;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtMateria;
    // End of variables declaration//GEN-END:variables

    
}
