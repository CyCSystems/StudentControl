/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Vista.Catalogos;

import com.cycsystemsgt.student_control.util.ItemComboBox;
import com.cycsystemsgt.student_control.Controlador.Coordinador;
import com.cycsystemsgt.student_control.Modelo.Dao.CicloDAO;
import com.cycsystemsgt.student_control.Modelo.Entidades.AsignacionAlumno;
import com.cycsystemsgt.student_control.Modelo.Entidades.Persona;
import java.math.BigDecimal;
import java.sql.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author angel
 */
public class AsignacionAlumnoForm extends javax.swing.JInternalFrame {

    private Boolean Nuevo = false;
    private Boolean Modificando = false;
    private Coordinador coordinador;
    private Integer Correlativo = 0;
    public Date Fecha;
    private String[] permisos;
        
    public AsignacionAlumnoForm(Coordinador coordinador) {
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(getClass().getResource("/Fondo3.jpg"));
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        initComponents();
        this.coordinador = coordinador;
        for (String[] Permiso : coordinador.Permisos) {
            if ("Ficha de Ingreso".equals(Permiso[0])) {
                permisos = Permiso;
                if("1".equals(permisos[1])){
                    btnNuevo.setEnabled(true);
                }else{
                    btnNuevo.setEnabled(false);
                }
            }
        }
    }
    
    public void llenarCampos(Persona alumno){
        if(alumno.getIdPersona() != null && alumno.getPNombre() != null && alumno.getPApellido() != null){
            txtCodigoAlumno.setText(alumno.getIdPersona());
            txtAlumno.setText(alumno.getPNombre() + " " + alumno.getPApellido());
            if("1".equals(permisos[1])){
                btnNuevoActionPerformed(null);
                btnGuardar.setEnabled(true);
                btnModificar.setEnabled(false);
                btnCancelar.setEnabled(true);
                btnNuevo.setEnabled(false);
            }else{
                btnNuevo.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnModificar.setEnabled(false);
                btnCancelar.setEnabled(false);
            }
        }
    }

    private void activarCampos(){
        btnBuscar.setEnabled(true);
        txtInscripcion.setEnabled(true);
        txtMensualidad.setEnabled(true);
    }
    
    private void desactivarCampos(){
        btnBuscar.setEnabled(false);
        txtInscripcion.setEnabled(false);
        txtMensualidad.setEnabled(false);
    }
    
