package integracion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import negocio.TDatos;
import tablas.Atributo;

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
	public boolean leerEjemplos(TDatos tDatos, ArrayList<Atributo> listaAtributos) {
		try {
			String cadena;
			FileReader f = new FileReader(tDatos.getArchivoEjemplos());
			BufferedReader b = new BufferedReader(f);
			while((cadena = b.readLine()) != null) {
				String aux[] = cadena.split(",");
				int i = 0;
				for(String elemento: aux) {
					if(aux[aux.length - 1].equalsIgnoreCase(tDatos.getPositivo())) {
						listaAtributos.get(i).addP(elemento);
					}
					else if (aux[aux.length - 1].equalsIgnoreCase(tDatos.getNegativo())) {
						listaAtributos.get(i).addN(elemento);
					}
					else {
						b.close();
						return false;
					}
				}
			}
			b.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
