package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.Emisora;
import co.edu.unbosque.model.Parrilla;


public class ParrillaDAO_imp implements ParrillaDAO{

	private Archivo archivo;
	public ParrillaDAO_imp(Archivo archivoParrilla) {
		this.archivo = archivoParrilla;
	}
	@Override
	public void agregar(ArrayList<Parrilla> parrillas, File file, Parrilla pa) {
		if(buscar(pa.getPista(),parrillas)==null) {
			parrillas.add(pa);
			archivo.escribirArchivoParrilla(parrillas, file);
		}
		
	}

	@Override
	public String mostrarA(File file) {
		archivo = new Archivo();
		ArrayList<Parrilla>parrillas = archivo.leerPropertiesParrilla(file);
		String lista ="";
		for(Parrilla p: parrillas) {
			lista = lista.concat(p.toString() + "\n");
		}
		return lista;
	}
	@Override
	public Parrilla buscar(String nombre, ArrayList<Parrilla> parrillas) {
		Parrilla find = null;
		if (!parrillas.isEmpty()) {
			for (Parrilla p : parrillas) {
				if (nombre.equals(p.getPista().toLowerCase())) 
					find = p;	
			}
		}
		return find;
	}


}
