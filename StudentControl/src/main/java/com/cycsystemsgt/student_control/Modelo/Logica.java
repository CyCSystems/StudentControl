package com.cycsystemsgt.student_control.Modelo;

import com.cycsystemsgt.student_control.util.MD5;
import com.cycsystemsgt.student_control.Modelo.Dao.DocumentoDAO;
import com.cycsystemsgt.student_control.Controlador.Coordinador;
import com.cycsystemsgt.student_control.Modelo.Dao.GeneroDao;
import com.cycsystemsgt.student_control.Modelo.Dao.GradoDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.InasistenciaDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.JornadaDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.MateriaDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.MotivoInasistenciaDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.NivelDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.PapeleriaDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.RolDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.SeccionDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.TelefonoDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.TipoDocumentoDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.TipoPapeleriaDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.TipoPersonaDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.UnidadDAO;
import com.cycsystemsgt.student_control.Modelo.Entidades.Documento;
import com.cycsystemsgt.student_control.Modelo.Entidades.Genero;
import com.cycsystemsgt.student_control.Modelo.Entidades.Grado;
import com.cycsystemsgt.student_control.Modelo.Entidades.Inasistencia;
import com.cycsystemsgt.student_control.Modelo.Entidades.Jornada;
import com.cycsystemsgt.student_control.Modelo.Entidades.Materia;
import com.cycsystemsgt.student_control.Modelo.Entidades.MotivoInasistencia;
import com.cycsystemsgt.student_control.Modelo.Entidades.Papeleria;
import com.cycsystemsgt.student_control.Modelo.Entidades.Telefono;
import com.cycsystemsgt.student_control.Modelo.Entidades.TipoDocumento;
import com.cycsystemsgt.student_control.Modelo.Entidades.TipoPapeleria;
import com.cycsystemsgt.student_control.Modelo.Entidades.TipoPersona;
import com.cycsystemsgt.student_control.Modelo.Entidades.Unidad;
import com.cycsystemsgt.student_control.util.ItemComboBox;
import com.cycsystemsgt.student_control.Modelo.Dao.AsignacionAlumnoDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.CicloDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.EstadoProductoDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.FormaPagoDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.MovimientoDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.NotaDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.PersonaDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.ProductoDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.ReciboDAO;
import com.cycsystemsgt.student_control.Modelo.Entidades.Detalle;
import com.cycsystemsgt.student_control.Modelo.Entidades.DetallePagoRecibo;
import com.cycsystemsgt.student_control.Modelo.Entidades.Movimiento;
import com.cycsystemsgt.student_control.Modelo.Entidades.Notas;
import com.cycsystemsgt.student_control.Modelo.Entidades.AsignacionAlumno;
import com.cycsystemsgt.student_control.Modelo.Entidades.Ciclo;
import com.cycsystemsgt.student_control.Modelo.Entidades.Nivel;
import com.cycsystemsgt.student_control.Modelo.Entidades.Persona;
import com.cycsystemsgt.student_control.Modelo.Entidades.Producto;
import com.cycsystemsgt.student_control.Modelo.Entidades.Recibo;
import com.cycsystemsgt.student_control.Modelo.Dao.CategoriaDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.ProveedorDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.SedeDAO;
import com.cycsystemsgt.student_control.Modelo.Dao.TipoMovimientoDAO;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emmanuel Rodas
 */
public class Logica {
    private Coordinador Coordinador;
    private final PersonaDAO persona;
    private final DocumentoDAO documento;
    private final TelefonoDAO telefono;
    private final PapeleriaDAO  papeleria;
    private final JornadaDAO jornada;
    private final NivelDAO nivel;
    private final SeccionDAO seccion;
    private final GradoDAO grado;
    private final UnidadDAO unidad;
    private final MateriaDAO materia;
    private final MotivoInasistenciaDAO motivoinasistencia;
    private final InasistenciaDAO Inasistencia;
    private final CicloDAO ciclo;
    private final AsignacionAlumnoDAO asignacionAlumno;
    private final NotaDAO nota;
    private final GeneroDao genero;
    private final ProductoDAO producto;
    private final FormaPagoDAO formaPago;
    private final CategoriaDAO categoria;
    private final EstadoProductoDAO estadoProducto;
    private final MovimientoDAO movimiento;
    private final ReciboDAO recibo;
    private final ProveedorDAO proveedor;
    private final SedeDAO sede;
    private final TipoMovimientoDAO tipoMovimiento;
    
