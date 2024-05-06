package co.edu.unbosque.model;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.EmisoraDAO_imp;
/**
 * La clase EmisoraDTO representa un objeto de transferencia de datos (DTO) para las emisoras de radio.
 * Contiene métodos para acceder y manipular los datos de las emisoras.
 */
public class EmisoraDTO {

 // Declaración de variables de instancia
    
    /**
     * Constructor de la clase EmisoraDTO.
     * Inicializa los componentes necesarios y carga los datos de las emisoras desde un archivo.
     */
	private ArrayList<Emisora>emisora;
	private File fileEmisoraProp;
	private Archivo archivoEmisora;
	private EmisoraDAO_imp emisora_dao;

	
	public EmisoraDTO() {
        // Lógica para inicializar la lista de emisoras y cargar los datos desde un archivo
		 
		emisora = new ArrayList<Emisora>();
		fileEmisoraProp = new File("src/datos/emisora.properties");
		archivoEmisora = new Archivo();
		emisora_dao = new EmisoraDAO_imp(archivoEmisora);
		emisora.addAll(archivoEmisora.leerProperties(fileEmisoraProp));
		for(Emisora e:archivoEmisora.leerProperties(fileEmisoraProp)) {
				System.out.println(e.toString());
		}
	}

	 /**
     * Método para obtener la lista de emisoras.
     * @return La lista de emisoras.
     */
	public ArrayList<Emisora> getEmisora() {
		return emisora;
	}

	 /**
     * Método para establecer la lista de emisoras.
     * @param emisora La nueva lista de emisoras a establecer.
     */
	public void setEmisora(ArrayList<Emisora> emisora) {
		this.emisora = emisora;
	}

	  /**
     * Método para obtener el archivo de propiedades de las emisoras.
     * @return El archivo de propiedades de las emisoras.
     */
	public File getFileEmisoraProp() {
		return fileEmisoraProp;
	}

	/**
     * Método para establecer el archivo de propiedades de las emisoras.
     * @param fileEmisoraProp El nuevo archivo de propiedades de las emisoras a establecer.
     */
	public void setFileEmisoraProp(File fileEmisoraProp) {
		this.fileEmisoraProp = fileEmisoraProp;
	}

	   /**
     * Método para obtener el objeto de archivo de las emisoras.
     * @return El objeto de archivo de las emisoras.
     */
	public Archivo getArchivoEmisora() {
		return archivoEmisora;
	}
	   /**
     * Método para establecer el objeto de archivo de las emisoras.
     * @param archivoEmisora El nuevo objeto de archivo de las emisoras a establecer.
     */

	public void setArchivoEmisora(Archivo archivoEmisora) {
		this.archivoEmisora = archivoEmisora;
	}

	  /**
     * Método para obtener el DAO de las emisoras.
     * @return El DAO de las emisoras.
     */
	public EmisoraDAO_imp getEmisora_dao() {
		return emisora_dao;
	}
	   /**
     * Método para establecer el DAO de las emisoras.
     * @param emisora_dao El nuevo DAO de las emisoras a establecer.
     */

	public void setEmisora_dao(EmisoraDAO_imp emisora_dao) {
		this.emisora_dao = emisora_dao;
	}
	
	
	
	

	



	
	
	
}
