/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cycsystemsgt.student_control.Controlador;

import com.cycsystemsgt.student_control.util.Menu;
import com.cycsystemsgt.student_control.Modelo.Entidades.Detalle;
import com.cycsystemsgt.student_control.Modelo.Entidades.DetallePagoRecibo;
import com.cycsystemsgt.student_control.Modelo.Entidades.Documento;
import com.cycsystemsgt.student_control.Modelo.Entidades.Grado;
import com.cycsystemsgt.student_control.Modelo.Entidades.Inasistencia;
import com.cycsystemsgt.student_control.Modelo.Entidades.Jornada;
import com.cycsystemsgt.student_control.Modelo.Entidades.Materia;
import com.cycsystemsgt.student_control.Modelo.Entidades.MotivoInasistencia;
import com.cycsystemsgt.student_control.Modelo.Entidades.Movimiento;
import com.cycsystemsgt.student_control.Modelo.Entidades.Notas;
import com.cycsystemsgt.student_control.Modelo.Entidades.Papeleria;
import com.cycsystemsgt.student_control.Modelo.Entidades.Telefono;
import com.cycsystemsgt.student_control.Modelo.Entidades.Unidad;
import com.cycsystemsgt.student_control.Vista.Catalogos.AsignacionAlumnoForm;
import com.cycsystemsgt.student_control.Vista.Catalogos.GradoForm;
import com.cycsystemsgt.student_control.Vista.Catalogos.JornadasForm;
import com.cycsystemsgt.student_control.Vista.Catalogos.MateriaForm;
import com.cycsystemsgt.student_control.Vista.Catalogos.MotivoInasistenciaForm;
import com.cycsystemsgt.student_control.Vista.Catalogos.NivelForm;
import com.cycsystemsgt.student_control.Vista.Catalogos.UnidadForm;
import com.cycsystemsgt.student_control.Modelo.Logica;
import com.cycsystemsgt.student_control.Modelo.Entidades.DatosLogin;
import com.cycsystemsgt.student_control.Vista.Ingresos.AlumnosForm;
import com.cycsystemsgt.student_control.Vista.Ingresos.InasistenciaForm;
import com.cycsystemsgt.student_control.Vista.Ingresos.NotasForm;
import com.cycsystemsgt.student_control.Vista.Menus.BuscarAlumno;
import com.cycsystemsgt.student_control.Vista.Menus.BuscarEncargado;
import com.cycsystemsgt.student_control.Vista.Menus.LoginForm;
import com.cycsystemsgt.student_control.Vista.Menus.PrincipalForm;
import com.cycsystemsgt.student_control.Vista.Menus.Splash;
import com.cycsystemsgt.student_control.util.ItemComboBox;
import com.cycsystemsgt.student_control.Modelo.Entidades.AsignacionAlumno;
import com.cycsystemsgt.student_control.Modelo.Entidades.Ciclo;
import com.cycsystemsgt.student_control.Modelo.Entidades.Nivel;
import com.cycsystemsgt.student_control.Modelo.Entidades.Persona;
import com.cycsystemsgt.student_control.Modelo.Entidades.Producto;
import com.cycsystemsgt.student_control.Modelo.Entidades.Recibo;
import com.cycsystemsgt.student_control.Vista.Catalogos.ProductoForm;
import com.cycsystemsgt.student_control.Vista.Contabilidad.MovimientosForm;
import com.cycsystemsgt.student_control.Vista.Contabilidad.RecibosForm;
import com.cycsystemsgt.student_control.Vista.Ingresos.ClientesForm;
import com.cycsystemsgt.student_control.Vista.Ingresos.ModificarNotaForm;
import com.cycsystemsgt.student_control.Vista.Menus.BuscarCliente;
import com.cycsystemsgt.student_control.Vista.Menus.BuscarProducto;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author angel
 */
public class Coordinador {
    public String[][] Permisos = null;
    public String[][] Menus = null;
    public DatosLogin Datos = null;
    public String[] TitulosPapeleria = new String[2];
    public String[] TitulosAlumnos = new String[2];
    public String[] TitulosBusquedaEncargado = new String[2];
    public String[] TitulosJornada = new String[2];
    public String[] TitulosNivel = new String[2];
    public String[] TitulosGrado = new String[5];
    public String[] TitulosUnidad = new String[2];
    public String[] TitulosMateria = new String[4];
    public String[] TitulosMotivoInasistencia = new String[2];
    public String[] TitulosAsignacionALumno = new String[5];
    public String[] TitulosInasistencias = new String[4];
    public String[] TitulosModificarNota = new String[4];
    private Logica logica;
    private LoginForm ventanaLogin;
    private AlumnosForm ventanaAlumnos;
    private PrincipalForm ventanaPrincipal;
    private JornadasForm ventanaJornadas;
    private NivelForm ventanaNivel;
    public BuscarEncargado dialogEncargado;
    public GradoForm ventanaGrado;
    public UnidadForm ventanaUnidad;
    public MateriaForm ventanaMateria;
    public MotivoInasistenciaForm ventanaMotivoInasistencia;
    public InasistenciaForm ventanaInasistencia;
    public AsignacionAlumnoForm ventanaAsignacionAlumno;
    public BuscarAlumno dialoAlumno;
    public BuscarCliente dialogCliente;
    public NotasForm ventanaNotas;
    public ModificarNotaForm ventanaModificarNota;
    public ClientesForm ventanaClientes;
    private ProductoForm ventanaProducto;
    private RecibosForm ventanaRecibos;
    public BuscarProducto dialogProducto;
    public MovimientosForm ventanaMovimientos;
    private final Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    public Frame fDialogEncargado = JOptionPane.getFrameForComponent(ventanaAlumnos);
    public Frame fDialogAlumno = JOptionPane.getFrameForComponent(ventanaInasistencia);
    public Frame _fDialogAlumno = JOptionPane.getFrameForComponent(ventanaAsignacionAlumno);
    public Frame _fDialogAlumno1 = JOptionPane.getFrameForComponent(ventanaModificarNota);
    public Frame fDialogCliente = JOptionPane.getFrameForComponent(ventanaRecibos);
    public Frame fDialogProducto = JOptionPane.getFrameForComponent(ventanaRecibos);

