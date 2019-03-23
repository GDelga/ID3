package factoria;

import integracion.Archivo;
import integracion.ArchivoImp;

/**
 * @author Guillermo Delgado Yepes
 */
public class FactoriaIntegracionImp extends FactoriaIntegracion{

	@Override
	public Archivo crearArchivo() {
		return new ArchivoImp();
	}

}
