package arbol;

import java.util.ArrayList;

import tablas.Atributo;
import tablas.Ejemplos;
/**
 * @author Guillermo Delgado Yepes
 */
public class Nodo {
	
	private ArrayList<Nodo> hijos; //Array de hijos del nodo actual
	private int numPositivos; //Numero de elementos positivos de este nodo
	private int numNegativos; //Numero de elementos negativos de este nodo
	private String nombre; //Nombre del nodo (El nombre del atributo que crea el nodo)
	private Ejemplos ejemplos; //Lista de ejemplos hasta ese nodo
	private ArrayList<Atributo> atributos; //Lista de atributos
	
	public Nodo() {
		this.nombre = "";
		this.hijos = new ArrayList<>();
		this.numNegativos = 0;
		this.numPositivos = 0;
		this.ejemplos = null;
	}
	
	public Nodo(String nombre) {
		this.nombre = nombre;
		this.hijos = new ArrayList<>();
		this.numNegativos = 0;
		this.numPositivos = 0;
		this.ejemplos = null;
	}
	
	public Nodo(String nombre, int pos, int neg, ArrayList<Nodo> hijos) {
		this.nombre = nombre;
		this.hijos = hijos;
		this.numNegativos = pos;
		this.numPositivos = neg;
		this.ejemplos = null;
	}
	
	public void addHijo(Nodo n) {
		this.hijos.add(n);
	}
	
	public void eliminaEjemplo(int n){
		this.ejemplos.borrarEjemplo(n);
	}
	
	public void sumaPositivo() {
		this.numPositivos++;
	}
	public void sumaNegativo() {
		this.numNegativos++;
	}

	public ArrayList<Nodo> getHijos() {
		return hijos;
	}

	public void setHijos(ArrayList<Nodo> hijos) {
		this.hijos = hijos;
	}

	public int getNumPositivos() {
		return numPositivos;
	}

	public void setNumPositivos(int numPositivos) {
		this.numPositivos = numPositivos;
	}

	public int getNumNegativos() {
		return numNegativos;
	}

	public void setNumNegativos(int numNegativos) {
		this.numNegativos = numNegativos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ejemplos getEjemplos() {
		return ejemplos;
	}

	public void setEjemplos(Ejemplos ejemplos) {
		this.ejemplos = ejemplos;
	}

	public ArrayList<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(ArrayList<Atributo> atributos) {
		this.atributos = atributos;
	}
	
}
