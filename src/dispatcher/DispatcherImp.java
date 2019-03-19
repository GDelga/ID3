package dispatcher;

import presentacion.Contexto;
import presentacion.Events;

/**
 * @author Guillermo Delgado Yepes
 */
public class DispatcherImp extends Dispatcher {

	@Override
	public void generarVista(Contexto contexto) {
		int evento = contexto.getEvento();
		switch(evento) {
		}
	}
}