    private void limpiarCampos(){
        txtCodigoAlumno.setText("");
        txtAlumno.setText("");
        txtInscripcion.setText("");
        txtMensualidad.setText("");
        cbJornada.setSelectedIndex(-1);
        cbSeccion.setSelectedIndex(-1);
        cbNivel.setSelectedIndex(-1);
        cbGrado.setSelectedIndex(-1);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tblAsignacion = new javax.swing.JScrollPane();
        tblAsignacionAlumno = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbJornada = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbNivel = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbGrado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblCiclo = new javax.swing.JLabel();
        txtCodigoAlumno = new javax.swing.JTextField();
        txtAlumno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbSeccion = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        try{
            MaskFormatter mascara = new MaskFormatter("'Q###.##");
            txtMensualidad = new javax.swing.JFormattedTextField(mascara);
            txtInscripcion = new javax.swing.JFormattedTextField(mascara);
            jPanel2 = new javax.swing.JPanel();
            btnNuevo = new javax.swing.JButton();
            btnGuardar = new javax.swing.JButton();
            btnModificar = new javax.swing.JButton();
            btnCancelar = new javax.swing.JButton();
            btnSalir = new javax.swing.JButton();

            setTitle("Asignacion de Alumnos");

            jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            jPanel1.setOpaque(false);

            tblAsignacionAlumno.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Codigo", "Alumno", "Fecha", "Inscripcion", "Mensualidad"
                }
            ));
            tblAsignacionAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblAsignacionAlumnoMouseClicked(evt);
                }
            });
            tblAsignacion.setViewportView(tblAsignacionAlumno);

            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText("Alumno:");

            jLabel2.setForeground(new java.awt.Color(255, 255, 255));
            jLabel2.setText("Jornada:");

            cbJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            cbJornada.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cbJornadaActionPerformed(evt);
                }
            });

            jLabel3.setForeground(new java.awt.Color(255, 255, 255));
            jLabel3.setText("Nivel:");

            cbNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            cbNivel.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cbNivelActionPerformed(evt);
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
            jLabel5.setText("Inscripcion:");

            jLabel6.setForeground(new java.awt.Color(255, 255, 255));
            jLabel6.setText("Mensualidad:");

            jLabel7.setForeground(new java.awt.Color(255, 255, 255));
            jLabel7.setText("Ciclo:");

            lblCiclo.setForeground(new java.awt.Color(255, 255, 255));
            lblCiclo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblCiclo.setText("jLabel8");
            lblCiclo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

            txtCodigoAlumno.setEnabled(false);

            txtAlumno.setEnabled(false);

            jLabel8.setForeground(new java.awt.Color(255, 255, 255));
            jLabel8.setText("Seccion:");

            cbSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            cbSeccion.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cbSeccionActionPerformed(evt);
                }
            });

            btnBuscar.setText("...");
            btnBuscar.setToolTipText("Presiona para Buscar un Alumno");
            btnBuscar.setEnabled(false);
            btnBuscar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnBuscarActionPerformed(evt);
                }
            });

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        txtMensualidad.setEnabled(false);

        txtInscripcion.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tblAsignacion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel5))
                                    .addComponent(cbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(txtInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMensualidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(cbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCiclo, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel7)
                        .addComponent(txtCodigoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtMensualidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        Nuevo = true;
        activarCampos();
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        tblAsignacion.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(cbGrado.getSelectedIndex() != -1 && !txtInscripcion.getText().replace("Q", "").replace(".", "").trim().equals("") && 
                !txtMensualidad.getText().replace("Q", "").replace(".", "").trim().equals("")){
            if(!txtCodigoAlumno.getText().equals("")){
                CicloDAO ciclo = new CicloDAO();
                if(Modificando == true || coordinador.buscarAsignacion(ciclo.buscarCiclo(lblCiclo.getText()).getIdCiclo(), txtCodigoAlumno.getText()) == null){
                    AsignacionAlumno asignacion = new AsignacionAlumno();
                    ItemComboBox item;
                    boolean resultado = false;
                    item = (ItemComboBox) cbGrado.getSelectedItem();

                    asignacion.setPersona(txtCodigoAlumno.getText());
                    asignacion.setIdAsignacion(Correlativo);
                    asignacion.setGrado(Integer.parseInt(item.getID()));
                    asignacion.setCiclo(coordinador.obtenerCiclo(lblCiclo.getText()).getIdCiclo());
                    asignacion.setEstado(true);
                    if(Fecha == null){
                        java.util.Date FechaActual = new java.util.Date();
                        Fecha = new Date(FechaActual.getTime());
                        asignacion.setFechaAsignacion(Fecha);
                    }else{
                        asignacion.setFechaAsignacion(Fecha);
                    }
                    asignacion.setInscripcion(BigDecimal.valueOf(Double.parseDouble( txtInscripcion.getText().replace("Q", ""))));
                    asignacion.setMensualidad(BigDecimal.valueOf(Double.parseDouble(txtMensualidad.getText().replace("Q", ""))));
                    if(Nuevo == true){
                        resultado = coordinador.registrarAsignacionAlumno(asignacion);
                    }else if(Modificando == true){
                        resultado = coordinador.modificarAsignacionAlumno(asignacion);
                    }

                    if(resultado == true){
                        btnGuardar.setEnabled(false);
                        btnCancelar.setEnabled(false);
                        btnNuevo.setEnabled(true);
                        btnModificar.setEnabled(false);
                        Modificando = false;
                        Nuevo = false;
                        Fecha = null;
                        limpiarCampos();
                        desactivarCampos();                        
                        JOptionPane.showMessageDialog(null, "Asignaciona guardada exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Este alumno ya ha sido asignado a un grado", "Student Control", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Debe Seleccionar un Alumno para guardar la asignacion", "Student Control", JOptionPane.ERROR_MESSAGE);
            }
        }else if(cbGrado.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un grado para guardar la asignacion", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(txtInscripcion.getText().replace("Q", "").replace(".", "").trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe especificar el precio de la inscripcion", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(txtMensualidad.getText().replace("Q", "").replace(".", "").trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe especificar el precio de la mensualidad", "Student Control", JOptionPane.ERROR_MESSAGE);
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
        tblAsignacion.setEnabled(false);
        Modificando = true;
        Nuevo = false;
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desactivarCampos();
        limpiarCampos();
        DefaultTableModel modelo = (DefaultTableModel) tblAsignacionAlumno.getModel();
        modelo.setRowCount(0);
        tblAsignacionAlumno.setModel(modelo);
        int row = tblAsignacionAlumno.getRowCount();
        for(int i = 0; i < tblAsignacionAlumno.getRowCount(); i++){
            tblAsignacionAlumno.remove(i);
        }
        cbJornada.setEnabled(true);
        cbSeccion.setEnabled(true);
        cbNivel.setEnabled(true);
        cbGrado.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        tblAsignacion.setEnabled(true);
        Modificando = false;
        Nuevo = false;
        Correlativo = 0;
        Fecha = null;
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
                tblAsignacion.setEnabled(true);
                Modificando = false;
                Nuevo = false;
                Correlativo = 0;
                Fecha = null;
                this.hide();
            }
        }else{
            desactivarCampos();
            limpiarCampos();
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnNuevo.setEnabled(true);
            btnModificar.setEnabled(false);
            tblAsignacion.setEnabled(true);
            Modificando = false;
            Nuevo = false;
            Correlativo = 0;
            Fecha = null;
            this.hide();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGradoActionPerformed
        if(cbGrado.getSelectedIndex() != -1){
            ItemComboBox item;
            item = (ItemComboBox) cbGrado.getSelectedItem();        
            tblAsignacionAlumno.setModel(coordinador.tblAsignacionAlumno(Integer.parseInt(item.getID())));
        }
    }//GEN-LAST:event_cbGradoActionPerformed

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
            coordinador.AsignacionAlumnoComboGrado(Jornada, Seccion, Nivel);
        }
    }//GEN-LAST:event_cbNivelActionPerformed

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
            coordinador.AsignacionAlumnoComboGrado(Jornada, Seccion, Nivel);
        }
    }//GEN-LAST:event_cbJornadaActionPerformed

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
            coordinador.AsignacionAlumnoComboGrado(Jornada, Seccion, Nivel);
        }
    }//GEN-LAST:event_cbSeccionActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        coordinador.dialoAlumno.setVisible(true);
        if(!coordinador.dialoAlumno.Alumno.equals("")){
            Persona alumno = coordinador.buscarPersona(coordinador.dialoAlumno.Alumno);
            this.txtCodigoAlumno.setText(alumno.getIdPersona());
            this.txtAlumno.setText(alumno.getPNombre() + " " + alumno.getSNombre() + " " + alumno.getPApellido() + " " + alumno.getSApelido());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblAsignacionAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAsignacionAlumnoMouseClicked
        int row = tblAsignacionAlumno.getSelectedRow();
        if(row > -1){
            Correlativo = Integer.parseInt(tblAsignacionAlumno.getValueAt(row, 0).toString());
            txtCodigoAlumno.setText(tblAsignacionAlumno.getValueAt(row, 1).toString());
            Persona alumno = coordinador.buscarPersona(tblAsignacionAlumno.getValueAt(row, 1).toString());
            txtAlumno.setText(alumno.getPNombre() + " " + alumno.getSNombre() + " " + alumno.getPApellido());
            txtMensualidad.setText(tblAsignacionAlumno.getValueAt(row, 5).toString().replace("Q", ""));
            txtInscripcion.setText(tblAsignacionAlumno.getValueAt(row, 4).toString().replace("Q", ""));
            String FechaTabla = tblAsignacionAlumno.getValueAt(row, 3).toString();
            java.util.Date fechaControl = new java.util.Date(FechaTabla);
            Fecha = new Date(fechaControl.getTime());
            cbJornada.setEnabled(false);
            cbSeccion.setEnabled(false);
            cbNivel.setEnabled(false);
            cbGrado.setEnabled(false);
            
            if("1".equals(permisos[1])){
                btnModificar.setEnabled(true);
            }else{
                btnModificar.setEnabled(false);
            }            
            btnCancelar.setEnabled(true);
            btnNuevo.setEnabled(false);
            btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_tblAsignacionAlumnoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lblCiclo;
    private javax.swing.JScrollPane tblAsignacion;
    public javax.swing.JTable tblAsignacionAlumno;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtCodigoAlumno;
    private javax.swing.JFormattedTextField txtInscripcion;
    private javax.swing.JFormattedTextField txtMensualidad;
    // End of variables declaration//GEN-END:variables
}