    public Logica getLogica() {
        return logica;
    }

    public void setLogica(Logica logica) {
        this.logica = logica;
    }

    // metodos y funciones para Inicio de Session
    
    /**
     * @param Usuario
     * @param Pass
     */
    public void Login(String Usuario, String Pass){
        if(logica.ValidarLogin(Usuario, Pass) == true){
            ventanaLogin.setVisible(false);
            Splash Splash = new Splash();
            Splash.setCoordinador(this);
            Splash.setVisible(true);
            Splash.run();
        }else{
            JOptionPane.showMessageDialog(null, "Error: Usuario o Contraseña incorrecta favor verificar");
            ventanaLogin.txtUsuario.requestFocus();
            ventanaLogin.txtUsuario.selectAll();
        }
    }
    
    public void InicializarObjetos(Coordinador coordinador){
        leerPropiedades();    
        
        dialogEncargado = new BuscarEncargado(fDialogEncargado, true);
        
        
        ventanaAlumnos = new AlumnosForm(coordinador);
        ventanaPrincipal = new PrincipalForm(coordinador);
        ventanaJornadas = new JornadasForm();
        ventanaNivel = new NivelForm();
        ventanaGrado = new GradoForm();
        ventanaUnidad = new UnidadForm();
        ventanaMateria = new MateriaForm();
        ventanaMotivoInasistencia = new MotivoInasistenciaForm();
        ventanaInasistencia = new InasistenciaForm(Permisos);
        ventanaAsignacionAlumno = new AsignacionAlumnoForm(coordinador);
        ventanaNotas = new NotasForm();
        ventanaModificarNota = new ModificarNotaForm();
        ventanaClientes = new ClientesForm(coordinador);
        ventanaProducto = new ProductoForm(coordinador);
        ventanaRecibos = new RecibosForm(coordinador);
        ventanaMovimientos = new MovimientosForm(coordinador);
        
        setVentanaPrincipal(ventanaPrincipal);
        setVentanaAlumnos(ventanaAlumnos);
        setVentanaJornadas(ventanaJornadas);
        setVentanaNivel(ventanaNivel);
        setVentanaGrado(ventanaGrado);
        setVentanaUnidad(ventanaUnidad);
        setVentanaMateria(ventanaMateria);
        setVentanaMotivoInasistencia(ventanaMotivoInasistencia);
        setVentanaInasistencia(ventanaInasistencia);
        setVentanaAsignacionAlumno(ventanaAsignacionAlumno);
        setVentanaNotas(ventanaNotas);
        setVentanaModificarNota(ventanaModificarNota);
        setVentanaClientes(ventanaClientes);
        setVentanaProducto(ventanaProducto);
        setVentanaRecibos(ventanaRecibos);
        setVentanaMovimientos(ventanaMovimientos);
        
        dialogEncargado.setCoordinador(coordinador);
        ventanaJornadas.setCoordinador(coordinador);
        ventanaNivel.setCoordinador(coordinador);
        ventanaGrado.setCoordinador(coordinador);
        ventanaUnidad.setCoordinador(coordinador);
        ventanaMateria.setCoordinador(coordinador);
        ventanaMotivoInasistencia.setCoordinador(coordinador);
        ventanaInasistencia.setCoordinador(coordinador);
        ventanaNotas.setCoordinador(coordinador);
        ventanaModificarNota.setCoordinador(coordinador);
        
        showPrincipal();
        ventanaLogin.setVisible(false);
    }
    
