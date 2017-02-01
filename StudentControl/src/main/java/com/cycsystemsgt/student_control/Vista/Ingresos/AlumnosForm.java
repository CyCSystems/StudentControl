/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.Vista.Ingresos;

import com.cycsystemsgt.student_control.Modelo.Entidades.Documento;
import com.cycsystemsgt.student_control.Modelo.Entidades.Papeleria;
import com.cycsystemsgt.student_control.Modelo.Entidades.Telefono;
import com.cycsystemsgt.student_control.util.ItemComboBox;
import com.cycsystemsgt.student_control.Controlador.Coordinador;
import com.cycsystemsgt.student_control.Modelo.Entidades.Persona;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author angel
 */
public class AlumnosForm extends javax.swing.JInternalFrame {

    private Coordinador coordinador;
    private Boolean ModificoPapeleria = false;
    private Boolean ModificoAlumno = false;
    private Boolean CreandoAlumno = false;
    private String IdEncargado = "";
    private Boolean ModificandoPapeleria = false;
    private ArrayList<Integer> CreoPapeleria = new ArrayList<>();
    private ArrayList<Integer> PapeleriaEliminada = new ArrayList<>();
    public TableRowSorter<TableModel> sorter;
    private String[] permisos;
       
    
    public AlumnosForm(Coordinador coordinador) {
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(getClass().getResource("/Fondo3.jpg"));
        JLabel fondo= new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        initComponents();
        txtBusqueda.getDocument().addDocumentListener(
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
    
    private void Busqueda(){
        RowFilter<TableModel, Object> rf = null;
        int Indice1 = -1;
        switch(cbBusqueda.getSelectedIndex()){
            case 0:
                Indice1=0;
                break;
            case 1:
                Indice1=1;
                break;
        }
        try{
            rf = RowFilter.regexFilter(txtBusqueda.getText(), Indice1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en Filtro: "+e.getMessage());
        }
        sorter.setRowFilter(rf);
    }
    
    public void habilitarCampos(){
        this.txtCodigo.setEnabled(true);
        this.checkSinCodigo.setEnabled(true);
        this.txtPNombre.setEnabled(true);
        this.txtSNombre.setEnabled(true);
        this.txtTNombre.setEnabled(true);
        this.txtPApellido.setEnabled(true);
        this.txtSApellido.setEnabled(true);
        this.cbEstado.setEnabled(true);
        this.cbGenero.setEnabled(true);
        this.dcFechaIngreso.setEnabled(true);
        this.dcFechaNacimiento.setEnabled(true);
        this.txtEPNombre.setEnabled(true);
        this.txtESNombre.setEnabled(true);
        this.txtEPApellido.setEnabled(true);
        this.txtESApellido.setEnabled(true);
        this.txtEncargadoDireccion.setEnabled(true);
        this.cbEncargadoGenero.setEnabled(true);
        this.cbEncargadoIdentificacion.setEnabled(true);
        this.txtEncargadoIdentificacion.setEnabled(true);
        this.txtEncargadoDireccion.setEnabled(true);
        this.txtTelefono.setEnabled(true);
        this.cbTipoPapeleria.setEnabled(true);
        this.txtPapeleria.setEnabled(true);
        this.cbEstadoEncargado.setEnabled(true);
        this.cbTipoEncargado.setEnabled(true);
        this.btnAniadirPapeleria.setEnabled(true);
        this.btnGuardar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
    }
    
    public void limpiarCampos(){
        this.txtCodigo.setText("");
        this.checkSinCodigo.setSelected(false);
        this.txtPNombre.setText("");
        this.txtSNombre.setText("");
        this.txtTNombre.setText("");
        this.txtPApellido.setText("");
        this.txtSApellido.setText("");
        this.cbEstado.setSelectedIndex(-1);
        this.cbGenero.setSelectedIndex(-1);
        this.dcFechaIngreso.setDate(null);
        this.dcFechaNacimiento.setDate(null);
        this.txtEPNombre.setText("");
        this.txtESNombre.setText("");
        this.txtEPApellido.setText("");
        this.txtESApellido.setText("");
        this.txtEncargadoDireccion.setText("");
        this.cbEncargadoGenero.setSelectedIndex(-1);
        this.cbEncargadoIdentificacion.setSelectedIndex(-1);
        this.txtEncargadoIdentificacion.setText("");
        this.txtTelefono.setText("");
        this.cbTipoPapeleria.setSelectedIndex(-1);
        this.txtPapeleria.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tblPapeleria.getModel();
        modelo.setRowCount(0);
        tblPapeleria.setModel(modelo);
    }
    
    public void deshabilitarCampos(){
        this.txtCodigo.setEnabled(false);
        this.checkSinCodigo.setEnabled(false);
        this.txtPNombre.setEnabled(false);
        this.txtSNombre.setEnabled(false);
        this.txtTNombre.setEnabled(false);
        this.txtPApellido.setEnabled(false);
        this.txtSApellido.setEnabled(false);
        this.cbEstado.setEnabled(false);
        this.cbGenero.setEnabled(false);
        this.dcFechaIngreso.setEnabled(false);
        this.dcFechaNacimiento.setEnabled(false);
        this.txtEPNombre.setEnabled(false);
        this.txtESNombre.setEnabled(false);
        this.txtEPApellido.setEnabled(false);
        this.txtESApellido.setEnabled(false);
        this.txtEncargadoDireccion.setEnabled(false);
        this.cbEncargadoGenero.setEnabled(false);
        this.cbEncargadoIdentificacion.setEnabled(false);
        this.txtEncargadoIdentificacion.setEnabled(false);
        this.txtEncargadoDireccion.setEnabled(false);
        this.txtEncargadoDireccion.setEnabled(false);
        this.txtTelefono.setEnabled(false);
        this.cbTipoPapeleria.setEnabled(false);
        this.txtPapeleria.setEnabled(false);
        this.cbTipoEncargado.setEnabled(false);
        this.cbEstadoEncargado.setEnabled(false);
        this.btnAniadirPapeleria.setEnabled(false);
        this.btnAniadirPapeleria.setEnabled(false);
        this.btnGuardar.setEnabled(false);
        this.btnCancelar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        miEliminarPapeleria = new javax.swing.JMenuItem();
        miModificarPapeleria = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        checkSinCodigo = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPNombre = new javax.swing.JTextField();
        txtSNombre = new javax.swing.JTextField();
        txtTNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPApellido = new javax.swing.JTextField();
        txtSApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        dcFechaIngreso = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtEPNombre = new javax.swing.JTextField();
        txtESNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEPApellido = new javax.swing.JTextField();
        txtESApellido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEncargadoDireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbEncargadoGenero = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbEncargadoIdentificacion = new javax.swing.JComboBox<>();
        txtEncargadoIdentificacion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbEstadoEncargado = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbTipoEncargado = new javax.swing.JComboBox<>();
        btnEncargado = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPapeleria = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        cbTipoPapeleria = new javax.swing.JComboBox<>();
        txtPapeleria = new javax.swing.JTextField();
        btnAniadirPapeleria = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cbBusqueda = new javax.swing.JComboBox<>();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAlumno = new javax.swing.JTable();
        lblFoto = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        miEliminarPapeleria.setText("Eliminar Papeleria");
        miEliminarPapeleria.setComponentPopupMenu(jPopupMenu2);
        miEliminarPapeleria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEliminarPapeleriaActionPerformed(evt);
            }
        });
        jPopupMenu2.add(miEliminarPapeleria);

        miModificarPapeleria.setText("Modificar Papeleria");
        miModificarPapeleria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miModificarPapeleriaActionPerformed(evt);
            }
        });
        jPopupMenu2.add(miModificarPapeleria);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo:");

        txtCodigo.setEnabled(false);
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        checkSinCodigo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        checkSinCodigo.setForeground(new java.awt.Color(255, 255, 255));
        checkSinCodigo.setText("No posee codigo ministerial");
        checkSinCodigo.setEnabled(false);
        checkSinCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSinCodigoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Estado:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baja", "Activo" }));
        cbEstado.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");

        txtPNombre.setEnabled(false);
        txtPNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPNombreKeyTyped(evt);
            }
        });

        txtSNombre.setEnabled(false);
        txtSNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSNombreKeyTyped(evt);
            }
        });

        txtTNombre.setEnabled(false);
        txtTNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTNombreKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido:");

        txtPApellido.setEnabled(false);
        txtPApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPApellidoKeyTyped(evt);
            }
        });

        txtSApellido.setEnabled(false);
        txtSApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSApellidoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Genero:");

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbGenero.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha de Nacimiento:");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha de Ingreso:");

        dcFechaNacimiento.setEnabled(false);

        dcFechaIngreso.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkSinCodigo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dcFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkSinCodigo)
                            .addComponent(jLabel2)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtPApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dcFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos del Alumno", jPanel1);

        jPanel2.setOpaque(false);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre del encargado:");

        txtEPNombre.setEnabled(false);
        txtEPNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEPNombreKeyTyped(evt);
            }
        });

        txtESNombre.setEnabled(false);
        txtESNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtESNombreKeyTyped(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Apellidos:");

        txtEPApellido.setEnabled(false);
        txtEPApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEPApellidoKeyTyped(evt);
            }
        });

        txtESApellido.setEnabled(false);
        txtESApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtESApellidoKeyTyped(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Direccion:");

        txtEncargadoDireccion.setEnabled(false);
        txtEncargadoDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEncargadoDireccionKeyTyped(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Genero:");

        cbEncargadoGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEncargadoGenero.setEnabled(false);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Documento de Identificacion:");

        cbEncargadoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEncargadoIdentificacion.setEnabled(false);

        txtEncargadoIdentificacion.setEnabled(false);
        txtEncargadoIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEncargadoIdentificacionKeyTyped(evt);
            }
        });

        txtTelefono.setEnabled(false);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Telefono:");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Estado:");

        cbEstadoEncargado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baja", "Activo" }));
        cbEstadoEncargado.setEnabled(false);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tipo Encargado");

        cbTipoEncargado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTipoEncargado.setEnabled(false);

        btnEncargado.setText("jButton1");
        btnEncargado.setEnabled(false);
        btnEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncargadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtESNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEPApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtESApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEncargadoDireccion)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEncargadoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbEstadoEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbTipoEncargado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(4, 4, 4)
                                        .addComponent(cbEncargadoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEncargadoIdentificacion)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtESNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtEPApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtESApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEncargado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEncargadoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbEncargadoGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cbEncargadoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEncargadoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(cbEstadoEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cbTipoEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos del Encargado", jPanel2);

        jPanel3.setOpaque(false);

        jScrollPane1.setToolTipText("Si desea Eliminar un registro solo debe seleccionar el registro y presionar click derecho");
        jScrollPane1.setComponentPopupMenu(jPopupMenu2);

        tblPapeleria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPapeleria.setComponentPopupMenu(jPopupMenu2);
        tblPapeleria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblPapeleria.setEnabled(false);
        jScrollPane1.setViewportView(tblPapeleria);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Documento:");

        cbTipoPapeleria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTipoPapeleria.setEnabled(false);

        txtPapeleria.setEnabled(false);
        txtPapeleria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPapeleriaKeyTyped(evt);
            }
        });

        btnAniadirPapeleria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar-editar-icono-6607-96.png"))); // NOI18N
        btnAniadirPapeleria.setText("Añadir");
        btnAniadirPapeleria.setEnabled(false);
        btnAniadirPapeleria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirPapeleriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipoPapeleria, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPapeleria, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAniadirPapeleria)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbTipoPapeleria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPapeleria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAniadirPapeleria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Papeleria", jPanel3);

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setOpaque(false);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Buscar por:");

        cbBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre" }));
        cbBusqueda.setSelectedIndex(-1);

        tblAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlumnoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblAlumno);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
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
                .addComponent(btnModificar)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitarCampos();
        limpiarCampos();
        btnModificar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEncargado.setEnabled(true);
        CreandoAlumno = true;
        tblPapeleria.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        deshabilitarCampos();
        limpiarCampos();
        PapeleriaEliminada.clear();
        ModificoPapeleria = false;
        ModificoAlumno = false;
        CreandoAlumno = false;
        ModificandoPapeleria = false;
        btnModificar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEncargado.setEnabled(false);
        tblAlumno.setEnabled(true);
        tblPapeleria.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if(ModificoAlumno == true || ModificoPapeleria == true || CreandoAlumno == true || ModificandoPapeleria == true || CreoPapeleria.size() > 0){
            if(JOptionPane.showConfirmDialog(null, "Aun hay cambios pendientes por guardar, desea salir?", "Student Control", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
                this.hide();
            }
        }else{
            this.hide();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(!this.txtPNombre.getText().trim().equals("") && !this.txtSNombre.getText().trim().equals("") &&
                this.cbGenero.getSelectedIndex() > -1 && this.dcFechaNacimiento.getDate() != null && this.dcFechaIngreso.getDate() != null &&
                !this.txtEPNombre.getText().trim().equals("") && !this.txtESNombre.getText().trim().equals("") &&
                !this.txtEPApellido.getText().trim().equals("") && !this.txtESApellido.getText().trim().equals("") &&
                !this.txtEncargadoDireccion.getText().trim().equals("") && this.cbEncargadoGenero.getSelectedIndex() > -1 &&
                this.cbEncargadoIdentificacion.getSelectedIndex() > -1 && !this.txtEncargadoIdentificacion.getText().trim().equals("") &&
                !this.txtTelefono.getText().trim().equals("") && this.cbTipoEncargado.getSelectedIndex() > -1){
            if(ModificandoPapeleria == false){
                ItemComboBox item;
                DefaultTableModel modelo = (DefaultTableModel) tblPapeleria.getModel();
                ArrayList<Boolean> Resultados = new ArrayList<>();
                ArrayList<String> IdEncargado = new ArrayList<>();


                //Crear Encargado
                Persona Encargado = new Persona();
                if(ModificoAlumno == true){
                    IdEncargado = coordinador.buscarAlumno(txtCodigo.getText());
                    Encargado.setIdPersona(IdEncargado.get(10));
                }else{
                    if(this.IdEncargado != ""){
                        Encargado.setIdPersona(this.IdEncargado);
                    }else{
                        Encargado.setIdPersona(coordinador.generarCodigo().toString());
                    }
                }


                Encargado.setPNombre(txtEPNombre.getText());
                Encargado.setSNombre(txtESNombre.getText());
                Encargado.setPApellido(txtEPApellido.getText());
                Encargado.setSApelido(txtESApellido.getText());
                Encargado.setEstado(cbEstadoEncargado.getSelectedIndex() == 1);
                Encargado.setDireccion(txtEncargadoDireccion.getText());
                item = (ItemComboBox) cbEncargadoGenero.getSelectedItem();
                Encargado.setGenero(Integer.parseInt(item.getID()));
                item = (ItemComboBox) cbTipoEncargado.getSelectedItem();
                Encargado.setRol(coordinador.getIdRol(Integer.parseInt(item.getID())));
                Encargado.setUsuario(coordinador.getCredenciales(txtEPNombre.getText(), txtEPApellido.getText()).get(0));
                Encargado.setPass(coordinador.getCredenciales(txtEPNombre.getText(), txtEPApellido.getText()).get(1));
                Encargado.setPagaExtras(false);

                Telefono telefono = new Telefono();
                telefono.setTelefono(this.txtTelefono.getText());
                telefono.setPersona(Encargado.getIdPersona());

                Documento documento = new Documento();
                documento.setNumero(this.txtEncargadoIdentificacion.getText());
                item = (ItemComboBox) cbEncargadoIdentificacion.getSelectedItem();
                documento.setTipoDocumento(coordinador.getCodigo(Integer.parseInt(item.getID())));
                documento.setPersona(Encargado.getIdPersona());                

                //Crear Alumno
                Persona Alumno = new Persona();
                if(checkSinCodigo.isSelected() == false){
                    if(txtCodigo.getText().trim().matches("^[A-Z]{1}\\d{3}[A-Z]{3}$") || (txtCodigo.getText().trim().matches("^\\d{1,4}$") && ModificoAlumno == true)){
                        Alumno.setIdPersona(txtCodigo.getText());
                    }else{
                        JOptionPane.showMessageDialog(null, "El codigo de alumno ingresado no es valido, favor verificar", "Student Control", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }else{
                    Alumno.setIdPersona(String.valueOf(coordinador.generarCodigo() + 1));
                }    
                Alumno.setPNombre(txtPNombre.getText());
                Alumno.setSNombre(txtSNombre.getText());
                Alumno.setTNombre(txtTNombre.getText());
                Alumno.setPApellido(txtPApellido.getText());
                Alumno.setSApelido(txtSApellido.getText());
                Alumno.setEstado(cbEstado.getSelectedIndex() == 1);
                item = (ItemComboBox) cbGenero.getSelectedItem();
                Alumno.setGenero(coordinador.getCodigo(item.getID()));
                Alumno.setFechaNacimiento((Date) dcFechaNacimiento.getDate());
                Alumno.setFechaIngreso((Date) dcFechaIngreso.getDate());
                Alumno.setRol(4);
                Alumno.setUsuario(coordinador.getCredenciales(txtPNombre.getText(), txtPApellido.getText()).get(0));
                Alumno.setPass(coordinador.getCredenciales(txtPNombre.getText(), txtPApellido.getText()).get(1));
                Alumno.setPagaExtras(false);
                Alumno.setEncargado(Encargado.getIdPersona());

                //Papeleria
                ArrayList<Papeleria> listaPapeleria = new ArrayList<>();
                for(int i = 0; i < tblPapeleria.getRowCount(); i++){
                    Papeleria mPapeleria = new Papeleria();
                    mPapeleria.setIdPapeleria(modelo.getValueAt(i, 0).equals("") ? 0: Integer.parseInt(modelo.getValueAt(i, 0).toString()));
                    mPapeleria.setIdTipoPapeleria(coordinador.getCodigo(modelo.getValueAt(i, 1)));
                    mPapeleria.setDescripcion(modelo.getValueAt(i, 2).toString());
                    mPapeleria.setPersona(Alumno.getIdPersona());
                    listaPapeleria.add(mPapeleria);
                }

                //Modificacion de registro
                if(ModificoAlumno == true){
                    //Guardar Datos del Alumno y Encargado
                    Resultados.add(coordinador.GuardarAlumno(2, Encargado, Alumno, telefono, documento));
                    CreandoAlumno = false;

                    //Registrar Papeleria ingresada
                    if(ModificoPapeleria == true){
                        if(listaPapeleria.size() > 0){
                            for(int i = 0; i < listaPapeleria.size(); i++){
                                Papeleria mPapeleria = new Papeleria();
                                mPapeleria = listaPapeleria.get(i);
                                Resultados.add(coordinador.guardarPapeleria(2, mPapeleria, 0));
                                ModificoPapeleria = false;
                            }
                        }                    
                    }
                    for(int i = 0; i < CreoPapeleria.size(); i++){
                        Papeleria mPapeleria = new Papeleria();
                        mPapeleria = listaPapeleria.get(CreoPapeleria.get(i));
                        Resultados.add(coordinador.guardarPapeleria(1, mPapeleria, 0));
                    }
                    CreoPapeleria.clear();

                    //Eliminar Papeleria
                    if(PapeleriaEliminada.size() > 0){
                        for(int i = 0; i < PapeleriaEliminada.size(); i++){
                            Resultados.add(coordinador.guardarPapeleria(3, null, PapeleriaEliminada.get(i)));
                        }
                        PapeleriaEliminada.clear();
                    }
                    ModificoAlumno = false;
                //Creacion de registro
                }else{

                    if(this.checkSinCodigo.isSelected() == false && txtCodigo.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Error: Debe ingresar el codigo del alumno o \nSeleccionar el la opcion \"Sin Codigo Ministerial\" ", "Student Control", JOptionPane.ERROR_MESSAGE);
                    }else{
                        //Guardar Datos del Alumno y Encargado
                        Resultados.add(coordinador.GuardarAlumno(1, Encargado, Alumno, telefono, documento));
                        CreandoAlumno = false;

                        //Registrar Papeleria ingresada
                        if(listaPapeleria.size() > 0){
                            for(int i = 0; i < listaPapeleria.size(); i++){
                                Papeleria mPapeleria = new Papeleria();
                                mPapeleria = listaPapeleria.get(i);
                                Resultados.add(coordinador.guardarPapeleria(1, mPapeleria, 0));
                                ModificoPapeleria = false;
                            }
                        }
                    }
                }
                if(Resultados.contains(false)){
                    JOptionPane.showMessageDialog(null, "Error guardando datos del alumno favor revisar", "Student Control", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Alumno Guardado Exitosamente", "Student Control", JOptionPane.INFORMATION_MESSAGE);
                    deshabilitarCampos();
                    limpiarCampos();
                    coordinador.cargartblAlumnos();
                    this.IdEncargado = "";
                    coordinador.cargartblAlumnos();
                    btnModificar.setEnabled(false);
                    btnNuevo.setEnabled(true);
                    btnGuardar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnEncargado.setEnabled(false);
                    tblAlumno.setEnabled(true);
                    tblPapeleria.setEnabled(false);
                    CreoPapeleria.clear();
                                        
                    for (String[] Permiso : coordinador.Permisos) {
                        if ("Asignacion de Alumnos".equals(Permiso[0])) {
                            int x = JOptionPane.showConfirmDialog(null,"¿Desea asignar grado al alumno?", "Student Control", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if(x == JOptionPane.OK_OPTION){
                                coordinador.showAsignacionAlumnos(new Persona(Alumno.getIdPersona(), Alumno.getPNombre(), Alumno.getPApellido()));
                                this.hide();
                            }
                        }
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error: Aun hay papeleria pendiente de agregar", "Student Control", JOptionPane.ERROR_MESSAGE);
            }
        }else if(this.txtPNombre.getText().trim().equals("")){
           JOptionPane.showMessageDialog(null, "Debe Ingresar el primer nombre del alumno", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtSNombre.getText().trim().equals("")){
           JOptionPane.showMessageDialog(null, "Debe Ingresar el segundo nombre del alumno", "Student Control", JOptionPane.ERROR_MESSAGE); 
        }else if(this.cbGenero.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe Seleccionar el genero del alumno", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.dcFechaNacimiento.getDate() == null){
            JOptionPane.showMessageDialog(null, "Debe Ingresar la fecha de nacimiento del alumno", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.dcFechaIngreso.getDate() == null){
            JOptionPane.showMessageDialog(null, "Debe Ingresar la fecha de ingreso del alumno", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtEPNombre.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Ingresar el primer nombre del Encargado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtESNombre.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Ingresar el segundo nombre del encargado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtEPApellido.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Ingresar el primer apellido del encargado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtESApellido.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Ingresar la segundo apellido del encargado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtEncargadoDireccion.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Ingresar la direccion del encargado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.cbEncargadoGenero.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe Ingresar el genero del encargado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.cbEncargadoIdentificacion.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe Ingresar el tipo de identificacion del encargado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtEncargadoIdentificacion.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Ingresar el numero de identificacion del encargado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtTelefono.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Ingresar el telefono del encargado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else if(this.cbTipoEncargado.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe Ingresar el tipo de encargado", "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAniadirPapeleriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirPapeleriaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblPapeleria.getModel();
        ItemComboBox item = (ItemComboBox) cbTipoPapeleria.getSelectedItem();
        Object[] fila = {"", item.getID() + "|" + item.toString(), txtPapeleria.getText()};
        modelo.addRow(fila);
        tblPapeleria.setModel(modelo);
        txtPapeleria.setText("");
        if(ModificandoPapeleria == false){
            ModificoPapeleria = false;
            CreoPapeleria.add(modelo.getRowCount() - 1);
        }else{
            ModificoPapeleria = true;
        }
        ModificandoPapeleria = false;
    }//GEN-LAST:event_btnAniadirPapeleriaActionPerformed

    private void miEliminarPapeleriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEliminarPapeleriaActionPerformed
        if(btnGuardar.isEnabled() == true){
            DefaultTableModel modelo = (DefaultTableModel) tblPapeleria.getModel();
            int fila = tblPapeleria.getSelectedRow();
            if(fila != -1){
                PapeleriaEliminada.add(Integer.parseInt(modelo.getValueAt(fila, 0).toString()));
                modelo.removeRow(fila);
                tblPapeleria.setModel(modelo);
                JOptionPane.showMessageDialog(null, "Registro eliminado con exito", "Student Control", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if(tblPapeleria.getRowCount() > 0){
                    JOptionPane.showMessageDialog(null, "Error: Debe Seleccionar un registro para eliminarlo", "Student Control", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Error: ya no existen registros para eliminar", "Student Control", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else if(btnModificar.isEnabled()){
            JOptionPane.showMessageDialog(null, "Error: debe presionar el boton modificar para editar la papeleria del alumno", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Error: debe presionar el boton Nuevo para editar la papeleria del alumno", "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_miEliminarPapeleriaActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtPNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPNombreKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }        
        if(!Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtPNombreKeyTyped

    private void txtSNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSNombreKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        if(!Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtSNombreKeyTyped

    private void txtTNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTNombreKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        if(!Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtTNombreKeyTyped

    private void txtPApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPApellidoKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        if(!Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtPApellidoKeyTyped

    private void txtSApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSApellidoKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        if(!Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtSApellidoKeyTyped

    private void txtEPNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEPNombreKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        if(!Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtEPNombreKeyTyped

    private void txtESNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtESNombreKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        if(!Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtESNombreKeyTyped

    private void txtEPApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEPApellidoKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        if(!Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtEPApellidoKeyTyped

    private void txtESApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtESApellidoKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        if(!Character.isLetter(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtESApellidoKeyTyped

    private void txtEncargadoDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEncargadoDireccionKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtEncargadoDireccionKeyTyped

    private void txtPapeleriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPapeleriaKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad = (""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtPapeleriaKeyTyped

    private void txtEncargadoIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEncargadoIdentificacionKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            Toolkit tk = Toolkit.getDefaultToolkit();
            tk.beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtEncargadoIdentificacionKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            Toolkit tk = Toolkit.getDefaultToolkit();
            tk.beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void tblAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnoMouseClicked
        ArrayList<String> Alumno = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        DefaultTableModel modelo = (DefaultTableModel) tblPapeleria.getModel();
        modelo.setRowCount(0);
        int row = tblAlumno.getSelectedRow();
        if(btnGuardar.isEnabled() != true){
            try {
                Alumno = coordinador.buscarAlumno(tblAlumno.getValueAt(row, 0).toString());
                txtCodigo.setText(Alumno.get(0));
                txtPNombre.setText(Alumno.get(1));
                txtSNombre.setText(Alumno.get(2));

                txtTNombre.setText(Alumno.get(3));
                txtPApellido.setText(Alumno.get(4));
                txtSApellido.setText(Alumno.get(5));
                Date fecha = formato.parse(Alumno.get(6));
                dcFechaNacimiento.setDate(fecha);
                Coordinador.setSelectedValue(cbGenero, Alumno.get(7));
                dcFechaIngreso.setDate(formato.parse(Alumno.get(8)));
                cbEstado.setSelectedIndex(Integer.parseInt(Alumno.get(9)));
                txtEPNombre.setText(Alumno.get(11));
                txtESNombre.setText(Alumno.get(12));
                txtEPApellido.setText(Alumno.get(13));
                txtESApellido.setText(Alumno.get(14));
                txtEncargadoDireccion.setText(Alumno.get(15));
                Coordinador.setSelectedValue(cbEncargadoGenero, Alumno.get(16));
                cbEstadoEncargado.setSelectedItem(Integer.parseInt(Alumno.get(17)));
                Coordinador.setSelectedValue(cbTipoEncargado, Alumno.get(18));

                Coordinador.setSelectedValue(cbEncargadoIdentificacion, coordinador.buscarDocumento(Alumno.get(10)).get(0));
                txtEncargadoIdentificacion.setText(coordinador.buscarDocumento(Alumno.get(10)).get(1));

                txtTelefono.setText(coordinador.buscarTelefono(Alumno.get(10)));

                tblPapeleria.setModel(coordinador.buscarPapeleria(Alumno.get(0)));              
                
                if("1".equals(permisos[2]) && "2".equals(permisos[3])){
                    btnModificar.setEnabled(true);
                }else{
                    btnModificar.setEnabled(false);
                }
                btnNuevo.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnCancelar.setEnabled(true);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_tblAlumnoMouseClicked

    private void checkSinCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSinCodigoActionPerformed
        if(checkSinCodigo.isSelected() == true){
            txtCodigo.setEnabled(false);
        }else{
            txtCodigo.setEnabled(true);
        }
    }//GEN-LAST:event_checkSinCodigoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        ModificoAlumno = true;
        habilitarCampos();
        btnModificar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEncargado.setEnabled(false);
        tblAlumno.setEnabled(false);
        tblPapeleria.setEnabled(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncargadoActionPerformed
        coordinador.dialogEncargado.setVisible(true);

        if(!coordinador.dialogEncargado.Encargado.equals("")){
            Persona persona = coordinador.buscarPersona(coordinador.dialogEncargado.Encargado);
            IdEncargado = persona.getIdPersona();
            txtEPNombre.setText(persona.getPNombre());
            txtESNombre.setText(persona.getSNombre());
            txtEPApellido.setText(persona.getPApellido());
            txtESApellido.setText(persona.getSApelido());
            txtEncargadoDireccion.setText(persona.getDireccion());
            Coordinador.setSelectedValue(cbEncargadoGenero, persona.getGenero());
            Coordinador.setSelectedValue(cbEncargadoIdentificacion, coordinador.buscarDocumento(persona.getIdPersona()).get(0));
            txtEncargadoIdentificacion.setText(coordinador.buscarDocumento(persona.getIdPersona()).get(1));
            txtTelefono.setText(coordinador.buscarTelefono(persona.getIdPersona()));
            this.cbEstadoEncargado.setSelectedIndex(persona.getEstado() == false ? 0 : 1);
            Coordinador.setSelectedValue(cbTipoEncargado, persona.getTipoPersona());
        }
    }//GEN-LAST:event_btnEncargadoActionPerformed

    private void miModificarPapeleriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miModificarPapeleriaActionPerformed
        if(btnGuardar.isEnabled() == true){
            DefaultTableModel modelo = (DefaultTableModel) tblPapeleria.getModel();
            int row = tblPapeleria.getSelectedRow();
            try{
                if(btnGuardar.isEnabled() == true){
                    Coordinador.setSelectedValue(cbTipoPapeleria, coordinador.getNombre(modelo.getValueAt(row, 1)));
                    txtPapeleria.setText(modelo.getValueAt(row, 2).toString());
                    tblPapeleria.remove(row);
                    ModificandoPapeleria = true;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
            }
        }else if(btnModificar.isEnabled()){
            JOptionPane.showMessageDialog(null, "Error: debe presionar el boton modificar para editar la papeleria del alumno", "Student Control", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Error: debe presionar el boton Nuevo para editar la papeleria del alumno", "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_miModificarPapeleriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadirPapeleria;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEncargado;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbBusqueda;
    public javax.swing.JComboBox<String> cbEncargadoGenero;
    public javax.swing.JComboBox<String> cbEncargadoIdentificacion;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbEstadoEncargado;
    public javax.swing.JComboBox<String> cbGenero;
    public javax.swing.JComboBox<String> cbTipoEncargado;
    public javax.swing.JComboBox<String> cbTipoPapeleria;
    private javax.swing.JCheckBox checkSinCodigo;
    private com.toedter.calendar.JDateChooser dcFechaIngreso;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JMenuItem miEliminarPapeleria;
    private javax.swing.JMenuItem miModificarPapeleria;
    public javax.swing.JTable tblAlumno;
    public javax.swing.JTable tblPapeleria;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEPApellido;
    private javax.swing.JTextField txtEPNombre;
    private javax.swing.JTextField txtESApellido;
    private javax.swing.JTextField txtESNombre;
    private javax.swing.JTextField txtEncargadoDireccion;
    private javax.swing.JTextField txtEncargadoIdentificacion;
    private javax.swing.JTextField txtPApellido;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtPapeleria;
    private javax.swing.JTextField txtSApellido;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JTextField txtTNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