    public Logica(){
        persona = new PersonaDAO();
        documento = new DocumentoDAO();
        telefono = new TelefonoDAO();
        papeleria = new PapeleriaDAO();
        jornada = new JornadaDAO();
        nivel = new NivelDAO();
        seccion = new SeccionDAO();
        grado = new GradoDAO();
        unidad = new UnidadDAO();
        materia = new MateriaDAO();
        motivoinasistencia = new MotivoInasistenciaDAO();
        Inasistencia = new InasistenciaDAO();
        ciclo = new CicloDAO();
        asignacionAlumno = new AsignacionAlumnoDAO();
        nota = new NotaDAO();
        genero = new GeneroDao();
        producto = new ProductoDAO();
        categoria = new CategoriaDAO();
        estadoProducto = new EstadoProductoDAO();
        formaPago = new FormaPagoDAO();
        movimiento = new MovimientoDAO();
        recibo = new ReciboDAO();
        proveedor = new ProveedorDAO();
        sede = new SedeDAO();
        tipoMovimiento = new TipoMovimientoDAO();
    }
    
    public Producto obtenerProducto(Integer idProducto){
        return producto.obtenerProducto((long) (int) idProducto);
    }
    
    public Boolean ValidarLogin(String Usuario, String Pass){
        if(!"".equals(Usuario) && !"".equals(Pass)){
            Coordinador.Datos = persona.ObtenerDatosUsuario(Usuario, Pass);
            Coordinador.Menus = persona.ObtenerMenus(Usuario, Pass);
            Coordinador.Permisos = persona.ObtenerPermisos(Usuario, Pass);
            return Coordinador.Datos != null && Coordinador.Menus != null && Coordinador.Permisos != null;            
        }else{
            return false;
        }
    }
    
    public String obtenerCorrelativoRecibo(){
        return recibo.obtenerCorrelativoRecibo();
    }
    
    public ArrayList<Genero> ListaGenero(){
        return genero.obtenerGenero();
    }
    
    public ArrayList<String> buscarAlumno(String IdAlumno){
        return persona.buscarAlumno(IdAlumno);
    }
    
    public ArrayList<String> buscarDocumento(String IdPersona){
        Documento Numero = new Documento();
        ArrayList<String> Documento = new ArrayList<>();
        Numero = documento.getDocumento(IdPersona);
        Documento.add(Numero.getTipo());
        Documento.add(Numero.getNumero());
        return Documento;
    }
    
    public ArrayList<TipoDocumento> ListaTipoDocumento(){
        TipoDocumentoDAO tipo = new TipoDocumentoDAO();
        return tipo.ListaTiposDocumentos();
    }
    
    public ArrayList<TipoPapeleria> ListaTipoPapeleria(){
        TipoPapeleriaDAO tipo =  new TipoPapeleriaDAO();
        return tipo.ListaTipoPepeleria();
    }
    
    public DefaultTableModel listaEncargados(){
        DefaultTableModel model = new DefaultTableModel();
        ArrayList<Persona> lista = new ArrayList<>();
        lista = persona.listaEncargados();
        model.setRowCount(0);
        model.setColumnCount(0);
        model.setColumnIdentifiers(Coordinador.TitulosBusquedaEncargado);
        for(int i = 0; i < lista.size(); i++){
            Persona Encargado = new Persona();
            Encargado = lista.get(i);
            Object[] fila = {Encargado.getIdPersona(), Encargado.getPNombre() + " " + Encargado.getSNombre() + " " + Encargado.getPApellido() + " " + Encargado.getSApelido()};
            model.addRow(fila);
        }
        return model;
    }
    
    public DefaultTableModel buscarPapeleria(String IdPersona){
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList<Papeleria> lista = new ArrayList<>();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.setColumnIdentifiers(Coordinador.TitulosPapeleria);
        
        lista = papeleria.buscarPapeleria(IdPersona);
        for(int i = 0; i < lista.size(); i++){
            Papeleria papeleriaPersona = new Papeleria();
            papeleriaPersona = papeleria.buscarPapeleria(IdPersona).get(i);
            Object[] fila = {papeleriaPersona.getIdPapeleria(), papeleriaPersona.getIdTipoPapeleria() + "|" + papeleriaPersona.getTipoPapeleria(), papeleriaPersona.getDescripcion()};
            modelo.addRow(fila);
        }
        return modelo;
    }
    
