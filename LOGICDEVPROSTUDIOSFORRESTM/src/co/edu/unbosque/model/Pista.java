package co.edu.unbosque.model;

/**
 * La clase Pista representa una pista de música con género, nombre, artista y ubicación de archivo específicos.
 * Proporciona métodos para acceder y manipular los atributos de la pista.
 */

public class Pista {

	 // Declaración de variables de instancia
	private String genero;
	private String nombre;
	private String artista;
	private String archivo;
	
	

	   
	    
	    /**
	     * Constructor por defecto de la clase Pista.
	     * Crea una instancia de Pista sin inicializar sus atributos.
	     */
	    public Pista() {
	        // Constructor vacío
	    }

	    /**
	     * Constructor de la clase Pista.
	     * Crea una instancia de Pista con los atributos especificados.
	     * @param genero El género de la pista.
	     * @param nombre El nombre de la pista.
	     * @param artista El artista de la pista.
	     * @param archivo La ubicación del archivo de la pista.
	     */
	    public Pista(String genero, String nombre, String artista, String archivo) {
	        this.genero = genero;
	        this.nombre = nombre;
	        this.artista = artista;
	        this.archivo = archivo;
	    }

	    /**
	     * Método para obtener el género de la pista.
	     * @return El género de la pista.
	     */
	    public String getGenero() {
	        return genero;
	    }

	    /**
	     * Método para establecer el género de la pista.
	     * @param genero El nuevo género de la pista.
	     */
	    public void setGenero(String genero) {
	        this.genero = genero;
	    }

	    /**
	     * Método para obtener el nombre de la pista.
	     * @return El nombre de la pista.
	     */
	    public String getNombre() {
	        return nombre;
	    }

	    /**
	     * Método para establecer el nombre de la pista.
	     * @param nombre El nuevo nombre de la pista.
	     */
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    /**
	     * Método para obtener el artista de la pista.
	     * @return El artista de la pista.
	     */
	    public String getArtista() {
	        return artista;
	    }

	    /**
	     * Método para establecer el artista de la pista.
	     * @param artista El nuevo artista de la pista.
	     */
	    public void setArtista(String artista) {
	        this.artista = artista;
	    }

	    /**
	     * Método para obtener la ubicación del archivo de la pista.
	     * @return La ubicación del archivo de la pista.
	     */
	    public String getArchivo() {
	        return archivo;
	    }

	    /**
	     * Método para establecer la ubicación del archivo de la pista.
	     * @param archivo La nueva ubicación del archivo de la pista.
	     */
	    public void setArchivo(String archivo) {
	        this.archivo = archivo;
	    }

	    /**
	     * Método que devuelve una representación en cadena de la pista.
	     * @return Una cadena que representa la pista.
	     */
	    @Override
	    public String toString() {
	        return "Pista [genero=" + genero + ", nombre=" + nombre + ", artista=" + artista + ", archivo=" + archivo + "]";
	    }
	}
