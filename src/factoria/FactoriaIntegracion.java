package factoria;

import integracion.Archivo;

/**
 * @author Guillermo Delgado Yepes
 */
public abstract class FactoriaIntegracion {

	private static FactoriaIntegracion instance;
	
	public static FactoriaIntegracion getInstance() {
		if(instance == null) {
			instance = new FactoriaIntegracionImp();
		}
		return instance;
	}
	
	public abstract Archivo crearArchivo();
}
