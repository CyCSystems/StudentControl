package com.cycsystemsgt.student_control.util;

// Librerias para la Elaboracion de Menus
import com.sun.media.jfxmedia.logging.Logger;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//Librerias para las Teclas de Acceso Rapido
import javax.swing.KeyStroke;
//Librerias de la Interfaz
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
//Librerias de la lista ordenada por clave
import java.util.Hashtable;

//Clase Menu
public class Menu extends JMenuBar implements ActionListener {
	private final String vtOpc[][]; // Matriz de Opciones
	private String MetodoAccion = ""; //Nombre del Metodo Acciones
	private final int LonOpc; // Numero de Filas de la matriz de Opciones
	
	//Contructor de la Clase Menu
	public Menu(String vtOpcPar[][], String MetAccion){
		//Asignacion de parametros y variables de instancia
		vtOpc = vtOpcPar;
		MetodoAccion = MetAccion;
		LonOpc = vtOpc.length;
		
		/* Definicion de la orientacion y aspecto del menu.
			Necesaria para que opciones de accion directamente
			Colocadas en la barra de menus restrinjan su tamaño
			al minimo*/
		setLayout(new FlowLayout(FlowLayout.LEFT));
		//Definicion de la lista que contendra los objectos del menu
		Hashtable Lista = new Hashtable();
		//Encontrando los tipos de objectos y llenando la lista con Ellos
		JMenu tmpMenu;
		JMenuItem tmpItem;
		for(int i=0; i<LonOpc; i++){
			if(TieneHijos(vtOpc[i][0])){
				//si tiene hijos, debe ser un submenu
				tmpMenu = new JMenu(vtOpc[i][0]);
				//El nombre del objeto es la clave de la opciones
				tmpMenu.setName(vtOpc[i][0]);
				//El texto que se mostrara va sin el señalador del 
				//mnemonico
				tmpMenu.setText(QuitaCar(vtOpc[i][1], '_'));
				//El mnemonico se asigna como el caracter despues del
				//señalador
				tmpMenu.setMnemonic(
					EncuentraMnemonico(vtOpc[i][1], '_'));
				//se agrega el objeto a la lista, ordenado por su clave
				Lista.put(vtOpc[i][0], tmpMenu);
			} else {
				//si no, debe ser una opcion de accion
				tmpItem = new JMenuItem(vtOpc[i][0]);
				//El nombre del objeto es la clave de la opcion
				tmpItem.setName(vtOpc[i][0]);
				//El Texto que se mostrara va sin el señalador del
				//mnemonico
				tmpItem.setText(QuitaCar(vtOpc[i][1], '_'));
				//El mnemonico se asigna como el caracter despues del
				//señadador
				char Nemonico = EncuentraMnemonico(vtOpc[i][1], '_');
				tmpItem.setMnemonic(Nemonico);
				//La tecla de aceleracion es el mismo mnemonico
				tmpItem.setAccelerator(KeyStroke.getKeyStroke(
					Nemonico, ActionEvent.ALT_MASK));
				//El Comando de accion del objeto es tambien la clave
				//de la opcion
				tmpItem.setActionCommand(vtOpc[i][0]);
				//Este es de acciones po lo que debe ser escuchado por el sistema
				tmpItem.addActionListener(this);
				//se agrega el objeto a la lista, ordenado por su clave
				Lista.put(vtOpc[i][0], tmpItem);
			}
		}
		String IdPapa;
		//Variable temporal uitlizada solo para la comparacion de clases
		JMenu tmpMenuPrb = new JMenu();
		//Conectando los objetos de la lista de acuerdo con las jerarquias establecidas
		for(int i=0; i<LonOpc; i++){
			if(EsPrincipal(vtOpc[i][0])){
				/*Si es una opcion principal, no tiene padre y se agrega a
				la barra de menus. Dependiendo del tipo de objeto se recupera
				de la lista por su clave*/
				if(Lista.get(vtOpc[i][0]).getClass() == tmpMenuPrb.getClass()){
					add((JMenu) Lista.get(vtOpc[i][0]));
				}else{
					add((JMenuItem) Lista.get(vtOpc[i][0]));
				}
			} else{
				/* si no, tiene un padre. Dependiendo del tipo de Objecto
				se recupera de la lista por su clave y se anexa al padre
				encontrado*/
				IdPapa = vtOpc[i][0].substring(0, vtOpc[i][0].length()-1);
				tmpMenu = (JMenu) Lista.get(IdPapa);
				if(Lista.get(vtOpc[i][0]).getClass() == tmpMenuPrb.getClass()){
                                        Logger.logMsg(Logger.INFO, Lista.get(vtOpc[i][0]) + " Contador: " + i);
					tmpMenu.add((JMenu) Lista.get(vtOpc[i][0]));
				}else{
					tmpMenu.add((JMenuItem) Lista.get(vtOpc[i][0]));
				}
			}
		}
	} // Fin del Contructor Menu
	
