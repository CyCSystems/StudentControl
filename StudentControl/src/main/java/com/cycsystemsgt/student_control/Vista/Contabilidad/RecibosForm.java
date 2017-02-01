/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Vista.Contabilidad;

import com.cycsystemsgt.student_control.Controlador.Coordinador;
import com.cycsystemsgt.student_control.Modelo.DataSources.DSRecibo;
import com.cycsystemsgt.student_control.Modelo.Entidades.Detalle;
import com.cycsystemsgt.student_control.Modelo.Entidades.DetallePagoRecibo;
import com.cycsystemsgt.student_control.Modelo.Entidades.Persona;
import com.cycsystemsgt.student_control.Modelo.Entidades.Producto;
import com.cycsystemsgt.student_control.Modelo.Entidades.Recibo;
import com.cycsystemsgt.student_control.util.ItemComboBox;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author angel
 */
public class RecibosForm extends javax.swing.JInternalFrame {

    private final Coordinador coordinador;
    private String[] permisos;
    private String codigoCliente;
    private String codigoProducto;
    private boolean modificar = false;
    private boolean nuevo = false;
    private boolean aplicoDescuentoUnitario;
    private final String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto"," ;Septiembre"
            ,"Octubre","Noviembre","Diciemrbre"};
    private boolean esInscripcion = false;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public RecibosForm(Coordinador coordinador) {
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
        limpiarCampos();
        deshabilitarCampos();
        lblRecibo.setText(coordinador.obtenerCorrelativoRecibo());
    }
    
    private void deshabilitarCampos(){
        cbNivel.setEnabled(false);
        cbJornada.setEnabled(false);
        cbSeccion.setEnabled(false);
        cbGrado.setEnabled(false);
        cbAlumno.setEnabled(false);
        cbTipoRecibo.setEnabled(false);
        chkDescuento.setEnabled(false);
        btnBuscarCliente.setEnabled(false);
        btnBuscarProducto.setEnabled(false);
        txtValorUnitario.setEnabled(false);
        txtCantidad.setEnabled(false);
        tblDetalle.setEnabled(false);
        cbFormaPago.setEnabled(false);
        txtDocumento.setEnabled(false);
        txtObservaciones.setEnabled(false);
        btnAgregar.setEnabled(false);
        rbTotal.setEnabled(false);
        rbParcial.setEnabled(false);
        cbDescuento.setEnabled(false);
        txtDescuento.setEnabled(false);
    }
    
    private void habilitarCampos(){
        cbTipoRecibo.setEnabled(true);
        chkDescuento.setEnabled(true);
        btnBuscarCliente.setEnabled(true);
        btnBuscarProducto.setEnabled(true);
        txtCantidad.setEnabled(true);
        tblDetalle.setEnabled(true);
        cbFormaPago.setEnabled(true);
        txtDocumento.setEnabled(true);
        txtObservaciones.setEnabled(true);
        btnAgregar.setEnabled(true);
    }
    
    private void limpiarCampos(){
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        cbTipoRecibo.setSelectedIndex(-1);
        chkDescuento.setSelected(false);
        cbNivel.setSelectedIndex(-1);
        cbJornada.setSelectedIndex(-1);
        cbSeccion.setSelectedIndex(-1);
        cbGrado.setSelectedIndex(-1);
        cbAlumno.setSelectedIndex(-1);
        txtCantidad.setText("");
        cbFormaPago.setSelectedIndex(-1);
        txtDocumento.setText("");
        txtObservaciones.setText("");
        txtCliente.setText("");
        lblTotal.setText("0.00");
        lblFecha.setText(formato.format(new Date()));
        txtProducto.setText("");
        lblCuota.setText("");
        cbDescuento.setSelectedIndex(-1);
        txtDescuento.setText("");
        chkDescuento.setSelected(false);
        txtValorUnitario.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();
        modelo.setRowCount(0);
        tblDetalle.setModel(modelo);
        rbTotal.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblRecibo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblCuota = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbTipoRecibo = new javax.swing.JComboBox<>();
        cbJornada = new javax.swing.JComboBox<>();
        cbNivel = new javax.swing.JComboBox<>();
        cbGrado = new javax.swing.JComboBox<>();
        cbSeccion = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbAlumno = new javax.swing.JComboBox<>();
        chkDescuento = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        cbDescuento = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cbFormaPago = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        rbParcial = new javax.swing.JRadioButton();
        rbTotal = new javax.swing.JRadioButton();

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No.");

        lblRecibo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblRecibo.setForeground(new java.awt.Color(255, 0, 0));
        lblRecibo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecibo.setText("0001");
        lblRecibo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Cliente:");

        txtCliente.setEnabled(false);

        btnBuscarCliente.setText("...");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        lblFecha.setForeground(java.awt.Color.white);
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("01/10/2016");
        lblFecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("Fecha:");

        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("Producto:");

        txtProducto.setEnabled(false);

        btnBuscarProducto.setText("...");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar-editar-icono-6607-96.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setText("La Colina del Exito");

        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("11 Av. \"C\" 1-18 lo de Fuentes Zona 11 de Mixco");

        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Tel. 2484-0641 / 5931-8941");

        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Cantidad", "Valor", "Descuento", "SubTotal"
            }
        ));
        jScrollPane1.setViewportView(tblDetalle);

        jLabel20.setForeground(java.awt.Color.white);
        jLabel20.setText("Valor:");

        txtValorUnitario.setEnabled(false);

        jLabel21.setForeground(java.awt.Color.white);
        jLabel21.setText("% Descuento:");

        txtDescuento.setEnabled(false);
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad:");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cuota No.");

        lblCuota.setForeground(new java.awt.Color(255, 255, 255));
        lblCuota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCuota.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel21))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(txtDescuento)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(337, 337, 337)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(lblRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFecha)
                            .addComponent(jLabel11))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblRecibo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(lblCuota))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente)
                    .addComponent(jLabel21)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto)
                    .addComponent(jLabel20)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo de Recibo:");

        cbTipoRecibo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mensualidad", "Venta" }));
        cbTipoRecibo.setSelectedIndex(-1);
        cbTipoRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoReciboActionPerformed(evt);
            }
        });

        cbJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJornadaActionPerformed(evt);
            }
        });

        cbNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNivelActionPerformed(evt);
            }
        });

        cbGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGradoActionPerformed(evt);
            }
        });

        cbSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeccionActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Seccion:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jornada:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nivel:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Grado:");

        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Alumno:");

        cbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlumnoActionPerformed(evt);
            }
        });

        chkDescuento.setForeground(java.awt.Color.white);
        chkDescuento.setText("Aplica Descuento?");
        chkDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDescuentoActionPerformed(evt);
            }
        });

        jLabel22.setForeground(java.awt.Color.white);
        jLabel22.setText("Descuento por:");

        cbDescuento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Total", "Producto" }));
        cbDescuento.setSelectedIndex(-1);
        cbDescuento.setEnabled(false);
        cbDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDescuentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbTipoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(chkDescuento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDescuento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbAlumno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbTipoRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkDescuento)
                    .addComponent(jLabel22)
                    .addComponent(cbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setOpaque(false);

        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setText("Forma de pago:");

        cbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFormaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFormaPagoActionPerformed(evt);
            }
        });

        jLabel17.setForeground(java.awt.Color.white);
        jLabel17.setText("No. Documento:");

        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });

        jLabel18.setForeground(java.awt.Color.white);
        jLabel18.setText("Total:   Q.");

        lblTotal.setForeground(java.awt.Color.white);
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("3000.00");

        jLabel23.setForeground(java.awt.Color.white);
        jLabel23.setText("Observaciones:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtObservaciones))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(lblTotal)
                    .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap())
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setOpaque(false);

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
        btnNuevo.setEnabled(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbParcial);
        rbParcial.setForeground(new java.awt.Color(255, 255, 255));
        rbParcial.setText("Pago parcial");
        rbParcial.setEnabled(false);
        rbParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbParcialActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTotal);
        rbTotal.setForeground(new java.awt.Color(255, 255, 255));
        rbTotal.setSelected(true);
        rbTotal.setText("Pago total");
        rbTotal.setEnabled(false);
        rbTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbParcial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo)
                    .addComponent(rbParcial)
                    .addComponent(rbTotal))
                .addContainerGap())
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
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            coordinador.recibosComboGrado(Jornada, Seccion, Nivel);
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
            coordinador.recibosComboGrado(Jornada, Seccion, Nivel);
        }
    }//GEN-LAST:event_cbNivelActionPerformed

    private void cbGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGradoActionPerformed
        if(cbGrado.getSelectedIndex() > -1){
            ItemComboBox item = (ItemComboBox) cbGrado.getSelectedItem();
            coordinador.recibosComboAlumnos(Integer.parseInt(item.getID()));
        }
    }//GEN-LAST:event_cbGradoActionPerformed

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
            coordinador.recibosComboGrado(Jornada, Seccion, Nivel);
        }
    }//GEN-LAST:event_cbSeccionActionPerformed

    private void chkDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDescuentoActionPerformed
        if(chkDescuento.isSelected() == true){
            cbDescuento.setEnabled(true);
            txtDescuento.setEnabled(true);
        }else{
            cbDescuento.setSelectedIndex(-1);
            cbDescuento.setEnabled(false);
            txtDescuento.setEnabled(false);
        }
    }//GEN-LAST:event_chkDescuentoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        coordinador.dialogCliente.setVisible(true);
        if(coordinador.dialogCliente.Cliente > 0){
            Persona cliente = coordinador.buscarPersona(coordinador.dialogCliente.Cliente.toString());
            codigoCliente = coordinador.dialogCliente.Cliente.toString();
            txtCliente.setText(cliente.getPNombre() + " " + cliente.getPApellido());
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        coordinador.dialogProducto.setVisible(true);
        if(coordinador.dialogProducto.codigo > 0){
            Producto producto = coordinador.obtenerProducto(coordinador.dialogProducto.codigo);
            codigoProducto = producto.getIdProducto().toString();
            txtProducto.setText(producto.getDescripcion());
            txtValorUnitario.setText(String.valueOf(coordinador.obtenerPrecioActual(producto.getIdProducto()).getValorUnidad()));
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        lblRecibo.setText(coordinador.obtenerCorrelativoRecibo());
        limpiarCampos();
        deshabilitarCampos();
        nuevo = false;
        modificar = false;
        codigoCliente = "";
        codigoProducto = "";
        esInscripcion = false;
        if("1".equals(permisos[1])){
            btnNuevo.setEnabled(true);
        }else{
            btnNuevo.setEnabled(false);
        }
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        lblRecibo.setText(coordinador.obtenerCorrelativoRecibo());
        limpiarCampos();
        cbTipoRecibo.setEnabled(true);
        nuevo = true;
        modificar = false;
        codigoCliente = "";
        codigoProducto = "";
        esInscripcion = false;
        rbParcial.setEnabled(true);
        rbTotal.setEnabled(true);
        if("1".equals(permisos[1])){
            btnGuardar.setEnabled(true);
        }else{
            btnGuardar.setEnabled(false);
        }
        btnNuevo.setEnabled(false);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    
        DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();
        Recibo recibo = null;
        Detalle detalle = null;
        List<Detalle> detalles = new ArrayList<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        boolean respuesta = false;
        ItemComboBox item = (ItemComboBox) cbAlumno.getSelectedItem();
        DetallePagoRecibo detallePago;
        //List<ReporteRecibo> rptRecibo;
        DSRecibo rptRecibo; 
        
        try{
            if(!codigoCliente.equals("") && modelo.getRowCount() > 0 && cbFormaPago.getSelectedIndex() > -1 && cbAlumno.getSelectedIndex() > -1){
                recibo = new Recibo();
                recibo.setIdRecibo(Integer.parseInt(lblRecibo.getText()));
                recibo.setFechaVenta(timestamp);
                if(cbDescuento.getSelectedIndex() == 0){
                    recibo.setDescuento(Double.parseDouble(txtDescuento.getText()));
                }else{
                    recibo.setDescuento(0.0);
                }                    
                recibo.setTotal(Double.parseDouble(lblTotal.getText().replace(",", "")));
                recibo.setEstado(true);
                recibo.setCliente(Integer.parseInt(codigoCliente));
                recibo.setEmpleado(Integer.parseInt(coordinador.Datos.getIdPersona()));
                if(lblCuota.getText().trim().equals("")){
                    recibo.setCoutas(0);
                }else{
                    recibo.setCoutas(Integer.parseInt(lblCuota.getText()));
                }
                if(cbAlumno.getSelectedIndex() > -1){
                    recibo.setAlumno(item.getID());
                }
                
                for(int i = 0; i < modelo.getRowCount(); i++){
                    detalle = new Detalle();
                    detalle.setIdDetalle(0);
                    detalle.setRecibo(recibo.getIdRecibo());
                    detalle.setCantidad(Integer.parseInt(modelo.getValueAt(i, 2).toString()));
                    if(cbDescuento.getSelectedIndex() == 1){
                        detalle.setDescuento(Double.parseDouble(modelo.getValueAt(i, 4).toString()));
                    }else{
                        detalle.setDescuento(0.0);
                    }
                    detalle.setSubTotal(Double.parseDouble(modelo.getValueAt(i, 3).toString().replace(",", "")) * Double.parseDouble(modelo.getValueAt(i, 2).toString()));
                    if(esInscripcion == false && cbTipoRecibo.getSelectedIndex() == 0){
                        detalle.setMes(Integer.parseInt(modelo.getValueAt(i, 0).toString()));
                    }else{
                        detalle.setProducto(Integer.parseInt(modelo.getValueAt(i, 0).toString()));
                    }
                    detalles.add(detalle);
                }
                
                item = (ItemComboBox) cbFormaPago.getSelectedItem();
                detallePago = new DetallePagoRecibo();
                detallePago.setFormaPago(Integer.parseInt(item.getID()));
                if(!item.toString().equals("EFECTIVO") && !txtDocumento.getText().trim().equals("")){
                    detallePago.setNumeroDocumento(txtDocumento.getText());
                }else if(!item.toString().equals("EFECTIVO") && txtDocumento.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Debe especificar un numero de documento", "Student Control", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                respuesta = coordinador.registrarRecibo(recibo, detalles, detallePago);
                if(respuesta = true){
                    JOptionPane.showMessageDialog(null, "Recibo guardado exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
                    btnCancelarActionPerformed(null);
                    rptRecibo = new DSRecibo(coordinador, detalles, recibo);
                    
                    /*
                    rptRecibo = new ArrayList<>();
                    
                    for (Detalle detalle1 : detalles) {
                        ReporteRecibo rpt = new ReporteRecibo();
                        rpt.setIdRecibo(detalle1.getRecibo().toString());
                        rpt.setCliente(coordinador.buscarPersona(recibo.getCliente().toString()).getPNombre() + " " + coordinador.buscarPersona(recibo.getCliente().toString()).getPApellido());
                        rpt.setFechaVenta(recibo.getFechaVenta().toString());
                        rpt.setTotal(recibo.getTotal().toString());
                        rpt.setCantidad(detalle1.getCantidad().toString());
                        rpt.setSubTotal(detalle1.getSubTotal().toString());
                        rpt.setProducto(coordinador.obtenerProducto(detalle1.getProducto()).getDescripcion());
                        rpt.setDireccion(coordinador.buscarPersona(recibo.getCliente().toString()).getDireccion());
                        rpt.setUsuario(coordinador.buscarPersona(recibo.getEmpleado().toString()).getPNombre() + " " + coordinador.buscarPersona(recibo.getEmpleado().toString()).getPNombre());
                        rptRecibo.add(rpt);
                    }*/
                    
                    File ruta = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\cycsystemsgt\\student_control\\Vista\\Reportes\\Recibo.jasper");
                    JasperReport jrReporte = (JasperReport) JRLoader.loadObject(ruta);
                    JasperPrint jrPrint = JasperFillManager.fillReport(jrReporte, null, rptRecibo);
                    JasperViewer viewer = new JasperViewer(jrPrint, false);
                    viewer.setTitle("Impresion de Recibos");
                    viewer.setVisible(true);
                    
                }
            }else if(cbAlumno.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Debe especificar un alumno", "Student Control", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(codigoCliente.equals("")){
                JOptionPane.showMessageDialog(null, "Debe especificar un cliente", "Student Control", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(modelo.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Debe agregar por lo menos un producto", "Student Control", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(cbFormaPago.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Debe especificar la forma de pago", "Student Control", JOptionPane.ERROR_MESSAGE);
                return;
            }
            lblRecibo.setText(coordinador.obtenerCorrelativoRecibo());
        }catch(NumberFormatException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        } catch (JRException ex) {
            Logger.getLogger(RecibosForm.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbTipoReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoReciboActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();
        switch(cbTipoRecibo.getSelectedIndex()){
            case 0:
                cbNivel.setEnabled(true);
                cbJornada.setEnabled(true);
                cbSeccion.setEnabled(true);
                cbGrado.setEnabled(true);
                cbAlumno.setEnabled(true);
                habilitarCampos();
                chkDescuento.setEnabled(false);
                btnBuscarProducto.setEnabled(false);
                txtCantidad.setEnabled(false);
                btnAgregar.setEnabled(false);
                rbTotal.setEnabled(true);
                rbParcial.setEnabled(true);
                modelo.setColumnIdentifiers(new Object[]{"Codigo", "Producto", "Cantidad", "Valor", "Mora", "SubTotal"});
                break;
            case 1:
                cbNivel.setEnabled(true);
                cbJornada.setEnabled(true);
                cbSeccion.setEnabled(true);
                cbGrado.setEnabled(true);
                cbAlumno.setEnabled(true);
                habilitarCampos();
                rbTotal.setEnabled(false);
                rbParcial.setEnabled(false);
                modelo.setColumnIdentifiers(new Object[]{"Codigo", "Producto", "Cantidad", "Valor", "Descuento", "SubTotal"});
                break;
        }
    }//GEN-LAST:event_cbTipoReciboActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        double subTotal = 0.0, total = 0.0;
        Producto producto;
        DefaultTableModel modelo = null;
        Double descuento = 0.0;
        DecimalFormat formato = new DecimalFormat("#.00");
        try{
            if(cbTipoRecibo.getSelectedIndex() == 1){
                if(chkDescuento.isSelected() == true){
                    if(cbDescuento.getSelectedIndex() == -1) {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar la opcion donde se aplicara el descuento", "Student Control", JOptionPane.ERROR_MESSAGE);
                        cbDescuento.requestFocus();
                        return;
                    }else if(txtDescuento.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Debe ingresar el porcentaje de descuento", "Student Control", JOptionPane.ERROR_MESSAGE);
                        txtDescuento.requestFocus();
                        return;
                    }                    
                }
                if(!codigoCliente.equals("") && !codigoProducto.equals("") && !txtCantidad.getText().trim().equals("")){
                    producto = coordinador.obtenerProducto(Integer.parseInt(codigoProducto));
                    if(producto.getExistencias() > 0){
                        if(Double.parseDouble(txtCantidad.getText()) <= producto.getExistencias() && Double.parseDouble(txtCantidad.getText()) > 0){
                            modelo = (DefaultTableModel) tblDetalle.getModel();
                            switch(cbDescuento.getSelectedIndex()){
                                case 0:
                                    if(aplicoDescuentoUnitario == true){
                                        JOptionPane.showMessageDialog(null, "Usted ya aplico un descuento por producto, no es posible aplicar descuento por el total?", "Student Control", JOptionPane.WARNING_MESSAGE);
                                        return;
                                    }

                                    descuento = 0.0;
                                    subTotal = Double.parseDouble(txtValorUnitario.getText().trim()) * Double.parseDouble(txtCantidad.getText().trim());
                                    for(int i = 0; i < modelo.getRowCount(); i++){
                                        total = total + Double.parseDouble(modelo.getValueAt(i, 5).toString());
                                    }
                                    total = total + subTotal - ((Double.parseDouble(txtDescuento.getText().trim()) / 100) * (total + subTotal));
                                    break;
                                case 1:
                                    total = Double.parseDouble(lblTotal.getText().replace(",", ""));
                                    descuento = Double.parseDouble(txtDescuento.getText().trim().equals("") ? "0.0" : txtDescuento.getText().trim());
                                    subTotal = Double.parseDouble(txtValorUnitario.getText().trim()) * Double.parseDouble(txtCantidad.getText().trim()) - ((Double.parseDouble(txtDescuento.getText()) / 100) * (Double.parseDouble(txtValorUnitario.getText().trim()) * Double.parseDouble(txtCantidad.getText().trim())));
                                    total = total + subTotal;
                                    break;
                                default:
                                    total = Double.parseDouble(lblTotal.getText());
                                    descuento = 0.0;
                                    subTotal = Double.parseDouble(txtValorUnitario.getText().trim()) * Double.parseDouble(txtCantidad.getText().trim());
                                    total = total + subTotal;
                                    break;
                            }
                            lblTotal.setText("");
                            lblTotal.setText(formato.format(total));
                            Object[] fila = {codigoProducto, txtProducto.getText(), txtCantidad.getText().trim(),
                                                txtValorUnitario.getText().trim(), descuento, subTotal};
                            modelo.addRow(fila);
                            tblDetalle.setModel(modelo);
                            if(cbDescuento.getSelectedIndex() == 0){
                                chkDescuento.setEnabled(false);
                                cbDescuento.setEnabled(false);
                                txtDescuento.setEnabled(false);
                            }
                            txtProducto.setText("");
                            txtValorUnitario.setText("");
                            txtCantidad.setText("");
                            codigoProducto = "";
                            btnBuscarCliente.setEnabled(false);
                        }else if(Double.parseDouble(txtCantidad.getText()) > producto.getExistencias()){
                            JOptionPane.showMessageDialog(null, "La cantidad del producto seleccionado no debe superar la cantidad de existencias", "Student Control", JOptionPane.ERROR_MESSAGE);
                        }else if(Double.parseDouble(txtCantidad.getText()) == 0){
                            JOptionPane.showMessageDialog(null, "La cantidad del producto seleccionado debe ser mayor a cero", "Student Control", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "El producto seleccionado no cuenta con existencias", "Student Control", JOptionPane.ERROR_MESSAGE);
                    }
                }else if(codigoCliente.equals("")){
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente", "Student Control", JOptionPane.ERROR_MESSAGE);
                    btnBuscarCliente.requestFocus();
                }else if(codigoProducto.equals("")){
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "Student Control", JOptionPane.ERROR_MESSAGE);
                    btnBuscarProducto.requestFocus();
                }else if(txtCantidad.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad deseada", "Student Control", JOptionPane.ERROR_MESSAGE);
                    txtCantidad.requestFocus();
                }
            }
        }catch(NumberFormatException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cbDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDescuentoActionPerformed
        if(cbDescuento.getSelectedIndex() == 1) aplicoDescuentoUnitario = true;
    }//GEN-LAST:event_cbDescuentoActionPerformed

    private void cbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlumnoActionPerformed
        if(this.cbTipoRecibo.getSelectedIndex() == 0 && cbAlumno.getSelectedIndex() > -1){
            ItemComboBox item = (ItemComboBox) cbAlumno.getSelectedItem();
            ArrayList<String> datosMensualidad = coordinador.obtenerMes(item.getID());
            Persona alumno = coordinador.buscarPersona(item.getID());
            Persona encargado = coordinador.buscarPersona(alumno.getEncargado());
            DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();            
            
            txtCliente.setText(encargado.getPNombre() + " " + encargado.getPApellido());
            codigoCliente = encargado.getIdPersona();
            modelo.setRowCount(0);
            
            switch (datosMensualidad.get(0)){
                case "SOLVENTE":
                    JOptionPane.showMessageDialog(null, "El alumno seleccionado se encuentra solvente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "0":
                    codigoProducto = "1";
                    esInscripcion = true;
                    Object[] inscripcion = {1, "Inscripcion", 1, datosMensualidad.get(1), datosMensualidad.get(2), Double.parseDouble(datosMensualidad.get(1))};
                    lblTotal.setText(datosMensualidad.get(1));
                    lblCuota.setText(datosMensualidad.get(3));
                    modelo.addRow(inscripcion);
                    break;
                default:
                    codigoProducto = datosMensualidad.get(0);
                    Object[] mensualidad = {datosMensualidad.get(0), meses[Integer.parseInt(datosMensualidad.get(0)) - 1], 1, datosMensualidad.get(1), datosMensualidad.get(2), Double.parseDouble(datosMensualidad.get(1)) + Double.parseDouble(datosMensualidad.get(2))};
                    lblTotal.setText(String.valueOf(Double.parseDouble(datosMensualidad.get(1)) + Double.parseDouble(datosMensualidad.get(2))));
                    lblCuota.setText(datosMensualidad.get(3));
                    modelo.addRow(mensualidad);
                    break;
            }
        }
    }//GEN-LAST:event_cbAlumnoActionPerformed

    private void rbTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTotalActionPerformed
        cbAlumnoActionPerformed(null);
    }//GEN-LAST:event_rbTotalActionPerformed

    private void rbParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbParcialActionPerformed
        if(cbTipoRecibo.getSelectedIndex() == 0){
            Double nuevoValor = 0.0, viejoValor = 0.0;
            DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();
            if(modelo.getRowCount() > 0){
                try{
                    nuevoValor = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor parcial, tenga en cuenta que este no debe incluir mora", "Student Control", JOptionPane.QUESTION_MESSAGE));
                    viejoValor = Double.parseDouble(modelo.getValueAt(0, 5).toString());

                    if(nuevoValor > 0 && nuevoValor < viejoValor){
                        modelo.setValueAt(nuevoValor, 0, 3);
                        modelo.setValueAt("0", 0, 4);
                        modelo.setValueAt(nuevoValor, 0, 5);
                        lblTotal.setText("" + nuevoValor);
                    }else if(nuevoValor == 0){
                        JOptionPane.showMessageDialog(null, "El valor parcial debe ser mayor a cero", "Student Control", JOptionPane.ERROR_MESSAGE);
                        rbTotal.setSelected(true);
                    }else if(nuevoValor > viejoValor){
                        JOptionPane.showMessageDialog(null, "El valor parcial debe ser menor al precio total", "Student Control", JOptionPane.ERROR_MESSAGE);
                        rbTotal.setSelected(true);
                    }
                }catch(NumberFormatException | HeadlessException e){
                    JOptionPane.showMessageDialog(null, "El valor ingresado debe ser un numero, no debe ingresar ningun otro caracter", "Student Control", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                    rbTotal.setSelected(true);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar al alumno para cargar el mes a pagar", "Student Control", JOptionPane.ERROR_MESSAGE);
            }
        }       
    }//GEN-LAST:event_rbParcialActionPerformed

    private void cbFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFormaPagoActionPerformed
        if(cbFormaPago.getSelectedIndex() > -1){
            ItemComboBox item = (ItemComboBox) cbFormaPago.getSelectedItem();
            if(item.toString().equals("EFECTIVO")){
                txtDocumento.setEnabled(false);
            }else{
                txtDocumento.setEnabled(true);
            }
        }
    }//GEN-LAST:event_cbFormaPagoActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtDocumentoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> cbAlumno;
    private javax.swing.JComboBox<String> cbDescuento;
    public javax.swing.JComboBox<String> cbFormaPago;
    public javax.swing.JComboBox<String> cbGrado;
    public javax.swing.JComboBox<String> cbJornada;
    public javax.swing.JComboBox<String> cbNivel;
    public javax.swing.JComboBox<String> cbSeccion;
    private javax.swing.JComboBox<String> cbTipoRecibo;
    private javax.swing.JCheckBox chkDescuento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCuota;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblRecibo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton rbParcial;
    private javax.swing.JRadioButton rbTotal;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
