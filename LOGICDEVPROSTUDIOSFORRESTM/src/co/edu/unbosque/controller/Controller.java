package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.model.Emisora;
import co.edu.unbosque.model.EmisoraDTO;
import co.edu.unbosque.model.Parrilla;
import co.edu.unbosque.model.ParrillaDTO;
import co.edu.unbosque.model.Pista;
import co.edu.unbosque.model.PistaDTO;
import co.edu.unbosque.model.ReproductorMP3;
import co.edu.unbosque.model.persistence.EmisoraDAO;
import co.edu.unbosque.view.View;
/**
 * La clase Controller implementa un controlador para la aplicación de gestión de emisoras de radio.
 * Controla las acciones del usuario y la lógica de negocio asociada.
 */
public class Controller implements ActionListener {

	private EmisoraDTO emisoraDTO;
	private static Boolean state;
	private static String name;
	private ParrillaDTO parrillaDTO;
	private static String emisora_v;
	private PistaDTO pistaDTO;
	private static Emisora emisora;
	private JFileChooser fileChooser;
	private static boolean fileAdd;
	private static boolean isComplete;
	private FileNameExtensionFilter filter;
    private File newFile;
	private Parrilla parrilla;
	private Pista pista;
	private ReproductorMP3 mp3;
	
	private static View pf;
 // Declaración de variables de instancia
    
    /**
     * Constructor de la clase Controller.
     * Inicializa los componentes necesarios y establece los listeners de eventos.
     */
	public Controller() {

		initComponents();
	}
	/**
     * Inicializa los componentes de la interfaz gráfica y establece los listeners de eventos.
     */
	private void initComponents() { 
		
		emisoraDTO = new EmisoraDTO();
		pistaDTO = new PistaDTO();
		parrillaDTO = new ParrillaDTO();

		pf = new View();
		pf.getPp().getEmisora_btn().addActionListener(this);
		pf.getPp().getPista_btn().addActionListener(this);
		pf.getPp().getParrilla_btn().addActionListener(this);
		pf.getVp().getGenero_cbx().addActionListener(this);
		pf.getVp().getBack_btn().addActionListener(this);
		pf.getCp().getFile_btn().addActionListener(this);
		pf.getCp().getAdd_btn().addActionListener(this);
		pf.getCp().getBack_btn().addActionListener(this);
		pf.getAp().getAdd_btn().addActionListener(this);
		pf.getAp().getBack_btn().addActionListener(this);
		pf.getVp().getAgregar_btn().addActionListener(this);
		pf.getVp().getEjecutar_btn().addActionListener(this);
		pf.getVr().getBack_btn().addActionListener(this);
		pf.getVr().getBack_btn().addActionListener(this);
		pf.getVr().getGenero_cbx().addActionListener(this);
		pf.getVr().getRep_btn().addActionListener(this);
		pf.getVr().getNext_btn().addActionListener(this);
		
		
		pf.repaint();
	}
	
	
	
