package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.Emisora;
import co.edu.unbosque.model.Parrilla;

public interface ParrillaDAO {
	
	void agregar(ArrayList<Parrilla>parrillas,File file, Parrilla pa);
	Parrilla buscar(String nombre , ArrayList<Parrilla>parrillas);
	String mostrarA(File file);


	
}
