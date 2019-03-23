package command;

import arbol.Nodo;
import factoria.FactoriaNegocio;
import negocio.TDatos;
import presentacion.Contexto;
import presentacion.Events;

/**
 * @author Guillermo Delgado Yepes
 */
public class CommandBuscar implements Command{

	@Override
	public Contexto execute(Object dato) {
		TDatos tDatos = (TDatos) dato;
		Nodo n = FactoriaNegocio.getInstance().crearBusquedaID3().busqueda(tDatos);
		if(n == null) return new Contexto(Events.BUSCAR_KO, null);
		else return new Contexto(Events.BUSCAR_OK, n);
	}

}
