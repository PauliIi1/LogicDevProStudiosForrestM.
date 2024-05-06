package co.edu.unbosque.model;

public class Parrilla {
	
	/**
	 * La clase Parrilla representa una parrilla de programación que contiene información sobre una emisora, una pista de música y un archivo de audio.
	 * Proporciona métodos para acceder y manipular los atributos de la parrilla.
	*/
		private String emisora, pista , archivo;
	    // Declaración de variables de instancia
	    
	    /**
	     * Constructor por defecto de la clase Parrilla.
	     * Crea una instancia de Parrilla sin inicializar sus atributos.
	     */
	    public Parrilla() {
	        // Constructor vacío
	    }
	    
	    /**
	     * Constructor de la clase Parrilla.
	     * Crea una instancia de Parrilla con los atributos especificados.
	     * @param emisora El nombre de la emisora.
	     * @param pista El nombre de la pista de música.
	     * @param archivo La ubicación del archivo de audio.
	     */
	    public Parrilla(String emisora, String pista, String archivo) {
	        this.emisora = emisora;
	        this.pista = pista;
	        this.archivo = archivo;
	    }

	    /**
	     * Método para obtener el nombre de la emisora asociada a la parrilla.
	     * @return El nombre de la emisora.
	     */
	    public String getEmisora() {
	        return emisora;
	    }

	    /**
	     * Método para establecer el nombre de la emisora asociada a la parrilla.
	     * @param emisora El nuevo nombre de la emisora.
	     */
	    public void setEmisora(String emisora) {
	        this.emisora = emisora;
	    }

	    /**
	     * Método para obtener el nombre de la pista de música asociada a la parrilla.
	     * @return El nombre de la pista de música.
	     */
	    public String getPista() {
	        return pista;
	    }

	    /**
	     * Método para establecer el nombre de la pista de música asociada a la parrilla.
	     * @param pista El nuevo nombre de la pista de música.
	     */
	    public void setPista(String pista) {
	        this.pista = pista;
	    }

	    /**
	     * Método para obtener la ubicación del archivo de audio asociado a la parrilla.
	     * @return La ubicación del archivo de audio.
	     */
	    public String getArchivo() {
	        return archivo;
	    }

	    /**
	     * Método para establecer la ubicación del archivo de audio asociado a la parrilla.
	     * @param archivo La nueva ubicación del archivo de audio.
	     */
	    public void setArchivo(String archivo) {
	        this.archivo = archivo;
	    }

	    /**
	     * Método que devuelve una representación en cadena de la parrilla.
	     * @return Una cadena que representa la parrilla.
	     */
	    @Override
	    public String toString() {
	        return "Emisora: " + emisora + "\n" +
	               "Pista: " + pista + "\n" +
	               "Archivo: " + archivo + "\n";
	    }
	}

