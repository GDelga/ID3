package negocio;

import java.util.ArrayList;

import arbol.Nodo;
import tablas.Atributo;

/**
 * @author Guillermo Delgado Yepes
 */
public interface BusquedaID3 {
	public abstract Object busqueda(TDatos tDatos);
	public Object encontrarSolucion(String positivo, String negativo, Nodo arbol, ArrayList<Atributo> atributos, ArrayList<String> ejemplos);
}
