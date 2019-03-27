package negocio;

import java.util.ArrayList;

import arbol.Nodo;
import tablas.Atributo;

/**
 * @author Guillermo Delgado Yepes
 */
public class TComprobacion {
	
	String positivo;
	String negativo;
	Nodo padre;
	ArrayList<Atributo> atributos;
	ArrayList<String> ejemplos;
	
	public TComprobacion(String p, String n, Nodo no, ArrayList<Atributo> a, ArrayList<String> e) {
		this.atributos = a;
		this.ejemplos = e;
		this.padre = no;
		this.positivo = p;
		this.negativo = n;
	}

	public String getPositivo() {
		return positivo;
	}

	public void setPositivo(String positivo) {
		this.positivo = positivo;
	}

	public String getNegativo() {
		return negativo;
	}

	public void setNegativo(String negativo) {
		this.negativo = negativo;
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	public ArrayList<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(ArrayList<Atributo> atributos) {
		this.atributos = atributos;
	}

	public ArrayList<String> getEjemplos() {
		return ejemplos;
	}

	public void setEjemplos(ArrayList<String> ejemplos) {
		this.ejemplos = ejemplos;
	}

}
