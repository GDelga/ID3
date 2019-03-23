package dispatcher;

import presentacion.Contexto;
import presentacion.Events;
import presentacion.GUIMain;

/**
 * @author Guillermo Delgado Yepes
 */
public class DispatcherImp extends Dispatcher {

	@Override
	public void generarVista(Contexto contexto) {
		int evento = contexto.getEvento();
		switch(evento) {
		case(Events.GUI_MAIN):
			GUIMain.getInstance().actualizar(contexto);
		break;
		case(Events.BUSCAR_OK):
			GUIMain.getInstance().actualizar(contexto);
		break;
		case(Events.BUSCAR_KO):
			GUIMain.getInstance().actualizar(contexto);
		break;
		}
	}
}