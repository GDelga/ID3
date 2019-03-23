package tablas;

import java.util.ArrayList;

/**
 * @author Guillermo Delgado Yepes
 */
public class Ejemplos {

	private ArrayList<ArrayList<String>> listaDeEjemplos;
	
	public Ejemplos() {
		this.listaDeEjemplos = new ArrayList<ArrayList<String>>();
	}
	
	public void borrarEjemplo (int pos) {
		for(ArrayList<String> aux: this.listaDeEjemplos) {
			aux.remove(pos);
		}
	}
	
	public void addLinea(String[] linea) {
		ArrayList<String> aux = new ArrayList<>();
		for(String s: linea) {
			aux.add(s);
		}
		this.listaDeEjemplos.add(aux);
	}

	public ArrayList<ArrayList<String>> getListaDeEjemplos() {
		return listaDeEjemplos;
	}

	public void setListaDeEjemplos(ArrayList<ArrayList<String>> listaDeEjemplos) {
		this.listaDeEjemplos = listaDeEjemplos;
	}

	public void add(ArrayList<String> ejemplo) {
		this.listaDeEjemplos.add(ejemplo);
	}
	
	
}