	/**
     * Método invocado cuando se realiza una acción, como hacer clic en un botón.
     * @param e El evento de acción generado.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
	      // Lógica para manejar diferentes acciones según el comando de acción
        // Switch-case para determinar la acción y ejecutar la lógica correspondiente
   
		System.out.println(e.getActionCommand());
		
		
		switch(e.getActionCommand()) {
		
		case "Emisora":
			pf.getPp().setVisible(false);
			pf.getAp().setVisible(true);
			pf.repaint();
			break;
			
		case "addEmisora":
			guardarEmisora();
			break;
		case "backEmisora":
			pf.getPp().setVisible(true);
			pf.getAp().setVisible(false);
			pf.repaint();
			break;
		case "Pista":
			pf.getPp().setVisible(false);
			pf.getCp().setVisible(true);
			pf.repaint();
			break;
			
		case "backPista":
			pf.getPp().setVisible(true);
			pf.getCp().setVisible(false);
			pf.repaint();
			break;
		
		case "addFile":
			if(dataComplete()==true) {
				addFile();
			}
			break;
			
		case "addPista":
				addPista();
		break; 
		
		case "Parrilla":
			pf.getVp().getGenero_cbx().setModel(new DefaultComboBoxModel<>());
			
			emisoraDTO.getEmisora_dao().mostrarA(emisoraDTO.getFileEmisoraProp());
			for(Emisora em : emisoraDTO.getEmisora()) {
				pf.getVp().getGenero_cbx().addItem(em.getNombre());
			}
			pf.getPp().setVisible(false);
			pf.getVp().setVisible(true);

	
			break;
		
		case "backEjecucion":
			pf.getVr().getGenero_cbx().setModel(new DefaultComboBoxModel<>());
			pf.getVr().repaint();
			
			emisoraDTO.getEmisora_dao().mostrarA(emisoraDTO.getFileEmisoraProp());
			for(Emisora em : emisoraDTO.getEmisora()) {
				pf.getVp().getGenero_cbx().addItem(em.getNombre());
			}
			if(state==true) {
			
				mp3.stop();
			}
			pf.getVr().setVisible(false);
			pf.getVp().setVisible(false);
			pf.getPp().setVisible(true);
			break;
			
		case "ComboBox":
			cargarCBX();
			break;
		
		case "agregarParrilla":
				addParrilla();
				pf.getVp().repaint();
				pf.repaint();
			break;
		
		case "backParrilla":
		
			pf.getVp().setVisible(false);
			pf.getPp().setVisible(true);
			pf.repaint();
			break;
			
		     
		case "ejecutarParrilla":
			state=false;
			name="";
			pf.getVr().getGenero_cbx().setModel(new DefaultComboBoxModel<>());
			pf.getVr().repaint();
			
			if (pf.getVp().getMusica_cbx().getSelectedIndex() == -1) {
			    JOptionPane.showMessageDialog(null, "No hay pistas para esta emisora.", "Error", JOptionPane.ERROR_MESSAGE);
			    pf.getVp().setVisible(false);
				pf.getPp().setVisible(true);
			}else {
				emisoraDTO.getEmisora_dao().mostrarA(emisoraDTO.getFileEmisoraProp());
				parrillaDTO.getParrilla_dao().mostrarA(parrillaDTO.getFileParrillaProp());
				for(Emisora em : emisoraDTO.getEmisora()) {
					for(Parrilla p : parrillaDTO.getParrilla()) {
					if	(p.getEmisora().equals(em.getNombre())){
						agregarCBX(p.getEmisora());
						pf.repaint();
						}
					}
				
				}
			
				pf.getVp().setVisible(false);
				pf.getVr().setVisible(true);
			}
			
			
			break;
		
		case "ComboBoxP":
			cargarRep();
			pf.getVr().repaint();
			break;
	
		
		
		case "startParrilla":
			if(parrillaDTO.getParrilla().isEmpty()==false) {
				for(Parrilla p :parrillaDTO.getParrilla() ) {
					if(p.getEmisora().equals(pf.getVr().getGenero_cbx().getSelectedItem().toString())) {
						System.out.println(pf.getVr().getGenero_cbx().getSelectedItem().toString());
							parrillaDTO.getRep().add(p);
					}
				}
				
				mp3 = new ReproductorMP3(parrillaDTO.getRep());
				mp3.stop();
				state=mp3.playCurrentSong();
			}else {
				JOptionPane.showMessageDialog(null, "Debe cargar la parrilla antes de ejecutar.", "Error", JOptionPane.ERROR_MESSAGE);
				pf.getVp().setVisible(false);
				pf.getPp().setVisible(true);
				pf.repaint();
			}

			break;
			
		case "nextParrilla":
			mp3.stop();
			mp3.playNextSong();
			break;
			
		
		}
			
			
			
	
	
	}
	
	 private void agregarCBX(String emisora2) {
		if (name.equals(emisora2)) {
			
		}else {
			name=emisora2;
			pf.getVr().getGenero_cbx().addItem(name);
		}
		
	}
	/**
     * Método para limpiar los campos de entrada de datos en la interfaz de usuario.
     */
	private void limpiarData() {

		pf.getCp().getAutor_txt().setText("");;
		pf.getCp().getPista_txt().setText("");
		pf.getAp().getEmisora_txt().setText("");;
		
	}


	 /**
     * Método para cargar la información de una emisora seleccionada en la interfaz de usuario.
     */

	private void cargarRep() {
		pf.getVp().getMusica_cbx().setModel(new DefaultComboBoxModel<>());
		parrillaDTO.getParrilla_dao().mostrarA(parrillaDTO.getFileParrillaProp());
		for(Parrilla p : parrillaDTO.getParrilla()) {
			if(p.getEmisora().equals(	pf.getVr().getGenero_cbx().getSelectedItem().toString())) {
				pf.getVr().getTxa_musica().setText(p.toString());
				pf.repaint();
			}
		}
		
	}

