package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.EmisoraDAO;
/**
 * La clase Emisora representa una emisora de radio con nombre, modo y tipo específicos.
 * Proporciona métodos para acceder y manipular los atributos de la emisora.
 */
public class Emisora {

// Declaración de variables de instancia
    
    /**
     * Constructor por defecto de la clase Emisora.
     * Crea una instancia de Emisora sin inicializar sus atributos.
     */
	private String nombre;
	private String modo;
	private String tipo;

	
	public Emisora() {
		
		}
	/**
     * Constructor de la clase Emisora.
     * Crea una instancia de Emisora con los atributos especificados.
     * @param nombre El nombre de la emisora.
     * @param modo El modo de la emisora.
     * @param tipo El tipo de la emisora.
     */
	public Emisora(String nombre, String modo, String tipo) {
		super();
		this.nombre = nombre;
		this.modo = modo;
		this.tipo = tipo;
	}
	/**
     * Método para agregar una emisora.
     * @param e La emisora a agregar.
     * @return La emisora agregada.
     */
	public Emisora agregarEmisora(Emisora e) {
		
		return e;
	}

	/**
     * Método para obtener el nombre de la emisora.
     * @return El nombre de la emisora.
     */
	public String getNombre() {
		return nombre;
	}

	/**
     * Método para establecer el nombre de la emisora.
     * @param nombre El nuevo nombre de la emisora.
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	 /**
     * Método para obtener el modo de la emisora.
     * @return El modo de la emisora.
     */
	public String getModo() {
		return modo;
	}

	 /**
     * Método para establecer el modo de la emisora.
     * @param modo El nuevo modo de la emisora.
     */
	public void setModo(String modo) {
		this.modo = modo;
	}

    /**
     * Método para obtener el tipo de la emisora.
     * @return El tipo de la emisora.
     */

	public String getTipo() {
		return tipo;
	}

	/**
     * Método para establecer el tipo de la emisora.
     * @param tipo El nuevo tipo de la emisora.
     */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
     * Método que devuelve una representación en cadena de la emisora.
     * @return Una cadena que representa la emisora.
     */
	@Override
	public String toString() {
		return "Emisora [nombre=" + nombre + ", modo=" + modo + ", tipo=" + tipo + "]";
	}


	
	
	
	
	
	
}
