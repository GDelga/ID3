package factoria;

import negocio.BusquedaID3;

/**
 * @author Guillermo Delgado Yepes
 */
public abstract class FactoriaNegocio {

	private static FactoriaNegocio instance;
	
	public static FactoriaNegocio getInstance() {
		if(instance == null) {
			instance = new FactoriaNegocioImp();
		}
		return instance;
	}
	
	public abstract BusquedaID3 crearBusquedaID3();
}