	private void addPista() {

		if(dataComplete()==true) {
			if(fileAdd==true) {
			guardarPista();
		}else {
			JOptionPane.showMessageDialog(null, "Debe guardar el archivo primero.", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
		
	}
	/**
     * Método para cargar las opciones disponibles en un JComboBox basado en la selección de otro JComboBox.
     */
	private void cargarCBX() {
		pf.getVp().getTxa_musica().setText(" ");
		pf.getVp().getMusica_cbx().setModel(new DefaultComboBoxModel<>());
		
		
		
		pistaDTO.getPista_dao().mostrarA(pistaDTO.getFilePistaProp());
		System.out.println(pf.getVp().getGenero_cbx().getSelectedItem().toString());
		emisora_v =pf.getVp().getGenero_cbx().getSelectedItem().toString();
		emisoraDTO.getEmisora_dao().mostrarA(emisoraDTO.getFileEmisoraProp());
		for(Emisora em: emisoraDTO.getEmisora()) {
			if(em.getNombre().equals(pf.getVp().getGenero_cbx().getSelectedItem().toString())) {
				for(Pista p: pistaDTO.getPista()) {
					if(p.getGenero().equals(em.getTipo())){
						
						pf.getVp().getMusica_cbx().addItem(p.getNombre());
												
					}
			}
		};
		}
	}
	/**
     * Método para agregar una nueva parrilla de programación en la base de datos.
     */
	private void addParrilla() {
		if(pf.getVp().getMusica_cbx().getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(null, "Debe cargar la parrilla antes de ejecutar.", "Error", JOptionPane.ERROR_MESSAGE);
			pf.getVp().setVisible(false);
			pf.getPp().setVisible(true);
			pf.repaint();
		}else {
			for (Pista p :pistaDTO.getPista()) {
				if(p.getNombre().equals(pf.getVp().getMusica_cbx().getSelectedItem().toString())) {
					parrilla = new Parrilla(pf.getVp().getGenero_cbx().getSelectedItem().toString(),p.getNombre(),p.getArchivo());
					parrillaDTO.getParrilla_dao().agregar(parrillaDTO.getParrilla(), parrillaDTO.getFileParrillaProp(),parrilla );
					pf.getVp().getTxa_musica().setText(parrilla.toString());
				}
			}
		}
			
		
		
		
	}
	  /**
     * Método para guardar una nueva emisora en la base de datos y mostrar un mensaje de éxito o error.
     */
	public void guardarEmisora() {
		
		if(pf.getAp().getEmisora_txt().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
		}else if (pf.getAp().getModo_cbx().getSelectedItem().toString()==null) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
		}else if(pf.getAp().getGenero_cbx().getSelectedItem().toString()==null){
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			emisora = new Emisora(pf.getAp().getEmisora_txt().getText(),pf.getAp().getModo_cbx().getSelectedItem().toString(),pf.getAp().getGenero_cbx().getSelectedItem().toString());	
			emisoraDTO.getEmisora_dao().agregar(emisoraDTO.getEmisora(),emisoraDTO.getFileEmisoraProp(),emisora);
			JOptionPane.showMessageDialog(null,emisora.agregarEmisora(emisora).getNombre() + " Ha sido agregado con exito!" , "Éxito", JOptionPane.INFORMATION_MESSAGE);
			limpiarData();
			pf.getPp().setVisible(true);
			pf.getAp().setVisible(false);
			pf.repaint();
		}

	}
	


	private boolean dataComplete() {
		isComplete=false;
		if(pf.getCp().getPista_txt().getText().equals("")) {
		    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos primero.", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (pf.getCp().getAutor_txt().getText().equals("")) {
		    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos primero.", "Error", JOptionPane.ERROR_MESSAGE);
		    
		}else {
				
			return isComplete=true;
		}
		return isComplete;
		
	} 

	 /**
     * Método para agregar un archivo de audio seleccionado como pista de música en la base de datos.
     */
	public void addFile() {
			
		    fileChooser = new JFileChooser();
		    fileChooser.setDialogTitle("Seleccione un archivo");
		    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Solo archivos, no directorios
		    int returnValue = fileChooser.showSaveDialog(null);
		    
		    if (returnValue == JFileChooser.APPROVE_OPTION) {
		        File selectedFile = fileChooser.getSelectedFile();
		        String fileName = pf.getCp().getPista_txt().getText() + "-" + pf.getCp().getAutor_txt().getText() + ".wav"; // Nombre del archivo con extensión
		        String finalFilePath = "src/mp3/" + fileName; // Ruta de destino con el nuevo nombre
		        File newFile = new File(finalFilePath);
		        try {
		            Files.copy(selectedFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		            JOptionPane.showMessageDialog(null, "Archivo guardado en: " + newFile.getAbsolutePath());
		            fileAdd=true;
		        } catch (IOException e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		

	}
	
	 /**
     * Método para guardar una nueva pista de música en la base de datos y mostrar un mensaje de éxito o error.
     */
	private void guardarPista() {
		pista = new Pista(pf.getCp().getGenero_cbx().getSelectedItem().toString(),
				pf.getCp().getPista_txt().getText(),pf.getCp().getAutor_txt().getText(),
				pf.getCp().getPista_txt().getText() + "-" + pf.getCp().getAutor_txt().getText() + ".wav");
		pistaDTO.getPista_dao().agregar(pistaDTO.getPista(), pistaDTO.getFilePistaProp(), pista);
		JOptionPane.showMessageDialog(null,pista.getNombre() + " Ha sido agregada con exito!" , "Éxito", JOptionPane.INFORMATION_MESSAGE);
		limpiarData();
		pf.getPp().setVisible(true);
		pf.getCp().setVisible(false);
		pf.repaint();
	}
	
}
			
			
		
	
	
	
	

