package co.edu.unbosque.model;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.ParrillaDAO_imp;
/**
 * La clase ParrillaDTO representa un objeto de transferencia de datos (DTO) para las parrillas de programación.
 * Contiene métodos para acceder y manipular los datos de las parrillas.
 */
public class ParrillaDTO {

	private ArrayList<Parrilla>parrilla;
	private ArrayList<Parrilla>rep;
	private File fileParrillaProp;
	private Archivo archivoParrilla;
	private ParrillaDAO_imp  parrilla_dao;
	
	public ParrillaDTO() {
		  // Declaración de variables de instancia
	    
	    /**
	     * Constructor de la clase ParrillaDTO.
	     * Inicializa los componentes necesarios y carga los datos de las parrillas desde un archivo.
	     */
		rep = new ArrayList<Parrilla>();
		parrilla = new ArrayList<Parrilla>();
		fileParrillaProp = new File("src/datos/parrilla.properties");
		archivoParrilla = new Archivo();
		parrilla_dao= new ParrillaDAO_imp(archivoParrilla);
		parrilla.addAll(archivoParrilla.leerPropertiesParrilla(fileParrillaProp));
		for(Parrilla p : archivoParrilla.leerPropertiesParrilla(fileParrillaProp)) {
			System.out.println(p.toString());
		}
	}
	 /**
     * Método para obtener la lista de parrillas de programación.
     * @return La lista de parrillas de programación.
     */
	public ArrayList<Parrilla> getParrilla() {
		return parrilla;
	}
	 /**
     * Método para establecer la lista de parrillas de programación.
     * @param parrilla La nueva lista de parrillas de programación a establecer.
     */
	public void setParrilla(ArrayList<Parrilla> parrilla) {
		this.parrilla = parrilla;
	}
	 /**
     * Método para obtener el archivo de propiedades de las parrillas de programación.
     * @return El archivo de propiedades de las parrillas de programación.
     */
	public File getFileParrillaProp() {
		return fileParrillaProp;
	}
	 /**
     * Método para establecer el archivo de propiedades de las parrillas de programación.
     * @param fileParrillaProp El nuevo archivo de propiedades de las parrillas de programación a establecer.
     */
	public void setFileParrillaProp(File fileParrillaProp) {
		this.fileParrillaProp = fileParrillaProp;
	}
	 /**
     * Método para obtener el objeto de archivo de las parrillas de programación.
     * @return El objeto de archivo de las parrillas de programación.
     */
	public Archivo getArchivoParrilla() {
		return archivoParrilla;
	}
	/**
     * Método para establecer el objeto de archivo de las parrillas de programación.
     * @param archivoParrilla El nuevo objeto de archivo de las parrillas de programación a establecer.
     */
	public void setArchivoParrilla(Archivo archivoParrilla) {
		this.archivoParrilla = archivoParrilla;
	}
	 /**
     * Método para obtener el DAO de las parrillas de programación.
     * @return El DAO de las parrillas de programación.
     */
	public ParrillaDAO_imp getParrilla_dao() {
		return parrilla_dao;
	}
	 /**
     * Método para establecer el DAO de las parrillas de programación.
     * @param parrilla_dao El nuevo DAO de las parrillas de programación a establecer.
     */
	public void setParrilla_dao(ParrillaDAO_imp parrilla_dao) {
		this.parrilla_dao = parrilla_dao;
	}
	 /**
     * Método para obtener la lista de parrillas de reproducción.
     * @return La lista de parrillas de reproducción.
     */
	public ArrayList<Parrilla> getRep() {
		return rep;
	}/**
     * Método para establecer la lista de parrillas de reproducción.
     * @param rep La nueva lista de parrillas de reproducción a establecer.
     */

	public void setRep(ArrayList<Parrilla> rep) {
		this.rep = rep;
	}
	
	
	
	
	
}