	/* Metodo que determina, dada la clave de una opcion,
		si esta tiene suopciones*/
	private boolean TieneHijos(String Item){
		/* Cuenta el numero de veces que aparece la clave dada iniciando
			otras claves. si esta aparece mas de una vez, la opcion tene
			subopciones*/
		int NVeces = 0;
		int LonItem = Item.length();
		for(int i=0; i<LonOpc; i++){
			if(vtOpc[i][0].length() >= LonItem){
				if(vtOpc[i][0].substring(0, LonItem).equals(Item)){
					NVeces++;
					if(NVeces > 1){
						return true;
					}
				}
			}
		}
		return (NVeces > 1);
	}// Fin de TieneHijos
	
	/*Metodo que determina, dada la clave de una opcion,
	si esta pertenece a la barra de menus*/
	private boolean EsPrincipal(String Item){
		//en la barra de menus se esperan claves de un solo digito
		return(Item.length() == 1);
	}//fin del EsPrincipal
	
	/* Metodo de proposito general que quita un caracter especifico
	de una cadena*/
	private String QuitaCar(String Cad, char c){
		int Pos = Cad.indexOf(c);
		int Lon = Cad.length();
		if(Pos != -1){
			//si esta el caracter
			if(Pos == 0){
				return Cad.substring(0, Lon-1);
			}else{
				return Cad.substring(0, Pos) + Cad.substring(Pos+1, Lon);
			}
		}
		return Cad;
	}//Fin de QuitaCar
	
	/*Metodo que retorna el caracter siguiente al señalado,
	entendiendo que dicho caracter es el mnemonico de una 
	opcion de menu*/
	private char EncuentraMnemonico(String Cad, char c){
		int Pos = Cad.indexOf(c);
		if(Pos >= Cad.length()-1){
			/* el señalador de mnemonico no debe ser el ultimo caracter
			de la cadena*/
			return 0;
		}
		return Cad.charAt(Pos+1);
	}//Fin de EncuentraMnemonico
	
	/* Metodo para la resolucion de las acciones en respuesta a
	los eventos de Menu que esten siendo escuchados*/
        @Override
	public void actionPerformed(ActionEvent e){
		try{
			/* si el contexto en que se utiliza el objeto menu es
			una ventana, dentro de la cual hay una barra de menus
			extendiendo la barra Menu, el objecto que instancia
			la clase esta en la tercera generacion. Si este no es el
			caso, habla que alterar la instruccion, referenciando
			el objeto padre en la generacion correcta*/
			Object objPapa = getParent().getParent().getParent();
			Class MiPapa = getParent().getParent().getParent().getClass();
			/*Estableciendo que los parametros del metodo de acciones
			en la clase que llama a Menu son de tipo String y Pasando 
			como argumento a dicho metodo la clave de la opcion seleccionada*/
			Class[] TiposParametros = new Class[] {String.class};
			Object[] argumentos = new Object[] {e.getActionCommand()};
			/*Definiendo el metodo de acciones de la clase que llama
			a Menu y sus parametros para luego invocarlo
			ocasionando su ejecucion*/
			Method target = objPapa.getClass().getMethod(MetodoAccion, TiposParametros);
			Object param[] = {e.getActionCommand()};
			target.invoke(objPapa, argumentos);
			
		}catch(      NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
			ex.printStackTrace();
		}
	}//Fin de actionPerformed
}//fin de la clase Menu