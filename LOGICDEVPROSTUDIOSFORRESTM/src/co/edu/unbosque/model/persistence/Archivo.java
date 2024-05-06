package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;


import co.edu.unbosque.model.Emisora;
import co.edu.unbosque.model.Parrilla;
import co.edu.unbosque.model.Pista;
/**
 * La clase Archivo proporciona métodos para escribir y leer datos de archivos de propiedades.
 * Estos archivos de propiedades contienen información sobre emisoras, pistas y parrillas de reproducción.
 */

public class Archivo {
	
	private Properties p;
	private Emisora emisora;
	private ArrayList<Emisora> emisoras;
	private Pista pi;
	private ArrayList<Pista>pistas;
	private Parrilla pa;
	private ArrayList<Parrilla>parrillas;
	private String nombre,emi , modo , tipo,artista,archivo,genero,pista;
	
 // Constructor
    
    /**
     * Constructor de la clase Archivo.
     * Crea un nuevo objeto Archivo.
     */
	public Archivo() {
		// TODO Auto-generated constructor stub
	}
	
// Métodos
    
    /**
     * Escribe la información de las pistas en un archivo de propiedades.
     * @param pistas Lista de pistas de música.
     * @param file Archivo de propiedades donde se escribirán los datos.
     */
	public void escribirArchivoPista(ArrayList<Pista> pistas, File file) {
	
		 p = new Properties();
		   try {
	           p.load(new FileInputStream(file));
	       } catch (IOException e) {
	       }

		
		  int x= Integer.parseInt(p.getProperty("pista.cantidad", "0"));
		  for (int i = 0; i < pistas.size(); i++) {
	           pi = (Pista) pistas.get(i);
	           
	           x++;
	           String prefix = "pista" ;
	           p.setProperty(prefix+  ".archivo"+x, pi.getArchivo());
	           p.setProperty(prefix + ".artista"+x, pi.getArtista());
	           p.setProperty(prefix + ".genero"+x, pi.getGenero());
	           p.setProperty(prefix + ".nombre"+x, pi.getNombre());
	  	     
	     }
	       try (FileOutputStream fos = new FileOutputStream(file, false)) {
	           p.store(fos, null);
	       } catch (IOException e) {
	           System.err.println("Error al escribir en el archivo de propiedades: " + e.getMessage());
	       }
		
	}
	   /**
     * Escribe la información de las emisoras en un archivo de propiedades.
     * @param emisoras Lista de emisoras de radio.
     * @param file Archivo de propiedades donde se escribirán los datos.
     */
	public void escribirArchivo(ArrayList<Emisora> emisoras, File file) {
	   p = new Properties();
	   try {
           p.load(new FileInputStream(file));
       } catch (IOException e) {
       }
	  int x= Integer.parseInt(p.getProperty("emisora.cantidad", "0"));
	    for (int i = 0; i < emisoras.size(); i++) {
	        Emisora emisora = emisoras.get(i);
	         // ¿Por qué inicializas x en 3 y luego lo incrementas en cada iteración?
	        x++;
	        String prefix = "emisora";
	        p.setProperty(prefix + ".modo" + x, emisora.getModo());
	        p.setProperty(prefix + ".nombre" + x, emisora.getNombre());
	        p.setProperty(prefix + ".tipo" + x, emisora.getTipo());
	    }

	    try (FileOutputStream fos = new FileOutputStream(file, false)) {
	        p.store(fos, null);
	    } catch (IOException e) {
	        System.err.println("Error al escribir en el archivo de propiedades: " + e.getMessage());
	    }
	}
	/**
     * Lee la información de las emisoras desde un archivo de propiedades.
     * @param fileEmisoraProp Archivo de propiedades que contiene la información de las emisoras.
     * @return Lista de objetos Emisora leídos desde el archivo.
     */
	public ArrayList<Emisora> leerProperties(File fileEmisoraProp) {
		emisoras = new ArrayList<Emisora>();
	    p = new Properties();
	    try (FileInputStream fis = new FileInputStream(fileEmisoraProp)) {
	        p.load(fis);
	        for (int i = 1; i <= 15; i++) {
	            modo = p.getProperty("emisora.modo" + i);
	            nombre = p.getProperty("emisora.nombre" + i);
	            tipo = p.getProperty("emisora.tipo" + i);
	            if (nombre != null && modo != null && tipo != null) {
	                emisoras.add(new Emisora(nombre, modo, tipo));
	            }
	        }
	    } catch (IOException e) {
	        System.err.println("Error al leer el archivo de propiedades: " + e.getMessage());
	    }

	    return emisoras;
	}

	
	 /**
     * Lee la información de las pistas desde un archivo de propiedades.
     * @param filePistaProp Archivo de propiedades que contiene la información de las pistas.
     * @return Lista de objetos Pista leídos desde el archivo.
     */
	public ArrayList<Pista> leerPropertiesPista(File filePistaProp) {
		pistas = new ArrayList<Pista>();
	       p = new Properties();
	        try (FileInputStream fis = new FileInputStream(filePistaProp)) {
	            p.load(fis);
	            for (int i = 1; i <= 15; i++) {
	                 archivo = p.getProperty("pista.archivo" + i);
	                 artista = p.getProperty("pista.artista" + i);
	                 genero = p.getProperty("pista.genero" + i);
	                 nombre = p.getProperty("pista.nombre" + i);
	               if (nombre != null && genero != null && archivo != null && artista !=null ) {
	                    pistas.add(new Pista( genero,nombre, artista,archivo));
	                }
	            }
	            
	        } catch (IOException e) {
	            System.err.println("Error al leer el archivo de propiedades: " + e.getMessage());
	        }

	        return pistas;
	    }
	
