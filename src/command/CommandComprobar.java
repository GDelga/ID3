package command;

import factoria.FactoriaNegocio;
import negocio.TComprobacion;
import presentacion.Contexto;
import presentacion.Events;

public class CommandComprobar implements Command{

	@Override
	public Contexto execute(Object dato) {
		TComprobacion tComprobacion = (TComprobacion) dato;
		Object n = FactoriaNegocio.getInstance().crearBusquedaID3().encontrarSolucion(tComprobacion.getPositivo(), tComprobacion.getNegativo(),  tComprobacion.getPadre(), tComprobacion.getAtributos(), tComprobacion.getEjemplos());
		if(n instanceof Integer) return new Contexto(Events.COMPROBAR_KO, n);
		else return new Contexto(Events.COMPROBAR_OK, n);
	}
}
