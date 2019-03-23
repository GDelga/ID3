package factoria;

import negocio.BusquedaID3;
import negocio.BusquedaID3Imp;

/**
 * @author Guillermo Delgado Yepes
 */
public class FactoriaNegocioImp extends FactoriaNegocio{

	@Override
	public BusquedaID3 crearBusquedaID3() {
		return new BusquedaID3Imp();
	}

}
