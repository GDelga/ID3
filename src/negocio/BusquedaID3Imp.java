package negocio;

import java.util.ArrayList;

import arbol.Nodo;
import factoria.FactoriaIntegracion;
import tablas.Atributo;
import tablas.Ejemplos;

/**
 * @author Guillermo Delgado Yepes
 */
public class BusquedaID3Imp implements BusquedaID3 {

	public Object busqueda(TDatos tDatos) {
		ArrayList<Atributo> listaAtributos = FactoriaIntegracion.getInstance().crearArchivo().leerAtributos(tDatos);
		if(listaAtributos == null) {
			return -3; //ERROR!
		}
		else {
			Ejemplos listaEjemplos = new Ejemplos();
			int ok = FactoriaIntegracion.getInstance().crearArchivo().leerEjemplos(tDatos, listaAtributos, listaEjemplos);
			if(ok < 0) {
				return ok; //ERROR!
			}
			else {
				listaAtributos.remove(listaAtributos.size() - 1); //Borro el atributo que define positivo y negativo
				Nodo mejor = actualizaEjemplos(tDatos, listaAtributos, listaEjemplos);
				mejor.setEjemplos(listaEjemplos);
				algoritmo(tDatos, mejor, listaAtributos);
				return mejor;
			}
		}
	}

	private Nodo actualizaEjemplos(TDatos tDatos, ArrayList<Atributo> listaAtributos, Ejemplos listaEjemplos) {
		Atributo mejorAtributo = null;
		double mejorMerito = Double.MAX_VALUE;
		int i = 0;
		
		for(Atributo atributo : listaAtributos) {
			atributo.limpiar(); //Elimino los datos del noto anterior
			for(ArrayList<String> ejemplo : listaEjemplos.getListaDeEjemplos()) {
				//Miramos si son positivos o negativos
				if(ejemplo.get(ejemplo.size() - 1).equalsIgnoreCase(tDatos.getPositivo())) {
					atributo.addP(ejemplo.get(i));
				}
				else {
					atributo.addN(ejemplo.get(i));
				}
			}
			
			atributo.calcularMerito();
			double aux = atributo.getMerito();
			if(aux <= mejorMerito) {
				mejorMerito = aux;
				mejorAtributo = atributo;
			}
			i++;
		}
		
		Nodo mejor = new Nodo(mejorAtributo.getNombre(), mejorAtributo.getP().size(), mejorAtributo.getN().size(), new ArrayList<Nodo>());
		for(String atributo: mejorAtributo.getTipos()){
			Nodo aux = new Nodo(atributo, 0, 0, new ArrayList<Nodo>());
			Ejemplos ejemplos = new Ejemplos();
			for (ArrayList<String> ejemplo: listaEjemplos.getListaDeEjemplos()) {
				if(ejemplo.contains(atributo)) {
					ejemplos.add(ejemplo);
					if(ejemplo.get(ejemplo.size() - 1).equalsIgnoreCase(tDatos.getPositivo())) {
						aux.sumaPositivo();
					}
					else {
						aux.sumaNegativo();
					}
				}
			}
			aux.setEjemplos(ejemplos);
			mejor.addHijo(aux);
		}
		return mejor;
	}

	private void algoritmo(TDatos tDatos, Nodo mejor, ArrayList<Atributo> listaAtributos) {
		ArrayList<Atributo> aux = new ArrayList<>();
		if(listaAtributos.size() == 1) { //Si solo queda un atributo
			for(Nodo hijo: mejor.getHijos()) { //Para cada hijo
				if(hijo.getNumPositivos() > 0 && hijo.getNumNegativos() == 0) {
					//Si solo hay positivos
					hijo.addHijo(new Nodo(tDatos.getPositivo()));
				}
				else if(hijo.getNumPositivos() == 0 && hijo.getNumNegativos() > 0) {
					//Si solo hay negativos
					hijo.addHijo(new Nodo(tDatos.getNegativo()));
				}
			}
		}
		else { //Si hay mas atributos
			//Quitamos el mejor
			int num = -1;
			for (int i = 0; i < listaAtributos.size(); i++) {
				if (!listaAtributos.get(i).getNombre().equals(mejor.getNombre())) { //Si no es el mejor
					aux.add(listaAtributos.get(i));
				} else {
					num = i; //Guardamos la i del mejor para borrarlo
				}
			}
			
			for(Nodo hijo: mejor.getHijos()) { //Para cada hijo
				if(hijo.getNumPositivos() > 0 && hijo.getNumNegativos() == 0) {
					//Si solo hay positivos
					hijo.addHijo(new Nodo(tDatos.getPositivo()));
				}
				else if(hijo.getNumPositivos() == 0 && hijo.getNumNegativos() > 0) {
					//Si solo hay negativos
					hijo.addHijo(new Nodo(tDatos.getNegativo()));
				}
				else {
					hijo.eliminaEjemplo(num); //Elimino los ejemplos del atributo mejor
					Nodo nuevoMejor = actualizaEjemplos(tDatos, aux, hijo.getEjemplos()); //Actualizo la lista
					hijo.addHijo(nuevoMejor); //Agregar el nuevo hijo
					algoritmo(tDatos, nuevoMejor, aux); //Llamada recursiva
				}
			}
		}
	}
	
}
