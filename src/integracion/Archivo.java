package integracion;

import java.util.ArrayList;

import negocio.TDatos;
import tablas.Atributo;
import tablas.Ejemplos;

/**
 * 
 * @author Guillermo Delgado Yepes
 *
 */
public interface Archivo {
	public ArrayList<Atributo> leerAtributos(TDatos tDatos);
	public boolean leerEjemplos(TDatos tDatos, ArrayList<Atributo> listaAtributos, Ejemplos listaDeEjemplos);
}
