/**
 * 
 */
package factoria;

import command.Command;
import command.CommandBuscar;
import command.CommandComprobar;
import presentacion.Events;

/**
 * @author Guillermo Delgado Yepes
 */
public class FactoriaCommandImp extends FactoriaCommand {

	@Override
	public Command generarComando(int evento) {
		switch(evento){
		case(Events.BUSCAR_ID3):
			return new CommandBuscar();
		case(Events.COMPROBAR):
			return new CommandComprobar();
		}
		return null;
	
	}
}