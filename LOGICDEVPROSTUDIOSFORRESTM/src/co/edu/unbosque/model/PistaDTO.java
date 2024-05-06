package co.edu.unbosque.model;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.PistaDAO_imp;

public class PistaDTO {
	
	private ArrayList<Pista>pista;
	private File filePistaProp;
	private Archivo archivoPista;
	private PistaDAO_imp pista_dao;
// Declaración de variables de instancia
    
    /**
     * Constructor de la clase PistaDTO.
     * Inicializa los componentes necesarios y carga los datos de las pistas desde un archivo.
     */
	public PistaDTO() {
		
		pista = new ArrayList<Pista>();
		filePistaProp = new  File("src/datos/pista.properties");
		archivoPista = new Archivo();
		pista_dao = new PistaDAO_imp(archivoPista);
		pista.addAll(archivoPista.leerPropertiesPista(filePistaProp));
		for(Pista p:archivoPista.leerPropertiesPista(filePistaProp)) {
			System.out.println(p.toString());
	}
		
	}
	/**
     * Método para obtener la lista de pistas de música.
     * @return La lista de pistas de música.
     */
	public ArrayList<Pista> getPista() {
		return pista;
	}
	  /**
     * Método para establecer la lista de pistas de música.
     * @param pista La nueva lista de pistas de música a establecer.
     */
	public void setPista(ArrayList<Pista> pista) {
		this.pista = pista;
	}
	/**
     * Método para obtener el archivo de propiedades de las pistas de música.
     * @return El archivo de propiedades de las pistas de música.
     */
	public File getFilePistaProp() {
		return filePistaProp;
	}
	/**
     * Método para establecer el archivo de propiedades de las pistas de música.
     * @param filePistaProp El nuevo archivo de propiedades de las pistas de música a establecer.
     */
	public void setFilePistaProp(File filePistaProp) {
		this.filePistaProp = filePistaProp;
	}
	/**
     * Método para obtener el objeto de archivo de las pistas de música.
     * @return El objeto de archivo de las pistas de música.
     */
	public Archivo getArchivoPista() {
		return archivoPista;
	}
	/**
     * Método para establecer el objeto de archivo de las pistas de música.
     * @param archivoPista El nuevo objeto de archivo de las pistas de música a establecer.
     */
	public void setArchivoPista(Archivo archivoPista) {
		this.archivoPista = archivoPista;
	}
	  /**
     * Método para obtener el DAO de las pistas de música.
     * @return El DAO de las pistas de música.
     */
	public PistaDAO_imp getPista_dao() {
		return pista_dao;
	}
	 /**
     * Método para establecer el DAO de las pistas de música.
     * @param pista_dao El nuevo DAO de las pistas de música a establecer.
     */
	public void setPista_dao(PistaDAO_imp pista_dao) {
		this.pista_dao = pista_dao;
	}
}
