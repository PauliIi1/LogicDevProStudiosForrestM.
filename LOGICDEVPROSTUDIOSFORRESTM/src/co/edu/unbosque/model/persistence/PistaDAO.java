package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.Emisora;
import co.edu.unbosque.model.Pista;

public interface PistaDAO {

	void agregar(ArrayList<Pista>pistas,File file, Pista p);
	Pista buscar(String nombre , ArrayList<Pista> pistas);
	String mostrarA(File file);

}
