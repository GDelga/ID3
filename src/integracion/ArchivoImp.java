package integracion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import negocio.TDatos;
import tablas.Atributo;
import tablas.Ejemplos;

/**
 * @author Guillermo Delgado Yepes
 */
public class ArchivoImp implements Archivo {

	@Override
	public ArrayList<Atributo> leerAtributos(TDatos tDatos) {
		try {
			String cadena;
			FileReader f = new FileReader(tDatos.getArchivoAtributos());
			BufferedReader b = new BufferedReader(f);
			ArrayList<Atributo> listaAtributos = new ArrayList<>();
			while((cadena = b.readLine()) != null) {
				String aux[] = cadena.split(",");
				for(String atributo: aux) {
					listaAtributos.add(new Atributo(atributo));
				}
			}
			b.close();
			return listaAtributos;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int leerEjemplos(TDatos tDatos, ArrayList<Atributo> listaAtributos, Ejemplos listaDeEjemplos) {
		try {
			String cadena;
			FileReader f = new FileReader(tDatos.getArchivoEjemplos());
			BufferedReader b = new BufferedReader(f);
			while((cadena = b.readLine()) != null) {
				String aux[] = cadena.split(",");
				listaDeEjemplos.addLinea(aux); //Guardamos la linea en nuestra lista de ejemplos
				int i = 0;
				for(String elemento: aux) {
					if(aux[aux.length - 1].equalsIgnoreCase(tDatos.getPositivo())) { //Si el resultado es positivo
						listaAtributos.get(i).addP(elemento);
					}
					else if (aux[aux.length - 1].equalsIgnoreCase(tDatos.getNegativo())) { //Si el resultado es negativo
						listaAtributos.get(i).addN(elemento);
					}
					else { //No coincide con el resultado = ¡ERROR!
						b.close();
						return -2;
					}
					i++;
				}
			}
			b.close();
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}

}
