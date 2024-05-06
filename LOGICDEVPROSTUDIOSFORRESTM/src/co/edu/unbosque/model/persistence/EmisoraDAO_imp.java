package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Emisora;
import co.edu.unbosque.model.Parrilla;


public class EmisoraDAO_imp implements EmisoraDAO {
	private Archivo archivo;
	public EmisoraDAO_imp(Archivo archivo) {
		// TODO Auto-generated constructor stub
		this.archivo= archivo;
	}
	@Override
	public void agregar(ArrayList<Emisora> emisoras, File file, Emisora e) {
		if(buscar(e.getNombre(),emisoras)==null) {
			emisoras.add(e);
			archivo.escribirArchivo(emisoras,file);
		}
		
	}

	@Override
	public Emisora buscar(String nombre, ArrayList<Emisora> emisoras) {
		Emisora find = null;
		if (!emisoras.isEmpty()) {
			for (Emisora e : emisoras) {
				if (nombre.equals(e.getNombre().toLowerCase())) 
					find = e;	
			}
		}
		return find;
	
	}

	
	@Override
	public String mostrarA(File file) {
		archivo = new Archivo();
		ArrayList <Emisora> emisoras = archivo.leerProperties(file);
		
		String lista ="";
		for (Emisora e: emisoras) {
			lista = lista.concat(e.toString() + "\n");
		}
		return lista;
		
	
	}



}