    public void leerPropiedades(){
        try {
   
            /**Creamos un Objeto de tipo Properties*/
            Properties propiedades = new Properties();
    
            /**Cargamos el archivo desde la ruta especificada*/
            //JOptionPane.showMessageDialog(null, System.getProperty("user.dir") + "\\propiedades\\System.properties");
            propiedades.load(new FileInputStream(System.getProperty("user.dir") + "\\propiedades\\System.properties"));
 
            /**Obtenemos los parametros definidos en el archivo*/
            TitulosPapeleria = propiedades.getProperty("TitulosPapeleria").split(",");
            TitulosAlumnos = propiedades.getProperty("TitulosAlumno").split(",");
            TitulosBusquedaEncargado = propiedades.getProperty("TItulosEncargado").split(",");
            TitulosJornada = propiedades.getProperty("TitulosJornadas").split(",");
            TitulosNivel = propiedades.getProperty("TitulosNivel").split(",");
            TitulosGrado = propiedades.getProperty("TitulosGrado").split(",");
            TitulosUnidad = propiedades.getProperty("TitulosUnidad").split(",");
            TitulosMateria = propiedades.getProperty("TitulosMateria").split(",");
            TitulosMotivoInasistencia = propiedades.getProperty("TitulosMotivoInasistencias").split(",");
            TitulosInasistencias = propiedades.getProperty("TitulosInasistencias").split(",");
            TitulosAsignacionALumno = propiedades.getProperty("TitulosAsignacionAlumno").split(",");
            TitulosModificarNota = propiedades.getProperty("TitulosModificaNotas").split(",");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error, El archivo de propiedades no exite: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error, No se puede leer el archivo de Propiedades", "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 
     * @return Matriz con lo permisos 
     */
    public String[][] getPermisos() {
        return Permisos;
    }

    /**
     * 
     * @return Matriz con los Menus Asignados al Usuario
     */
    public String[][] getMenus() {
        return Menus;
    }
    
    public ArrayList<String> obtenerMes(String alumno){
        return logica.obtenerMes(alumno);
    }

    /**
     * 
     * @return  Datos del Usuario
     */
    public DatosLogin getDatos() {
        return Datos;
    }
    
    // Manejo de las Opciones
    // Ventana Login
    public LoginForm getVentanaLogin() {
        return ventanaLogin;
    }

    public void setVentanaLogin(LoginForm ventanaLogin) {
        this.ventanaLogin = ventanaLogin;
    }
    
    public void showLogin(){
        this.ventanaLogin.setVisible(true);
    }
    
    public void closeLogin(){
        this.ventanaLogin.dispose();
    }
    
    //Ventana Principal
    public PrincipalForm getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(PrincipalForm ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public void setVentanaClientes(ClientesForm ventanaClientes) {
        this.ventanaClientes = ventanaClientes;
    }

    public void setVentanaProducto(ProductoForm ventanaProducto) {
        this.ventanaProducto = ventanaProducto;
    }

    public void setVentanaRecibos(RecibosForm ventanaRecibos) {
        this.ventanaRecibos = ventanaRecibos;
    }

    public void setVentanaMovimientos(MovimientosForm ventanaMovimientos) {
        this.ventanaMovimientos = ventanaMovimientos;
    }
    
    public void showPrincipal(){
        Menu menu = new Menu(this.getMenus(), "Acciones");
        ventanaPrincipal.setJMenuBar(menu);
        ventanaPrincipal.setVisible(true);
    }
    
    
    //Ventana Alumnos
    public AlumnosForm getVentanaAlumnos() {
        return ventanaAlumnos;
    }

    public void setVentanaAlumnos(AlumnosForm ventanaAlumnos) {
        this.ventanaAlumnos = ventanaAlumnos;
    }
    
    public void showAlumnos(){
        if(estadoFrame(ventanaAlumnos) == true){
            ventanaPrincipal.escritorio.add(ventanaAlumnos);
            Dimension va = ventanaAlumnos.getSize();
            ventanaAlumnos.setLocation((pantalla.width - va.width)/2, (pantalla.height - va.height)/2);
        }        
        ventanaAlumnos.setVisible(true);
        
        //Inicializacion de tablas
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        modelo.setColumnIdentifiers(TitulosPapeleria);
        ventanaAlumnos.tblPapeleria.setModel(modelo);
        
        cargartblAlumnos();
        
        //Inicializacion de Listas
        cbGenero();
        cbGeneroEncargado();
        cbTipoDocumento();
        cbTipoPapeleria();
        cbTipoEncargado();
        
        
    }
    
    public void closeAlumnos(){
        this.ventanaAlumnos.hide();
    }
    
    public void cbGenero(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            ventanaAlumnos.cbGenero.setModel(modelo);
            logica.ListaGenero().stream().forEach((ListaGenero) -> {
                modelo.addElement(new ItemComboBox(ListaGenero.getIdGenero().toString(), ListaGenero.getDescripcion()));
            });
            ventanaAlumnos.cbGenero.setSelectedIndex(-1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cbGeneroEncargado(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            logica.ListaGenero().stream().forEach((ListaGenero) -> {
                modelo.addElement(new ItemComboBox(ListaGenero.getIdGenero().toString(), ListaGenero.getDescripcion()));
            });
            ventanaAlumnos.cbEncargadoGenero.setModel(modelo);
            ventanaAlumnos.cbEncargadoGenero.setSelectedIndex(-1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cbTipoDocumento(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            logica.ListaTipoDocumento().stream().forEach((ListaTipo) -> {
                modelo.addElement(new ItemComboBox(ListaTipo.getIdTipoDocumento().toString(), ListaTipo.getTipo()));
            });
            ventanaAlumnos.cbEncargadoIdentificacion.setModel(modelo);
            ventanaAlumnos.cbEncargadoIdentificacion.setSelectedIndex(-1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cbTipoPapeleria(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            logica.ListaTipoPapeleria().stream().forEach((ListaTipo) ->{
                modelo.addElement(new ItemComboBox(ListaTipo.getIdTipoPapeleria().toString(), ListaTipo.getDescripcion()));
            });
            ventanaAlumnos.cbTipoPapeleria.setModel(modelo);
            ventanaAlumnos.cbTipoPapeleria.setSelectedIndex(-1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cbTipoEncargado(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            logica.ListaTipoPersona().stream().forEach((ListaTipo)->{
                modelo.addElement(new ItemComboBox(ListaTipo.getIdTipoPersona().toString(), ListaTipo.getDescripcion()));
            });
            ventanaAlumnos.cbTipoEncargado.setModel(modelo);
            ventanaAlumnos.cbTipoEncargado.setSelectedIndex(-1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargartblAlumnos(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = logica.tblAlumnos();
        ventanaAlumnos.tblAlumno.setModel(modelo);
        ventanaAlumnos.sorter = new TableRowSorter<>(modelo);
        ventanaAlumnos.tblAlumno.setRowSorter(ventanaAlumnos.sorter);
        ventanaAlumnos.tblAlumno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public Boolean GuardarPersona(Persona persona){
        return logica.guardarPersona(persona);
    }
    
    /**
     * 
     * @param Operacion a realizar puede ser Creacion, modificacion
     * @param Encargado son los datos del padre o tutor del alumno
     * @param Alumno son los datos a guardar del nuevo alumno
     * @param telefono es el metodo de comunicacion del padre o encargado
     * @param documento es la identificacion del padre
     * @return 
     */
    public Boolean GuardarAlumno(Integer Operacion, Persona Encargado, Persona Alumno, Telefono telefono, Documento documento){
        return logica.guardarAlumno(Operacion, Encargado, Alumno, documento, telefono);
    }
    
    /**
     * 
     * @param Operacion a realizar puede ser Creacion, modificacion o consulta
     * @param mPapeleria son los datos a guardar
     * @param IdPapeleria el id de la papeleria eliminada
     * @return  true o false como resultado de la operacion
     */
    public Boolean guardarPapeleria(Integer Operacion, Papeleria mPapeleria, Integer IdPapeleria){
        return logica.operacionesPapeleria(Operacion, mPapeleria, IdPapeleria);
    }
    
    public Integer getCodigo(Object Item){
        return logica.getCodigo(Item);
    }
    
    public ArrayList<String> getCredenciales(String PNombre, String PApellido){
        return logica.crearUsuario(PNombre, PApellido);
    }
    
    public ArrayList<String> buscarAlumno(String IdAlumno){
        return logica.buscarAlumno(IdAlumno);
    }
    
    public ArrayList<String> buscarDocumento(String IdDocumento){
        return logica.buscarDocumento(IdDocumento);
    }
    
    public DefaultTableModel buscarPapeleria(String IdPersona){
        return logica.buscarPapeleria(IdPersona);
    }
    
    public Integer getIdRol(Integer IdRol){
        return logica.getIdRol(IdRol);
    }
    
    public Integer generarCodigo(){
        return logica.getCodigoNuevo();
    }
    
    public String buscarTelefono(String IdPersona){
        return logica.buscarTelefono(IdPersona);
    }
    
    public String getNombre(Object Item){
        return logica.getNombre(Item);
    }
    
    //Ventana Busqueda de Encargado
    
    public DefaultTableModel listaEncargados(){
        return logica.listaEncargados();
    }
    
    public DefaultTableModel obtenerClientes(DefaultTableModel modelo){
        return logica.obtenerClientes(modelo);
    }
    
    public DefaultTableModel obtenerProductos(DefaultTableModel modelo){
        return logica.obtenerProductos(modelo);
    }
    
    public Persona buscarPersona(String IdPersona){
        return logica.buscarPersona(IdPersona);
    }
    
    public static void setSelectedValue(JComboBox comboBox, String value){
        ItemComboBox item;
        for (int i = 0; i < comboBox.getItemCount(); i++){
            item = (ItemComboBox)comboBox.getItemAt(i);
            if (item.toString().equals(value)){
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public static void setSelectedValue(JComboBox comboBox, Integer value){
        ItemComboBox item;
        for (int i = 0; i < comboBox.getItemCount(); i++){
            item = (ItemComboBox)comboBox.getItemAt(i);
            if (item.getID().equals(value.toString())){
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }
    
    //Ventana Jornadas

    public JornadasForm getVentanaJornadas() {
        return ventanaJornadas;
    }

    public void setVentanaJornadas(JornadasForm ventanaJornadas) {
        this.ventanaJornadas = ventanaJornadas;
    }  
    
    public void showJornadas(){
        if(estadoFrame(ventanaJornadas)){
            ventanaPrincipal.escritorio.add(ventanaJornadas);
        }
        Dimension va = ventanaJornadas.getSize();
        ventanaJornadas.setLocation((pantalla.width - va.width)/2, (pantalla.height - va.height)/2);
        ventanaJornadas.setVisible(true);
        cargarTblJornadas();
    }
    
    public void cargarTblJornadas(){
        ventanaJornadas.tblJornadas.setModel(logica.modeloJornadas());
    }
    
    public Boolean registrarJornada(Jornada jornada){
        return logica.registrarJornada(jornada);
    }
    
    public Boolean modificarJornada(Jornada jornada){
        return logica.modificarJornada(jornada);
    }
    
    //Ventana Nivel
    
    public Boolean registrarNivel(Nivel nivel){
        return logica.registrarNivel(nivel);
    }
    
    public Boolean modificarNivel(Nivel nivel){
        return logica.modificarNivel(nivel);
    }

    public NivelForm getVentanaNivel() {
        return ventanaNivel;
    }

    public void setVentanaNivel(NivelForm ventanaNivel) {
        this.ventanaNivel = ventanaNivel;
    }
    
    public void showNivel(){
        if(estadoFrame(ventanaNivel)){
            ventanaPrincipal.escritorio.add(ventanaNivel);
        }
        Dimension vnivel = ventanaNivel.getSize();
        ventanaNivel.setLocation((pantalla.width - vnivel.width)/2, (pantalla.height - vnivel.height)/2);
        ventanaNivel.setVisible(true);
        cargarNivel();
    }
    
    public void cargarNivel(){
        ventanaNivel.tblNivel.setModel(logica.modeloNivel());
    }
    
    //Ventana Grado
    
    public void showGrado(){
        ventanaPrincipal.escritorio.add(ventanaGrado);
        Dimension vGrado = ventanaGrado.getSize();
        ventanaGrado.setLocation((pantalla.width - vGrado.width)/2, (pantalla.height - vGrado.height)/ 2);
        ventanaGrado.setVisible(true);
        gradoComboJornada();
        gradoComboNivel();
        gradoComboSeccion();
        cargarGrado();
    }

    public GradoForm getVentanaGrado() {
        return ventanaGrado;
    }

    public void setVentanaGrado(GradoForm ventanaGrado) {
        this.ventanaGrado = ventanaGrado;
    }
    
    public void gradoComboJornada(){
        ventanaGrado.cbJornada.setModel(logica.comboJornada());
        ventanaGrado.cbJornada.setSelectedIndex(-1);
    }
    
    public void gradoComboNivel(){
        ventanaGrado.cbNivel.setModel(logica.comboNivel());
        ventanaGrado.cbNivel.setSelectedIndex(-1);
    }
    
    public void gradoComboSeccion(){
        ventanaGrado.cbSeccion.setModel(logica.comboSeccion());
        ventanaGrado.cbSeccion.setSelectedIndex(-1);
    }
    
    public void cargarGrado(){
        ventanaGrado.tblGrado.setModel(logica.tablaGrado());
    }
    
    public Boolean registrarGrado(Grado mGrado){
        return logica.registrarGrado(mGrado);
    }
    
    public Boolean modificarGrado(Grado mGrado){
        return logica.modificarGrado(mGrado);
    }
    
    // Ventana Unidad
    
    public void showUnidad(){
        ventanaPrincipal.escritorio.add(ventanaUnidad);
        Dimension vUnidad = ventanaUnidad.getSize();
        ventanaUnidad.setLocation((pantalla.width - vUnidad.width)/2, (pantalla.height - vUnidad.height)/2);
        ventanaUnidad.setVisible(true);
        cargarTblUnidad();
    }
    
    public Boolean registrarUnidad(Unidad mUnidad){
        return logica.registrarUnidad(mUnidad);
    }
    
    public Boolean modificarUnidad(Unidad mUnidad){
        return logica.modificarUnidad(mUnidad);
    }

    public UnidadForm getVentanaUnidad() {
        return ventanaUnidad;
    }

    public void setVentanaUnidad(UnidadForm ventanaUnidad) {
        this.ventanaUnidad = ventanaUnidad;
    }
    
    public void cargarTblUnidad(){
        ventanaUnidad.tblUnidad.setModel(logica.tablaUnidad());
    }
    
    // Ventana Materia
    
    public Boolean registrarMateria(Materia mMateria){
        return logica.registrarMateria(mMateria);
    }
    
    public Boolean modificarMateria(Materia mMateria){
        return logica.modificarMateria(mMateria);
    }
    
    public void showMateria(){
        ventanaPrincipal.escritorio.add(ventanaMateria);
        Dimension vMateria = ventanaMateria.getSize();
        ventanaMateria.setLocation((pantalla.width - vMateria.width)/2, (pantalla.height - vMateria.height)/2);
        ventanaMateria.setVisible(true);
        materiaComboJornada();
        materiaComboNivel();
        materiaComboSeccion();
    }
    
    public void cargarTblMateria(Integer Grado){
        ventanaMateria.tblMateria.setModel(logica.tablaMaterias(Grado));
    }

    public MateriaForm getVentanaMateria() {
        return ventanaMateria;
    }

    public void setVentanaMateria(MateriaForm ventanaMateria) {
        this.ventanaMateria = ventanaMateria;
    }
    
    public void materiaComboJornada(){
        ventanaMateria.cbJornada.setModel(logica.comboJornada());
        ventanaMateria.cbJornada.setSelectedIndex(-1);
    }
    
    public void materiaComboNivel(){
        ventanaMateria.cbNivel.setModel(logica.comboNivel());
        ventanaMateria.cbNivel.setSelectedIndex(-1);
    }
    
    public void materiaComboSeccion(){
        ventanaMateria.cbSeccion.setModel(logica.comboSeccion());
        ventanaMateria.cbSeccion.setSelectedIndex(-1);
    }
    
    public void gradoComboGrado(Integer Jornada, Integer Seccion, Integer Nivel){
        ventanaMateria.cbGrado.setModel(logica.comboGrado(Jornada, Seccion, Nivel));
        ventanaMateria.cbGrado.setSelectedIndex(-1);
    }
    
    public Grado obtenerGrado(Integer Materia){
        return logica.obtenerGrado(Materia);
    }
    
    //Ventana MotivoInasistencia

    public MotivoInasistenciaForm getVentanaMotivoInasistencia() {
        return ventanaMotivoInasistencia;
    }

    public void setVentanaMotivoInasistencia(MotivoInasistenciaForm ventanaMotivoInasistencia) {
        this.ventanaMotivoInasistencia = ventanaMotivoInasistencia;
    }
    
    public void showMotivoInasistencia(){
        ventanaPrincipal.escritorio.add(ventanaMotivoInasistencia);
        Dimension vMotivo = ventanaMotivoInasistencia.getSize();
        ventanaMotivoInasistencia.setLocation((pantalla.width - vMotivo.width)/2, (pantalla.height - vMotivo.height)/2);
        ventanaMotivoInasistencia.setVisible(true);
        cargarTablaMotivoInasistencia();
    }
    
    public void cargarTablaMotivoInasistencia(){
        ventanaMotivoInasistencia.tblMotivoInasistencia.setModel(logica.tablaMotivoInasistencia());
    }
    
    public Boolean registrarMotivoInasistecia(MotivoInasistencia motivo){
        return logica.registrarMotivoInasistencia(motivo);
    }
    
    public Boolean modificarMotivoInasistencia(MotivoInasistencia motivo){
        return logica.modificarMotivoInasistencia(motivo);
    }
    
    public MotivoInasistencia obtenerMotivoInasistencia(Integer IdMotivoInasistencia){
        return logica.obtenerMotivoInasistencia(IdMotivoInasistencia);
    }
    
    //Ventana Inasistencias

    public InasistenciaForm getVentanaInasistencia() {
        return ventanaInasistencia;
    }

    public void setVentanaInasistencia(InasistenciaForm ventanaInasistencia) {
        this.ventanaInasistencia = ventanaInasistencia;
    }
    
    public void showInasistencias(){
        if(estadoFrame(ventanaPrincipal)){
            ventanaPrincipal.escritorio.add(ventanaInasistencia);
        }
        Dimension vInasistencia = ventanaInasistencia.getSize();
        ventanaInasistencia.setLocation((pantalla.width - vInasistencia.width)/2, (pantalla.height - vInasistencia.height)/2);
        ventanaInasistencia.setVisible(true);
        cargarMotivosInasistencia();
        dialoAlumno = new BuscarAlumno(fDialogAlumno, true);
        dialoAlumno.setCoordinador(this);
    }
    
    public Boolean modificarInasistencia(Inasistencia Inasistencia){
        return logica.modificarInasistencia(Inasistencia);
    }
    
    public Boolean registrarInasistencia(Inasistencia Inasistencia){
        return logica.registrarInasistencia(Inasistencia);
    }
    
    public void cargarTablaInasistencias(String Alumno){
        ventanaInasistencia.tblInasistencias.setModel(logica.tablaInasistencias(Alumno));
    }
    
    public void cargarMotivosInasistencia(){
        ventanaInasistencia.cbMotivo.setModel(logica.listaMotivosInasistencia());
        ventanaInasistencia.cbMotivo.setSelectedIndex(-1);
    }
    
    public void cargarTblBusquedaAlumno(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = logica.tblAlumnos();
        ventanaAlumnos.tblAlumno.setModel(modelo);
        ventanaAlumnos.sorter = new TableRowSorter<>(modelo);
        ventanaAlumnos.tblAlumno.setRowSorter(ventanaAlumnos.sorter);
        ventanaAlumnos.tblAlumno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public DefaultTableModel listaAlumnos(){
        return logica.tblAlumnos();
    } 
    
    public Inasistencia obtenerInasistencia(Integer IdInasistencia){
        return logica.obtenerInasistencia(IdInasistencia);
    }
    
    //Ventana AsignacionAlumno
    
    public void showAsignacionAlumnos(Persona alumno){
        if(estadoFrame(ventanaAsignacionAlumno)){
            ventanaPrincipal.escritorio.add(ventanaAsignacionAlumno);
        }
        ventanaAsignacionAlumno.llenarCampos(alumno);
        Dimension vAsignacionAlumno = ventanaAsignacionAlumno.getSize();
        ventanaAsignacionAlumno.setLocation((pantalla.width - vAsignacionAlumno.width)/ 2, (pantalla.height - vAsignacionAlumno.height) / 2);
        ventanaAsignacionAlumno.setVisible(true);
        ventanaAsignacionAlumno.cbJornada.setModel(logica.comboJornada());
        ventanaAsignacionAlumno.cbJornada.setSelectedIndex(-1);
        ventanaAsignacionAlumno.cbNivel.setModel(logica.comboNivel());
        ventanaAsignacionAlumno.cbNivel.setSelectedIndex(-1);
        ventanaAsignacionAlumno.cbSeccion.setModel(logica.comboSeccion());
        ventanaAsignacionAlumno.cbSeccion.setSelectedIndex(-1);
        dialoAlumno = new BuscarAlumno(_fDialogAlumno, true);
        dialoAlumno.setCoordinador(this);
        ventanaAsignacionAlumno.lblCiclo.setText(obtenerCicloActivo().getCiclo());
    }

    public AsignacionAlumnoForm getVentanaAsignacionAlumno() {
        return ventanaAsignacionAlumno;
    }

    public void setVentanaAsignacionAlumno(AsignacionAlumnoForm ventanaAsignacionAlumno) {
        this.ventanaAsignacionAlumno = ventanaAsignacionAlumno;
    }
    
    public void AsignacionAlumnoComboGrado(Integer Jornada, Integer Seccion, Integer Nivel){
        ventanaAsignacionAlumno.cbGrado.setModel(logica.comboGrado(Jornada, Seccion, Nivel));
        ventanaAsignacionAlumno.cbGrado.setSelectedIndex(-1);
    }
    
    public Ciclo obtenerCicloActivo(){
        return logica.obtenerCicloActivo();
    }
    
    public DefaultTableModel tblAsignacionAlumno(Integer Grado){
        return logica.tblAsignacionAlumno(Grado);
    }
    
    public Boolean registrarAsignacionAlumno(AsignacionAlumno Asignacion){
        return logica.registrarAsignacionAlumno(Asignacion);
    }
    
    public Boolean modificarAsignacionAlumno(AsignacionAlumno Asignacion){
        return logica.modificarAsignacionAlumno(Asignacion);
    }
    
    public Ciclo obtenerCiclo(String Ciclo){
        return logica.obtenerCicloActivo(Ciclo);
    }
    
    public AsignacionAlumno buscarAsignacion(Integer Ciclo, String Alumno){
        return logica.buscarAsignacion(Alumno, Ciclo);
    }
    
    public void showNotasform(){
        if(estadoFrame(ventanaNotas)){
            ventanaPrincipal.escritorio.add(ventanaNotas);
        }
        Dimension vNotasForm = ventanaNotas.getSize();
        ventanaNotas.setLocation((pantalla.width - vNotasForm.width)/2, (pantalla.height - vNotasForm.height)/2);
        ventanaNotas.setVisible(true);
        ventanaNotas.cbJornada.setModel(logica.comboJornada());
        ventanaNotas.cbJornada.setSelectedIndex(-1);
        ventanaNotas.cbNivel.setModel(logica.comboNivel());
        ventanaNotas.cbNivel.setSelectedIndex(-1);
        ventanaNotas.cbSeccion.setModel(logica.comboSeccion());
        ventanaNotas.cbSeccion.setSelectedIndex(-1);
        ventanaNotas.cbUnidad.setModel(logica.comboUnidad());
        ventanaNotas.cbUnidad.setSelectedIndex(-1);
        ventanaNotas.cbAlumno.setSelectedIndex(-1);
        ventanaNotas.deshabilitarCampos();
    }

    public void setVentanaNotas(NotasForm ventanaNotas) {
        this.ventanaNotas = ventanaNotas;
    }
    
    public void notasComboGrado(Integer Jornada, Integer Seccion, Integer Nivel){
        ventanaNotas.cbGrado.setModel(logica.comboGrado(Jornada, Seccion, Nivel));
        ventanaNotas.cbGrado.setSelectedIndex(-1);
    }
    
    public void notasComboMateria(Integer Grado){
        ventanaNotas.cbMateria.setModel(logica.comboMateria(Grado));
        ventanaNotas.cbMateria.setSelectedIndex(-1);
    }
    
    public void notasComboAlumnos(Integer Ciclo, Integer Grado, Integer Unidad, Integer Materia){
        ventanaNotas.cbAlumno.setModel(logica.comboAlumno(Ciclo, Grado, Unidad, Materia));
        ventanaNotas.cbAlumno.setSelectedIndex(-1);
    }
    
    public Boolean guardarNota(Notas nuevaNota){
        return logica.registrarNota(nuevaNota);
    }
    
    public void showmodificarNotaForm(){
        if(estadoFrame(ventanaModificarNota)){
            ventanaPrincipal.escritorio.add(ventanaModificarNota);
        }
        Dimension vVentanaModificarNota = ventanaModificarNota.getSize();
        ventanaModificarNota.setLocation((pantalla.width - vVentanaModificarNota.width)/2, (pantalla.height - vVentanaModificarNota.height)/2);
        ventanaModificarNota.setVisible(true);
        ventanaModificarNota.cbUnidad.setModel(logica.comboUnidad());
        ventanaModificarNota.cbUnidad.setSelectedIndex(-1);
        dialoAlumno = new BuscarAlumno(_fDialogAlumno1, true);
        dialoAlumno.setCoordinador(this);
    }

    public void setVentanaModificarNota(ModificarNotaForm ventanaModificarNota) {
        this.ventanaModificarNota = ventanaModificarNota;
    }
    
    /**
     * 
     * @param Grado
     * @return 
     */
    public DefaultComboBoxModel comboMateria(Integer Grado){
        return logica.comboMateria(Grado);
    }
    
    public DefaultTableModel notasAlumno(String Alumno, Integer Unidad){
        return logica.buscarNotas(Alumno, Unidad);
    }
    
    public Boolean modificarNota(Notas nuevaNota){
        return logica.modificarNota(nuevaNota);
    }
    
    public void showClientesForm(){
        if(estadoFrame(ventanaClientes) == true){
            ventanaPrincipal.escritorio.add(ventanaClientes);
        }
        Dimension vClientes = ventanaClientes.getSize();
        ventanaClientes.setLocation((pantalla.width - vClientes.width) / 2, (pantalla.height - vClientes.height) / 2);
        ventanaClientes.setVisible(true);
        ventanaClientes.cbGenero.setModel(logica.comboGenero());
        ventanaClientes.cbGenero.setSelectedIndex(-1);
        cargarClientes();
    }
    
    public void cargarClientes(){
        DefaultTableModel modelo = (DefaultTableModel) ventanaClientes.tblClientes.getModel();
        ventanaClientes.tblClientes.setModel(logica.obtenerClientes(modelo));
        ventanaClientes.sorter = new TableRowSorter<>(logica.obtenerClientes(modelo));
        ventanaClientes.tblClientes.setRowSorter(ventanaClientes.sorter);
        ventanaClientes.tblClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public Boolean registrarClientes(Persona persona, Telefono telefono){
        return logica.registrarClientes(persona, telefono);
    }
    
    public Boolean modificarClientes(Persona persona, Telefono telefono){
        return logica.modificarClientes(persona, telefono);
    }
    
    public void showProductosForm(){
        if(estadoFrame(ventanaProducto)){
            ventanaPrincipal.escritorio.add(ventanaProducto);
        }
        Dimension vProducto = ventanaProducto.getSize();
        ventanaProducto.setLocation((pantalla.width - vProducto.width)/2, (pantalla.height - vProducto.height)/2);
        ventanaProducto.setVisible(true);
        ventanaProducto.cbCategoria.setModel(logica.comboCategoria());
        ventanaProducto.cbCategoria.setSelectedIndex(-1);
        ventanaProducto.cbEstado.setModel(logica.comboEstadoProducto());
        ventanaProducto.cbEstado.setSelectedIndex(-1);
        cargarProductos();
    }
    
    public void cargarProductos(){
        DefaultTableModel modelo = (DefaultTableModel) ventanaProducto.tblProductos.getModel();
        ventanaProducto.tblProductos.setModel(logica.obtenerProductos(modelo));
        ventanaProducto.sorter = new TableRowSorter<>(logica.obtenerProductos(modelo));
        ventanaProducto.tblProductos.setRowSorter(ventanaProducto.sorter);
        ventanaProducto.tblProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public Boolean registrarProducto(Producto producto){
        return logica.registrarProductos(producto);
    }
    
    public Boolean modificarProducto(Producto producto){
        return logica.modificarProductos(producto);
    }
    
    public Producto obtenerProducto(Integer idProducto){
        return logica.obtenerProducto(idProducto);
    }
    
    public void showRecibos(){
        if(estadoFrame(ventanaRecibos)){
            ventanaPrincipal.escritorio.add(ventanaRecibos);
        }
        Dimension vRecibos = ventanaRecibos.getSize();
        ventanaRecibos.setLocation((pantalla.width - vRecibos.width) / 2, (pantalla.height - vRecibos.height) / 2);
        ventanaRecibos.setVisible(true);
        ventanaRecibos.cbNivel.setModel(logica.comboNivel());
        ventanaRecibos.cbNivel.setSelectedIndex(-1);
        ventanaRecibos.cbSeccion.setModel(logica.comboSeccion());
        ventanaRecibos.cbSeccion.setSelectedIndex(-1);
        ventanaRecibos.cbJornada.setModel(logica.comboJornada());
        ventanaRecibos.cbJornada.setSelectedIndex(-1);
        ventanaRecibos.cbFormaPago.setModel(logica.comboFormaPago());
        ventanaRecibos.cbFormaPago.setSelectedIndex(-1);
        dialogCliente = new BuscarCliente(fDialogCliente, true);
        dialogCliente.setCoordinador(this);
        dialogProducto = new BuscarProducto(fDialogProducto, true);
        dialogProducto.setCoordinador(this);
    }
    
    public void recibosComboAlumnos(Integer Grado){
        ventanaRecibos.cbAlumno.setModel(logica.comboAlumno(Grado));
        ventanaRecibos.cbAlumno.setSelectedIndex(-1);
    }
    
    public void recibosComboGrado(Integer Jornada, Integer Seccion, Integer Nivel){
        ventanaRecibos.cbGrado.setModel(logica.comboGrado(Jornada, Seccion, Nivel));
        ventanaRecibos.cbGrado.setSelectedIndex(-1);
    }
    
    public Movimiento obtenerPrecioActual(int producto){
        return logica.obtenerPrecioActual(producto);
    }
    
    public String obtenerCorrelativoRecibo(){
        return logica.obtenerCorrelativoRecibo();
    }
    
    public Boolean registrarRecibo(Recibo recibo, List<Detalle> detalles, DetallePagoRecibo detallePago){
        return logica.registrarRecibo(recibo, detalles, detallePago);
    }
    
    public Boolean estadoFrame(Object obj){
        boolean estado = true;
        JInternalFrame[] frames = ventanaPrincipal.escritorio.getAllFrames();
        for (JInternalFrame frame : frames) {
            if (frame == obj) {
                estado = false;
                break;
            }
        }
        return estado;
    }
    
    public void showMovimientos(){
        if(estadoFrame(ventanaMovimientos)){
            ventanaPrincipal.escritorio.add(ventanaMovimientos);
        }
        Dimension vMovimiento = ventanaMovimientos.getSize();
        ventanaMovimientos.setLocation((pantalla.width - vMovimiento.width)/2, (pantalla.height - vMovimiento.height)/2);
        ventanaMovimientos.setVisible(true);
        ventanaMovimientos.cbProducto.setModel(logica.comboProducto());
        ventanaMovimientos.cbProducto.setSelectedIndex(-1);
        ventanaMovimientos.cbProveedor.setModel(logica.comboProveedor());
        ventanaMovimientos.cbProveedor.setSelectedIndex(-1);
        ventanaMovimientos.cbSede.setModel(logica.comboSede());
        ventanaMovimientos.cbSede.setSelectedIndex(-1);
        ventanaMovimientos.cbTipoMovimiento.setModel(logica.comboTipoMovimiento());
        ventanaMovimientos.cbTipoMovimiento.setSelectedIndex(-1);
        cargarMovimientos();
    }
    
    public void cargarMovimientos(){
        DefaultTableModel modelo = (DefaultTableModel) ventanaMovimientos.tblFiltro.getModel();
        ventanaMovimientos.tblFiltro.setModel(logica.obtenerMovimiento(modelo));
        ventanaMovimientos.sorter = new TableRowSorter<>(logica.obtenerMovimiento(modelo));
        ventanaMovimientos.tblFiltro.setRowSorter(ventanaMovimientos.sorter);
        ventanaMovimientos.tblFiltro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ventanaMovimientos.tblFiltro.getColumnModel().getColumn(0).setPreferredWidth(9);
        ventanaMovimientos.tblFiltro.getColumnModel().getColumn(1).setPreferredWidth(12);
        ventanaMovimientos.tblFiltro.getColumnModel().getColumn(2).setPreferredWidth(50);
    } 
    
    /**
     *
     * @param movimiento
     * @return true if movement is already saved
     */
    public Boolean registrarMovimiento(Movimiento movimiento){
        return logica.registrarMovimiento(movimiento);
    }
    
    public Movimiento obtenerMovimiento(Integer idMovimiento){
        return logica.obtenerMovimiento(idMovimiento);
    }
}
