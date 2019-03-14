package negocio;

/**
 * 
 * @author Guillermo Delgado Yepes
 *
 */
public class TDatos {

	private String archivoAtributos;
	private String archivoEjemplos;
	private String positivo;
	private String negativo;
	
	public TDatos(String a1, String a2, String p, String n) {
		this.archivoAtributos = a1;
		this.archivoEjemplos = a2;
		this.positivo = p;
		this.negativo = n;
	}

	public String getArchivoAtributos() {
		return archivoAtributos;
	}

	public void setArchivoAtributos(String archivoAtributos) {
		this.archivoAtributos = archivoAtributos;
	}

	public String getArchivoEjemplos() {
		return archivoEjemplos;
	}

	public void setArchivoEjemplos(String archivoEjemplos) {
		this.archivoEjemplos = archivoEjemplos;
	}

	public String getPositivo() {
		return positivo;
	}

	public void setPositivo(String positivo) {
		this.positivo = positivo;
	}

	public String getNegativo() {
		return negativo;
	}

	public void setNegativo(String negativo) {
		this.negativo = negativo;
	}
	
	
}
