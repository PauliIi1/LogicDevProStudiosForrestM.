package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;


import co.edu.unbosque.model.Emisora;


public interface EmisoraDAO {

	void agregar(ArrayList<Emisora>emisoras,File file, Emisora e);
	Emisora buscar(String nombre , ArrayList<Emisora> emisoras);

	String mostrarA(File file);

	
}