	/**
     * Lee la información de las parrillas de reproducción desde un archivo de propiedades.
     * @param fileParrillaProp Archivo de propiedades que contiene la información de las parrillas de reproducción.
     * @return Lista de objetos Parrilla leídos desde el archivo.
     */
	public ArrayList<Parrilla> leerPropertiesParrilla(File fileParrillaProp) {
		parrillas = new ArrayList<Parrilla>();
		p = new Properties();
		   try (FileInputStream fis = new FileInputStream(fileParrillaProp)) {
	            p.load(fis);
	            for (int i = 1; i <= 15; i++) {
	               emi = p.getProperty("parrilla.emisora" + i);
	               pista = p.getProperty("parrilla.pista" + i);
	               archivo = p.getProperty("parrilla.archivo" + i);
	                 
	               if (emi != null && pista!= null && archivo != null) {
	                    parrillas.add(pa = new Parrilla(emi,pista,archivo));
	                }
	            }
	            
	        } catch (IOException e) {
	            System.err.println("Error al leer el archivo de propiedades: " + e.getMessage());
	        }
		return parrillas;
	}
	
	   /**
     * Escribe la información de las parrillas de reproducción en un archivo de propiedades.
     * @param parrillas Lista de parrillas de reproducción.
     * @param file Archivo de propiedades donde se escribirán los datos.
     */
	public void escribirArchivoParrilla(ArrayList<Parrilla> parrillas, File file) {
		   p = new Properties();
		   try {
	           p.load(new FileInputStream(file));
	       } catch (IOException e) {
	       }
		  int x= Integer.parseInt(p.getProperty("parrilla.cantidad", "0"));
		    for (int i = 0; i < parrillas.size(); i++) {
		    		pa = (Parrilla)  parrillas.get(i);
		         // ¿Por qué inicializas x en 3 y luego lo incrementas en cada iteración?
		        x++;
		        String prefix = "parrilla";
		        p.setProperty(prefix + ".emisora" + x, pa.getEmisora());
		        p.setProperty(prefix + ".pista" + x, pa.getPista());
		        p.setProperty(prefix + ".archivo" + x, pa.getArchivo());
		    }

		    try (FileOutputStream fos = new FileOutputStream(file, false)) {
		        p.store(fos, null);
		    } catch (IOException e) {
		        System.err.println("Error al escribir en el archivo de propiedades: " + e.getMessage());
		    }
		}
		
	}