    public DefaultTableModel obtenerMovimiento(DefaultTableModel modelo){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel modeloFinal = modelo;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        modelo.setRowCount(0);
        try{
            movimiento.obtenerMovimiento(calendar.getTime()).stream().forEach((lista)->{
                Object[] fila = {lista.getIdMovimiento(), formato.format(lista.getFecha()), 
                    tipoMovimiento.obtenerTipoMovimiento(lista.getTipoMovimiento()).getDescripcion(), 
                    producto.obtenerProducto((long) lista.getProducto()).getDescripcion(), 
                    sede.obtenerSede(lista.getSede()).getAgencia(), 
                    proveedor.obtenerProveedor(lista.getProveedor()).getNombre()
                };
                modeloFinal.addRow(fila);
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "StudentControl", JOptionPane.ERROR_MESSAGE);
        }
        return modeloFinal;
    }
    
    public DefaultTableModel obtenerClientes(DefaultTableModel modelo){
        DefaultTableModel modeloFinal = modelo;
        modelo.setRowCount(0);
        try{
            persona.obtenerClientes().stream().forEach((lista)->{
                Object[] fila = {lista.getIdPersona(), lista.getPNombre() + " " + lista.getPApellido(), lista.getDireccion(), telefono.getTelefono(lista.getIdPersona()).getTelefono()};
                modeloFinal.addRow(fila);
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "StudentControl", JOptionPane.ERROR_MESSAGE);
        }
        return modeloFinal;
    }
    
    public DefaultTableModel obtenerProductos(DefaultTableModel modelo){
        DefaultTableModel modeloFinal = modelo;
        modelo.setRowCount(0);
        try{
            producto.obtenerProducto().stream().forEach((lista)->{
                Object[] fila = {lista.getIdProducto(), lista.getDescripcion(), lista.getExistencias(), 
                    categoria.obtenerCategoria(lista.getCategoria()).getDescripcion(), estadoProducto.obtenerEstadoProducto(lista.getEstado()).getDescripcion()};
                modeloFinal.addRow(fila);
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "StudentControl", JOptionPane.ERROR_MESSAGE);
        }
        return modeloFinal;
    }
    
    public String buscarTelefono(String IdPersona){
        Telefono numero = new Telefono();
        numero = telefono.getTelefono(IdPersona);
        return numero.getTelefono();
    }
    
    /**
     * 
     * @param mpersona es un objeto de la clase persona
     * @return true si la operacion se realizo correctamente, false si hubo algun error
     */
    public Boolean guardarPersona(Persona mpersona){
        if(mpersona.getPNombre().equals("") || mpersona.getSNombre().equals("") || mpersona.getPApellido().equals("") || 
                mpersona.getSApelido().equals("") || mpersona.getDireccion().equals("") || mpersona.getGenero() == 0 ||
                mpersona.getRol() == 0 || mpersona.getUsuario().equals("") || mpersona.getPass().equals("") || 
                mpersona.getIdPersona().equals("")){
            JOptionPane.showMessageDialog(null, "Error: Algunos Campos requeridos estan vacios favor revisar", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
                return persona.registrarPersona(mpersona);
        }
    }
    
    public Boolean guardarAlumno(Integer Operacion, Persona Encargado, Persona Alumno, Documento documento, Telefono telefono){
        if(Encargado.getIdPersona().equals("") || Encargado.getPNombre().equals("")|| Encargado.getDireccion().equals("") ||
                Encargado.getGenero() == 0 || Encargado.getRol() == 0 || Encargado.getUsuario().equals("") || Encargado.getPass().equals("") || 
                Alumno.getIdPersona().equals("") || Alumno.getPNombre().equals("") || Alumno.getSNombre().equals("") || 
                Alumno.getPApellido().equals("") || Alumno.getSApelido().equals("") || Alumno.getGenero() == 0 || Alumno.getFechaNacimiento() == null ||
                Alumno.getFechaIngreso() == null){
            JOptionPane.showMessageDialog(null, "Error: Algunos Campos requeridos estan vacios favor revisar", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return persona.registrarAlumno(Operacion, Alumno, Encargado, telefono, documento, Coordinador.Datos.getIdPersona());
        }
    }

    public Boolean operacionesPapeleria(Integer Operacion, Papeleria mPapeleria, Integer IdPapeleria){
        PapeleriaDAO mpapeleria = new PapeleriaDAO();
        switch (Operacion) {
            case 1:
                return mpapeleria.registrarPapeleria(mPapeleria);
            case 2:
                return mpapeleria.modificarPapeleria(mPapeleria);
            case 3:
                return mpapeleria.eliminarPapeleria(IdPapeleria);
            default:
                return false;
        }
    }
    
    public Coordinador getCoordinador() {
        return Coordinador;
    }

    public void setCoordinador(Coordinador Coordinador) {
        this.Coordinador = Coordinador;
    }
    
    /**
     * 
     * @param Item a parsear para obtener el codigo, este debe ser tipo Object
     * @return el codigo del Item ingresado en tipo Integer
     */
    public Integer getCodigo(Object Item){
        int Id = 0;
        String Objeto = String.valueOf(Item);
        StringTokenizer Tokens = new StringTokenizer(Objeto, "|");
        while(Tokens.hasMoreElements()){
            String Valido = Tokens.nextToken();
            if(Valido.matches("\\d{1,4}")){
                Id = Integer.parseInt(Valido);
            }
        }
        return Id;
    }
    
    public String getNombre(Object Item){
        String Nombre = "";
        StringTokenizer Tokens = new StringTokenizer(Item.toString(), "|");
        while(Tokens.hasMoreElements()){
            String Valido = Tokens.nextToken();
            if(Valido.matches("[\\w]+")){
                Nombre = Valido;
            }
        }
        return Nombre;
    }
    
    /**
     * 
     * @param PNombre Primer Nombre de la persona
     * @param PApellido Primer Apellido de la persona
     * @return un array list con el usuario en la primera posicion y la contraseña en la segunda posicion
     */
    public ArrayList<String> crearUsuario(String PNombre, String PApellido){
        String Usuario = "";
        String Pass = "";
        ArrayList<String> Credenciales = new ArrayList<>();
        if(!PNombre.equals("") && !PApellido.equals("")){
            Usuario = PNombre.substring(0, 1) + PApellido;
            Pass = MD5.getMD5("123");
        }
        Credenciales.add(Usuario);
        Credenciales.add(Pass);
        return Credenciales;
    }
    
    /**
     * 
     * @return un Array del Tipo de dato TipoPersona
     */
    public ArrayList<TipoPersona> ListaTipoPersona(){
        TipoPersonaDAO tipo = new TipoPersonaDAO();
        return tipo.ListaTipos();
    }
    
    public ArrayList<Persona> LIstaPersona(){
        PersonaDAO Persona = new PersonaDAO();
        return Persona.ListaPersona();
    }
    
    public Integer getIdRol(Integer IdRol){
        RolDAO rol = new RolDAO();
        return rol.getIdRol(IdRol);
    }
    
    public Integer getCodigoNuevo(){
        return persona.generarCodigo();
    }
    
    public ArrayList<String> obtenerMes(String alumno){
        return persona.obtenerMes(alumno);
    }
    
    public ArrayList<Papeleria> BucarPapeleria(String IdPersona){
        return papeleria.buscarPapeleria(IdPersona);
    }
    
    public Persona buscarPersona(String IdPersona){
        return persona.buscarPersona(IdPersona);
    }
    
    public Movimiento obtenerMovimiento(Integer idMovimiento){
        return movimiento.obtenerMovimiento(idMovimiento);
    }
    
    public DefaultTableModel modeloJornadas(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.setColumnIdentifiers(Coordinador.TitulosJornada);
        try{
            jornada.lista().stream().forEach((Lista)->{
                Object[] fila = {Lista.getIdJornada(), Lista.getDescripcion(), Lista.getEstado() == true ? "Activo" : "Inactivo"};
                modelo.addRow(fila);
            });
        }catch(Exception e){
            
        }
        return modelo;
    }
    
    public DefaultTableModel modeloNivel(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.setColumnIdentifiers(Coordinador.TitulosNivel);
        try{            
            nivel.listaNivel().stream().forEach((Lista)->{
                Object[] fila = {Lista.getIdNivel(), Lista.getDescripcion(), Lista.getEstado() == true ? "Activo" : "Inactivo"};
                modelo.addRow(fila);
            });
        }catch(Exception e){
            
        }
        return modelo;
    }
    
    public Boolean registrarJornada(Jornada mJornada){
        if(!mJornada.getDescripcion().equals("")){
            return jornada.registrarJornada(mJornada, Coordinador.Datos.getIdPersona());
        }else{
            return false;
        }
    }
    
    public Boolean modificarJornada(Jornada mJornada){
        if(mJornada.getIdJornada() != 0 && !mJornada.getDescripcion().equals("")){
            return jornada.modificarJornada(mJornada, Coordinador.Datos.getIdPersona());
        }else{
            JOptionPane.showMessageDialog(null, "Error: algunos campos estan incompletos, Favor verifique", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean registrarNivel(Nivel mNivel){
        if(!mNivel.getDescripcion().equals("")){
            return nivel.registrarNivel(mNivel, Coordinador.Datos.getIdPersona());
        }else{
            JOptionPane.showMessageDialog(null, "Error: algunos campos estan incompletos, Favor verifique", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarNivel(Nivel mNivel){
        if(mNivel.getIdNivel() > 0 && !mNivel.getDescripcion().equals("")){
            return nivel.modificarNivel(mNivel, Coordinador.Datos.getIdPersona());
        }else{
            JOptionPane.showMessageDialog(null, "Error: algunos campos estan incompletos, Favor verifique", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public DefaultComboBoxModel comboJornada(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            jornada.listaActivos().stream().forEach((action) ->{
                modelo.addElement(new ItemComboBox(action.getIdJornada().toString(), action.getDescripcion()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboGenero(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            genero.obtenerGenero().stream().forEach((action) ->{
                modelo.addElement(new ItemComboBox(action.getIdGenero().toString(), action.getDescripcion()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboNivel(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        ArrayList<Nivel> lista = new ArrayList<>();
        try{
            lista = nivel.listaNivelActivos();
            for(int i = 0; i < lista.size(); i++){
                modelo.addElement(new ItemComboBox(String.valueOf(lista.get(i).getIdNivel()), lista.get(i).getDescripcion()));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboSeccion(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            seccion.listaSecciones().stream().forEach((lista) -> {
                modelo.addElement(new ItemComboBox(lista.getIdSeccion().toString(), lista.getDescripcion()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboEstadoProducto(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            estadoProducto.obtenerEstadoProducto().stream().forEach((lista) -> {
                modelo.addElement(new ItemComboBox(lista.getIdEstado().toString(), lista.getDescripcion()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboCategoria(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            categoria.obtenerCategoria().stream().forEach((lista) -> {
                modelo.addElement(new ItemComboBox(lista.getIdCategoria().toString(), lista.getDescripcion()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultTableModel tablaGrado(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.setColumnIdentifiers(Coordinador.TitulosGrado);
        try{
            grado.listaGrados().stream().forEach((mgrado) ->{
                Object[] fila = {
                    mgrado.getIdGrado(),
                    mgrado.getDescripcion(),
                    nivel.obtenerNivel(mgrado.getNivel()).getDescripcion(),
                    seccion.obtenerSeccion(mgrado.getSeccion()).getDescripcion(),
                    jornada.obtenerJornada(mgrado.getJornada()).getDescripcion(),
                    mgrado.getEstado() == true ? "Activo" : "Inactivo"
                };
                modelo.addRow(fila);
            });            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public Boolean registrarGrado(Grado mgrado){
        if(!mgrado.getDescripcion().equals(null) || !mgrado.getNivel().equals(null) || !mgrado.getJornada().equals(null) || !mgrado.getSeccion().equals(null)){
            return grado.registrarGrado(mgrado, Coordinador.Datos.getIdPersona());
        }else if(mgrado.getDescripcion().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe definir el grado a guardar", "Student Control", JOptionPane.ERROR_MESSAGE );
            return false;
        }else if(mgrado.getNivel().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe definir el Nivel del grado a guardar", "Student Control", JOptionPane.ERROR_MESSAGE );
            return false;
        }else if(mgrado.getJornada().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe definir la Jornada del grado a guardar", "Student Control", JOptionPane.ERROR_MESSAGE );
            return false;
        }else if(mgrado.getSeccion().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe definir la Seccion del grado a guardar", "Student Control", JOptionPane.ERROR_MESSAGE );
            return false;
        }else{
            return false;
        }
    }
    
    public Boolean modificarGrado(Grado mgrado){
        if(!mgrado.getIdGrado().equals(null) ||!mgrado.getDescripcion().equals(null) || !mgrado.getNivel().equals(null) || !mgrado.getJornada().equals(null) || !mgrado.getSeccion().equals(null)){
            return grado.modificarGrado(mgrado, Coordinador.Datos.getIdPersona());
        }else if(mgrado.getDescripcion().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe definir el grado a guardar", "Student Control", JOptionPane.ERROR_MESSAGE );
            return false;
        }else if(mgrado.getNivel().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe definir el Nivel del grado a guardar", "Student Control", JOptionPane.ERROR_MESSAGE );
            return false;
        }else if(mgrado.getJornada().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe definir la Jornada del grado a guardar", "Student Control", JOptionPane.ERROR_MESSAGE );
            return false;
        }else if(mgrado.getSeccion().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe definir la Seccion del grado a guardar", "Student Control", JOptionPane.ERROR_MESSAGE );
            return false;
        }else{
            return false;
        }
    }
    
    public Boolean registrarUnidad(Unidad mUnidad){
        if(!mUnidad.getDescripcion().equals(null)){
            return unidad.registrarUnidad(mUnidad, Coordinador.Datos.getIdPersona());
        }else{
            JOptionPane.showMessageDialog(null, "Error: Debe Ingresar una descripcion para la Unidad", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarUnidad(Unidad mUnidad){
        if(!mUnidad.getDescripcion().equals(null) && !mUnidad.getIdUnidad().equals(null)){
            return unidad.modificarUnidad(mUnidad, Coordinador.Datos.getIdPersona());
        }else if(mUnidad.getDescripcion().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: Debe Ingresar una descripcion para la Unidad", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            JOptionPane.showMessageDialog(null, "Error: Debe Ingresar un Codigo para la Unidad", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    /**
     *
     * @param recibo
     * @param detalle
     * @param detallePago
     * @return
     */
    public Boolean registrarRecibo(Recibo recibo, List<Detalle> detalle, DetallePagoRecibo detallePago){
        return this.recibo.registrarRecibo(recibo, detalle, detallePago, Integer.parseInt(Coordinador.Datos.getIdPersona()));
    }
    
    public DefaultTableModel tablaUnidad(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.setColumnIdentifiers(Coordinador.TitulosUnidad);
        try{
            unidad.listaUnidades().stream().forEach((lista) ->{
                Object[] fila = {lista.getIdUnidad(), lista.getDescripcion()};
                modelo.addRow(fila);
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultTableModel tablaMaterias(Integer Grado){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.setColumnIdentifiers(Coordinador.TitulosMateria);
        try{
            materia.listaMaterias(Grado).stream().forEach((lista) -> {
                Object[] fila = {
                    lista.getIdMateria(),
                    lista.getDescripcion(),
                    grado.obtenerGrado(lista.getGrado()).getDescripcion(),
                    lista.getEstado() == true ? "Activo" : "Inactivo"
                };
                modelo.addRow(fila);
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public Boolean registrarMateria(Materia mMateria){
        if(!mMateria.getDescripcion().equals(null)){
            return materia.registrarMateria(mMateria, Coordinador.Datos.getIdPersona());
        }else{
            JOptionPane.showMessageDialog(null, "Error: Debe Ingresar una descripcion para la materia", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarMateria(Materia mMateria){
        if(!mMateria.getDescripcion().equals(null)){
            return materia.modificarMateria(mMateria, Coordinador.Datos.getIdPersona());
        }else{
            JOptionPane.showMessageDialog(null, "Error: Debe Ingresar una descripcion para la materia", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public DefaultComboBoxModel comboGrado(Integer Jornada, Integer Seccion, Integer Nivel){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            grado.listaGradosActivos(Jornada, Seccion, Nivel).stream().forEach((lista) ->{
                modelo.addElement(new ItemComboBox(lista.getIdGrado().toString(), lista.getDescripcion()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboFormaPago(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            formaPago.obtenerFormaPago().stream().forEach((lista) ->{
                modelo.addElement(new ItemComboBox(lista.getIdFormaPago().toString(), lista.getDescripcion()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public Grado obtenerGrado(Integer Materia){
        Materia mMateria = new Materia();
        mMateria = materia.obtenerMateria(Materia);
        return grado.obtenerGrado(mMateria.getGrado());
    }
    
    public Boolean registrarMotivoInasistencia(MotivoInasistencia motivo){
        if(!motivo.getDescripcion().equals(null)){
            return motivoinasistencia.registrarMotivoInasistencia(motivo, Coordinador.Datos.getIdPersona());
        }else{
            JOptionPane.showMessageDialog(null, "Error: Debe Ingresar una Descripcion para el motivo de Inasistencia", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarMotivoInasistencia(MotivoInasistencia motivo){
        if(!motivo.getDescripcion().equals(null) && !motivo.getIdMotivoInasistencia().equals(null)){
            return motivoinasistencia.modificarMotivoInasistencia(motivo, Coordinador.Datos.getIdPersona());
        }else if(motivo.getDescripcion().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: Debe Ingresar una Descripcion para el motivo de inasistencia", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(motivo.getIdMotivoInasistencia().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe ingresar un Id para el motivo de insasistencia", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            JOptionPane.showMessageDialog(null, "Error: el motivo de inasistencia debe contar con una Descripcion y un Id", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public DefaultTableModel tablaMotivoInasistencia(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        modelo.setColumnIdentifiers(Coordinador.TitulosMotivoInasistencia);
        try{
            motivoinasistencia.ListaMotivos().stream().forEach((lista) ->{
                Object[] fila = {lista.getIdMotivoInasistencia(), lista.getDescripcion()};
                modelo.addRow(fila);
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public MotivoInasistencia obtenerMotivoInasistencia(Integer IdMotivo){
        return motivoinasistencia.obtenerMotivoInasistencia(IdMotivo);
    }
    
    public Boolean registrarInasistencia(Inasistencia Inasistencias){
        if(!Inasistencias.getFechaInasistencia().equals(null) && !Inasistencias.getPersona().equals(null) && !Inasistencias.getMotivoInasistencia().equals(null)){
            return Inasistencia.registrarInasistencia(Inasistencias, Coordinador.Datos.getIdPersona());
        }else if(Inasistencias.getFechaInasistencia().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe especificar la fecha de la Inasistencia", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(Inasistencias.getPersona().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe especificar el alumno", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(Inasistencias.getMotivoInasistencia().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe especificar el motivo de la Inasistencia", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            JOptionPane.showMessageDialog(null, "Error: Faltan algunos campos por completar", "Student Contro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public Boolean modificarInasistencia(Inasistencia Inasistencias){
        if(!Inasistencias.getFechaInasistencia().equals(null) && !Inasistencias.getPersona().equals(null) && !Inasistencias.getMotivoInasistencia().equals(null)){
            return Inasistencia.modificarInasistencia(Inasistencias, Coordinador.Datos.getIdPersona());
        }else if(Inasistencias.getFechaInasistencia().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe especificar la fecha de la Inasistencia", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(Inasistencias.getPersona().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe especificar el alumno", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(Inasistencias.getMotivoInasistencia().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: debe especificar el motivo de la Inasistencia", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            JOptionPane.showMessageDialog(null, "Error: Faltan algunos campos por completar", "Student Contro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public DefaultTableModel tablaInasistencias(String Alumno){
        DefaultTableModel modelo = new DefaultTableModel();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.setColumnIdentifiers(Coordinador.TitulosInasistencias);
        try{
            Inasistencia.listaInasistencia(Alumno).stream().forEach((lista) ->{
                Object[] fila = {
                    lista.getIdInasistencia(),
                    formato.format(lista.getFechaInasistencia()),
                    persona.buscarPersona(lista.getPersona()).getPNombre() + " " + persona.buscarPersona(lista.getPersona()).getPApellido(),
                    obtenerMotivoInasistencia(lista.getMotivoInasistencia()).getDescripcion()
                };
                modelo.addRow(fila);
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public Inasistencia obtenerInasistencia(Integer IdInasistencia){
        return Inasistencia.obtenerInasistencia(IdInasistencia);
    }
    
    public DefaultComboBoxModel listaMotivosInasistencia(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            motivoinasistencia.ListaMotivos().stream().forEach((lista) -> {
                modelo.addElement(new ItemComboBox(lista.getIdMotivoInasistencia().toString(), lista.getDescripcion()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultTableModel tblAlumnos(){
        DefaultTableModel modelo = new DefaultTableModel();
        try{
            modelo.setRowCount(0);
            modelo.setColumnCount(0);
            modelo.setColumnIdentifiers(Coordinador.TitulosAlumnos);
            LIstaPersona().stream().forEach((Lista) -> {
               Object[] fila = {Lista.getIdPersona(), Lista.getPApellido() + " " + Lista.getPNombre()};
                modelo.addRow(fila);
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public Ciclo obtenerCicloActivo(){
        return ciclo.obtenerCicloActivo();
    }
    
    public Ciclo obtenerCicloActivo(String Ciclo){
        return ciclo.buscarCiclo(Ciclo);
    }
    
    public DefaultTableModel tblAsignacionAlumno(Integer Grado){
        DefaultTableModel modelo = new DefaultTableModel();
        DecimalFormat format = new DecimalFormat("'Q'#######.##");
        SimpleDateFormat formatFecha = new SimpleDateFormat("dd/MM/yyyy");
        try{
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            modelo.setColumnIdentifiers(Coordinador.TitulosAsignacionALumno);
            asignacionAlumno.listaAsignaciones(Grado).stream().forEach((lista) ->{ 
                Object[] fila = {
                    lista.getIdAsignacion(),
                    lista.getPersona(), 
                    buscarPersona(lista.getPersona()).getPNombre() + " " + buscarPersona(lista.getPersona()).getPApellido(),
                    formatFecha.format(lista.getFechaAsignacion()),
                    format.format(lista.getInscripcion()),
                    format.format(lista.getMensualidad())
                };
                modelo.addRow(fila);
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public Boolean registrarAsignacionAlumno(AsignacionAlumno Asignacion){
        if(!Asignacion.getIdAsignacion().equals(null) || !Asignacion.getInscripcion().equals(null) || !Asignacion.getInscripcion().equals(null)){
            return asignacionAlumno.registrarAsignacion(Asignacion, Coordinador.Datos.getIdPersona());
        }else if(Asignacion.getIdAsignacion().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: Debe Ingresar un Id para la Asignacion", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(Asignacion.getMensualidad().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un valor para la mensualidad", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(Asignacion.getInscripcion().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: Debe ingersar un valor para la inscripcion", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return false;
        }
    }
    
    public Boolean modificarAsignacionAlumno(AsignacionAlumno mAsignacion){
        if(!mAsignacion.getIdAsignacion().equals(null) || !mAsignacion.getInscripcion().equals(null) || !mAsignacion.getInscripcion().equals(null)){
            return asignacionAlumno.modificarAsignacion(mAsignacion, Coordinador.Datos.getIdPersona());
        }else if(mAsignacion.getIdAsignacion().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: Debe Ingresar un Id para la Asignacion", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(mAsignacion.getMensualidad().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un valor para la mensualidad", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(mAsignacion.getInscripcion().equals(null)){
            JOptionPane.showMessageDialog(null, "Error: Debe ingersar un valor para la inscripcion", "Student Control", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            return false;
        }
        
    }
    
    public AsignacionAlumno buscarAsignacion(String Persona, Integer Ciclo){
        if(!Persona.equals("") && Ciclo > 0){
            return asignacionAlumno.buscarAsignacion(Persona, Ciclo);
        }else if(Persona.equals("")){
            JOptionPane.showMessageDialog(null, "Error: Debe especificar un Alumno para la busqueda", "Student Control", JOptionPane.ERROR_MESSAGE);
            return null;
        }else if(Ciclo <= 0){
            JOptionPane.showMessageDialog(null, "Error: Debe Especificar un Grado para la busqueda", "Student Control", JOptionPane.ERROR_MESSAGE);
            return null;
        }else{
            return null;
        }
    }
    
    public DefaultComboBoxModel comboUnidad(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            unidad.listaUnidades().stream().forEach((unidad)->{
                modelo.addElement(new ItemComboBox(String.valueOf(unidad.getIdUnidad()), unidad.getDescripcion()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboMateria(Integer Grado){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            materia.listaMaterias(Grado).stream().forEach((materia) ->{
                modelo.addElement(new ItemComboBox(String.valueOf(materia.getIdMateria()), materia.getDescripcion()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboAlumno(Integer Ciclo, Integer Grado, Integer Unidad, Integer Materia){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            persona.ListaAlumnos(Grado, Ciclo, Unidad, Materia).stream().forEach((alumno)->{
                modelo.addElement(new ItemComboBox(String.valueOf(alumno.getIdPersona()), alumno.getPNombre() + " " + alumno.getSApelido()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboAlumno(Integer Grado){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            persona.obtenerAlumnos(Grado).stream().forEach((alumno)->{
                modelo.addElement(new ItemComboBox(String.valueOf(alumno.getIdPersona()), alumno.getPNombre() + " " + alumno.getSApelido()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboProducto(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            this.producto.obtenerProducto().stream().forEach((lista)->{
                modelo.addElement(new ItemComboBox(String.valueOf(lista.getIdProducto()), lista.getDescripcion()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboProveedor(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            proveedor.obtenerProveedor().stream().forEach((lista)->{
                modelo.addElement(new ItemComboBox(String.valueOf(lista.getIdProveedor()), lista.getNombre()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboSede(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            sede.obtenerSede().stream().forEach((lista)->{
                modelo.addElement(new ItemComboBox(String.valueOf(lista.getIdAgencia()), lista.getAgencia()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel comboTipoMovimiento(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            tipoMovimiento.obtenerTipoMovimiento().stream().forEach((lista)->{
                modelo.addElement(new ItemComboBox(String.valueOf(lista.getIdTipoMovimiento()), lista.getDescripcion()));
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
    public Boolean registrarNota(Notas nuevaNota){
        if(nuevaNota.getMateria() != null && !nuevaNota.getPersona().equals("") && nuevaNota.getTotal() != null &&
           nuevaNota.getUnidad() != null && nuevaNota.getZona() != null && nuevaNota.getCiclo() != null && nuevaNota.getExamen() != null){
            return nota.registrarNota(nuevaNota, Coordinador.Datos.getIdPersona());
        }else{
            return false;
        }
    }
    
    public Boolean modificarNota(Notas nuevaNota){
        if(nuevaNota.getMateria() != null && !nuevaNota.getPersona().equals("") && nuevaNota.getTotal() != null &&
           nuevaNota.getUnidad() != null && nuevaNota.getZona() != null && nuevaNota.getCiclo() != null && nuevaNota.getExamen() != null){
            return nota.modificarNota(nuevaNota, Coordinador.Datos.getIdPersona());
        }else{
            return false;
        }
    }
    
    public Boolean registrarClientes(Persona persona, Telefono telefono){
        return this.persona.registrarCliente(persona, telefono, Coordinador.Datos.getIdPersona());
    }
    
    public Boolean modificarClientes(Persona persona, Telefono telefono){
        return this.persona.modificarCliente(persona, telefono, Coordinador.Datos.getIdPersona());
    }
    
    public Boolean registrarProductos(Producto producto){
        return this.producto.registrarProducto(producto, Coordinador.Datos.getIdPersona());
    }
    
    public Boolean modificarProductos(Producto producto){
        return this.producto.modificarProducto(producto, Coordinador.Datos.getIdPersona());
    }
    
    public Movimiento obtenerPrecioActual(int producto){
        return movimiento.obtenerPrecioActual(producto);
    }
    
    public Boolean registrarMovimiento(Movimiento movimiento){
        return this.movimiento.registrarMovimiento(movimiento, Coordinador.Datos.getIdPersona());
    }
    
    public DefaultTableModel buscarNotas(String Alumno, Integer Unidad){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        modelo.setColumnIdentifiers(Coordinador.TitulosModificarNota);
        try{
            nota.notasAlumno(Alumno, Unidad).stream().forEach((lista) ->{
                Object[] fila = {
                    lista.getIdNota(),
                    materia.obtenerMateria(lista.getMateria()).getIdMateria(),
                    materia.obtenerMateria(lista.getMateria()).getDescripcion(), 
                    lista.getExamen(), 
                    lista.getZona(), 
                    lista.getTotal()};
                modelo.addRow(fila);
            });
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Student Control", JOptionPane.ERROR_MESSAGE);
        }
        return modelo;
    }
    
}
