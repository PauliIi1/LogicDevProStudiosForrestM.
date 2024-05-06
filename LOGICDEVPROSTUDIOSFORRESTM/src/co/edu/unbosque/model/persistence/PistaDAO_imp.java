package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.Emisora;
import co.edu.unbosque.model.Parrilla;
import co.edu.unbosque.model.Pista;

public class PistaDAO_imp implements PistaDAO{

	private Archivo archivo;
	public PistaDAO_imp(Archivo archivo) {
		// TODO Auto-generated constructor stub
		this.archivo= archivo;

	}
	@Override
	public void agregar(ArrayList<Pista> pistas, File file, Pista p) {
		if(buscar(p.getNombre(),pistas)==null) {
			pistas.add(p);
			archivo.escribirArchivoPista(pistas,file);
		}
	}

	@Override
	public Pista buscar(String nombre, ArrayList<Pista> pistas) {
		Pista find = null;
		if (!pistas.isEmpty()) {
			for (Pista p : pistas) {
				if (nombre.equals(p.getNombre().toLowerCase())) 
					find = p;	
			}
		}
		return find;
	}
		
	
	@Override
	public String mostrarA(File file) {
		archivo = new Archivo();
		ArrayList <Pista> pistas = archivo.leerPropertiesPista(file);
		String lista ="";
		for (Pista p: pistas) {
			lista = lista.concat(p.toString() + "\n");
		}
		return lista;
	}


	
	
}
