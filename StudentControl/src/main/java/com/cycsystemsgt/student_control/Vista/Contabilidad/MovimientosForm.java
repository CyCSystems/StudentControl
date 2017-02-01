/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Vista.Contabilidad;

import com.cycsystemsgt.student_control.Controlador.Coordinador;
import com.cycsystemsgt.student_control.Modelo.Entidades.Movimiento;
import com.cycsystemsgt.student_control.util.ItemComboBox;
import java.awt.HeadlessException;
import static javax.management.Query.gt;
import static javax.management.Query.lt;
import javax.management.Query.*;
import static javax.management.Query.gt;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author angel
 */
public class MovimientosForm extends javax.swing.JInternalFrame {

    private final Coordinador coordinador;
    public TableRowSorter<TableModel> sorter;
    private boolean nuevo = false, modificar = false;
    private String[] permisos;
    /**
     * Creates new form MovimientosForm
     * @param coordinador
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public MovimientosForm(Coordinador coordinador) {
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Fondo3.jpg"));
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        initComponents();
        this.coordinador = coordinador;
        txtFiltro.getDocument().addDocumentListener(
            new DocumentListener(){

                @Override
                public void insertUpdate(DocumentEvent e) {
                    Busqueda();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    Busqueda();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    Busqueda();
                }
                    
            }
        );
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
    
    public void habilitarCampos(){
        dcFecha.setEnabled(true);
        txtCantidad.setEnabled(true);
        cbTipoMovimiento.setEnabled(true);
        cbProducto.setEnabled(true);
        cbSede.setEnabled(true);
        txtValor.setEnabled(true);
        txtCosto.setEnabled(true);
        cbProveedor.setEnabled(true);
    }
    
    public void deshabilitarCampos(){
        dcFecha.setEnabled(false);
        txtCantidad.setEnabled(false);
        cbTipoMovimiento.setEnabled(false);
        cbProducto.setEnabled(false);
        cbSede.setEnabled(false);
        txtValor.setEnabled(false);
        txtCosto.setEnabled(false);
        cbProveedor.setEnabled(false);
    }
    
    public void limpiarCampos(){
        dcFecha.setDate(null);
        txtCantidad.setText("");
        cbTipoMovimiento.setSelectedIndex(-1);
        cbProducto.setSelectedIndex(-1);
        cbSede.setSelectedIndex(-1);
        txtValor.setText("");
        txtCosto.setText("");
        cbProveedor.setSelectedIndex(-1);
    }
    
    private void Busqueda(){
        RowFilter<TableModel, Object> rf = null;
        int Indice1 = -1;
        switch(cbFiltro.getSelectedIndex()){
            case 0:
                Indice1=0;
                break;
            case 1:
                Indice1=2;
                break;
            case 2:
                Indice1=3;
                break;
            case 3:
                Indice1=4;
                break;
            case 4:
                Indice1=5;
                break;
        }
        try{
            rf = RowFilter.regexFilter(txtFiltro.getText(), Indice1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en Filtro: "+e.getMessage());
        }
        sorter.setRowFilter(rf);
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
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbTipoMovimiento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbProducto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbSede = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbProveedor = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbFiltro = new javax.swing.JComboBox<>();
        txtFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFiltro = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setTitle("Movimientos de productos");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo:");

        txtCodigo.setEnabled(false);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha:");

        dcFecha.setEnabled(false);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad:");

        txtCantidad.setEnabled(false);
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo de Movimiento:");

        cbTipoMovimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTipoMovimiento.setEnabled(false);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Producto:");

        cbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProducto.setEnabled(false);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sede:");

        cbSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSede.setEnabled(false);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Valor por Unidad:");

        txtValor.setEnabled(false);
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Costo por Unidad:");

        txtCosto.setEnabled(false);
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Proveedor:");

        cbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProveedor.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbTipoMovimiento, 0, 188, Short.MAX_VALUE))
                                    .addComponent(cbSede, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(cbTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setOpaque(false);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Buscar por:");

        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Tipo de Movimiento", "Producto", "Sede", "Proveedor" }));
        cbFiltro.setSelectedIndex(-1);

        tblFiltro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha", "Tipo de Movimiento", "Producto", "Sede", "Proveedor"
            }
        ));
        tblFiltro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFiltroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFiltro);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setOpaque(false);

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

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
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
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnCancelar)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if("1".equals(permisos[1])){
            btnGuardar.setEnabled(true);
        }else{
            btnGuardar.setEnabled(false);
        }
        btnModificar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnCancelar.setEnabled(true);
        nuevo = true;
        modificar = false;
        habilitarCampos();
        limpiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try{
            if(dcFecha.getDate() != null && !txtCantidad.getText().trim().equals("") && cbTipoMovimiento.getSelectedIndex() > -1 &&
                    cbProducto.getSelectedIndex() > -1 && cbSede.getSelectedIndex() > -1 && !txtValor.getText().trim().equals("") &&
                    !txtCosto.getText().trim().equals("") && cbProveedor.getSelectedIndex() > -1 && txtValor.getText().matches("^\\$?(([1-9][0-9]{0,2}(,[0-9]{3})*)|[0-9]+)?\\.[0-9]{1,2}$") &&
                    txtCosto.getText().matches("^\\$?(([1-9][0-9]{0,2}(,[0-9]{3})*)|[0-9]+)?\\.[0-9]{1,2}$")){
                Movimiento movimiento = new Movimiento();
                ItemComboBox item;
                boolean respuesta = false;


                movimiento.setFecha(new java.sql.Date(dcFecha.getDate().getTime()));
                movimiento.setCantidad(Double.parseDouble(txtCantidad.getText()));
                item = (ItemComboBox) cbTipoMovimiento.getSelectedItem();
                movimiento.setTipoMovimiento(Integer.parseInt(item.getID()));
                item = (ItemComboBox) cbProducto.getSelectedItem();
                movimiento.setProducto(Integer.parseInt(item.getID()));
                item = (ItemComboBox) cbSede.getSelectedItem();
                movimiento.setSede(Integer.parseInt(item.getID()));
                movimiento.setValorUnidad(Double.parseDouble(txtValor.getText().replace(",", "")));
                movimiento.setCostoUnidad(Double.parseDouble(txtCosto.getText().replace(",", "")));
                item = (ItemComboBox) cbProveedor.getSelectedItem();
                movimiento.setProveedor(Integer.parseInt(item.getID()));

                if(nuevo == true){
                    movimiento.setIdMovimiento(0);
                    respuesta = coordinador.registrarMovimiento(movimiento);
                }else if(modificar == true){
                    movimiento.setIdMovimiento(Integer.parseInt(txtCodigo.getText()));
                    //respuesta = coordinador.modificarMovimiento(movimiento);
                }
                if(respuesta == true){
                    limpiarCampos();
                    deshabilitarCampos();
                    if("1".equals(permisos[1])){
                        btnNuevo.setEnabled(true);
                    }else{
                        btnNuevo.setEnabled(false);
                    }
                    btnModificar.setEnabled(false);
                    btnGuardar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    nuevo = false;
                    modificar = false;
                    coordinador.cargarMovimientos();
                    JOptionPane.showMessageDialog(null, "Movimiento guardado exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
                }

            }else if(dcFecha.getDate() == null){
                JOptionPane.showMessageDialog(null, "Debe especificar la fecha del movimiento", "Student Control", JOptionPane.ERROR_MESSAGE);
                dcFecha.requestFocus();
            }else if(txtCantidad.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Debe especificar la cantidad del producto", "Student Control", JOptionPane.ERROR_MESSAGE);
                txtCantidad.requestFocus();
            }else if(cbTipoMovimiento.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Debe especificar el tipo de movimiento", "Student Control", JOptionPane.ERROR_MESSAGE);
                cbTipoMovimiento.requestFocus();
            }else if(cbProducto.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Debe especificar el producto", "Student Control", JOptionPane.ERROR_MESSAGE);
                cbProducto.requestFocus();
            }else if(cbSede.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Debe especificar la sede", "Student Control", JOptionPane.ERROR_MESSAGE);
                cbSede.requestFocus();
            }else if(txtValor.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Debe especificar el valor de venta", "Student Control", JOptionPane.ERROR_MESSAGE);
                txtValor.requestFocus();
            }else if(txtCosto.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Debe especificar el costo de compra", "Student Control", JOptionPane.ERROR_MESSAGE);
                txtCosto.requestFocus();
            }else if(cbProveedor.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Debe especificar el proveedor", "Student Control", JOptionPane.ERROR_MESSAGE);
                cbProveedor.requestFocus();
            }else if(!txtValor.getText().matches("^\\$?(([1-9][0-9]{0,2}(,[0-9]{3})*)|[0-9]+)?\\.[0-9]{1,2}$")){
                JOptionPane.showMessageDialog(null, "Debe especificar una cantidad valida para el valor del producto", "Student Control", JOptionPane.ERROR_MESSAGE);
                txtValor.requestFocus();
            }else if(!txtCosto.getText().matches("^\\$?(([1-9][0-9]{0,2}(,[0-9]{3})*)|[0-9]+)?\\.[0-9]{1,2}$")){
                JOptionPane.showMessageDialog(null, "Debe especificar una cantidad valida para el costo del producto", "Student Control", JOptionPane.ERROR_MESSAGE);
                txtCosto.requestFocus();
            }
        }catch(NumberFormatException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if("1".equals(permisos[1])){
            btnGuardar.setEnabled(true);
        }else{
            btnGuardar.setEnabled(false);
        }
        btnModificar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnCancelar.setEnabled(true);
        nuevo = false;
        modificar = true;
        habilitarCampos();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if("1".equals(permisos[1])){
            btnNuevo.setEnabled(true);
        }else{
            btnNuevo.setEnabled(false);
        }
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        nuevo = false;
        modificar = false;
        deshabilitarCampos();
        limpiarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if(nuevo == true || modificar == true){
            int x = JOptionPane.showConfirmDialog(null, "Aun hay cambios pendientes, desea salir?", "Student Control", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(x == JOptionPane.OK_OPTION){
                btnCancelarActionPerformed(null);
                this.hide();
            }
        }else{
            this.hide();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char car = evt.getKeyChar();
        if(!Character.isDigit(car)){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        char car = evt.getKeyChar();
        if(Character.isLetter(car)){
            evt.consume();
        }
    }//GEN-LAST:event_txtValorKeyTyped

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        char car = evt.getKeyChar();
        if(Character.isLetter(car)){
            evt.consume();
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void tblFiltroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFiltroMouseClicked
        if(this.tblFiltro.getSelectedRow() > -1){
            int codigo = Integer.parseInt(tblFiltro.getValueAt(tblFiltro.getSelectedRow(), 0).toString());
            Movimiento movimiento = coordinador.obtenerMovimiento(codigo);
            ItemComboBox item;
            
            txtCodigo.setText("" + movimiento.getIdMovimiento());
            dcFecha.setDate(movimiento.getFecha());
            txtCantidad.setText("" + movimiento.getCantidad());
            Coordinador.setSelectedValue(cbTipoMovimiento, movimiento.getTipoMovimiento());
            Coordinador.setSelectedValue(cbProducto, movimiento.getProducto());
            Coordinador.setSelectedValue(cbSede, movimiento.getSede());
            Coordinador.setSelectedValue(cbProveedor, movimiento.getProveedor());
            txtValor.setText("" + movimiento.getValorUnidad());
            txtCosto.setText("" + movimiento.getCostoUnidad());
            if("1".equals(permisos[2]) && "1".equals(permisos[3])){
                btnModificar.setEnabled(true);
            }else{
                btnModificar.setEnabled(false);
            }
            btnNuevo.setEnabled(false);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(true);
        }
    }//GEN-LAST:event_tblFiltroMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbFiltro;
    public javax.swing.JComboBox<String> cbProducto;
    public javax.swing.JComboBox<String> cbProveedor;
    public javax.swing.JComboBox<String> cbSede;
    public javax.swing.JComboBox<String> cbTipoMovimiento;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblFiltro;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}