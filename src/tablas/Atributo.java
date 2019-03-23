package tablas;

import java.util.HashMap;
import java.util.Set;

/**
 * @author Guillermo Delgado Yepes
 */
public class Atributo {
	
	private String nombre; //Nombre del atributo
	private int total; //Total de veces que aparece en la lista cada elemento
	private double merito; //Calculo del merito
	private HashMap<String, Integer> P; //Positvos
	private HashMap<String, Integer> N; //Negativos
	private HashMap<String, Integer> A; //Total de cada elemento del atributo
	
	public Atributo(String nombre) {
		this.nombre = nombre;
		this.P = new HashMap<>();
		this.N = new HashMap<>();
		this.A = new HashMap<>();
		this.merito = 0;
		this.total = 0;
	}
	
	public void addP(String elemento) {
		if(this.P.containsKey(elemento)) {
			this.P.put(elemento, this.P.get(elemento) + 1);
		}
		else this.P.put(elemento, 1);
		if(this.A.containsKey(elemento)) {
			this.A.put(elemento, this.A.get(elemento) + 1);
		}
		else this.A.put(elemento, 1);
		total++;
	}
	
	public void addN(String elemento) {
		if(this.N.containsKey(elemento)) {
			this.N.put(elemento, this.N.get(elemento) + 1);
		}
		else this.N.put(elemento, 1);
		if(this.A.containsKey(elemento)) {
			this.A.put(elemento, this.A.get(elemento) + 1);
		}
		else this.A.put(elemento, 1);
		total++;
	}
	
	public void calcularMerito() {
		Set<String> aux = this.A.keySet();
		for(String elemento: aux) {
			double p = 0, n = 0;
			double r = 0;
			if(this.P.containsKey(elemento)) {//Calculo p
				p = (double) this.P.get(elemento) / (double) this.A.get(elemento);
			}
			if(this.N.containsKey(elemento)) {//Calculo n
				n = (double)this.N.get(elemento)/ (double)this.A.get(elemento);
			}
			r = (double)this.A.get(elemento) / (double)this.total; // Calculo r
			double info = 0;
			//Calculo info
			if(p != 0) {
				info += -p * (Math.log(p)/Math.log(2));
			}
			if(n != 0) {
				info += -n *(Math.log(n)/Math.log(2));
			}
			this.merito += r*info; //Calculo merito de ese elemento
		}
	}
	
	public void limpiar() {
		this.N = new HashMap<>();
		this.P = new HashMap<>();
		this.A = new HashMap<>();
		this.total = 0;
		this.merito = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getMerito() {
		return merito;
	}

	public void setMerito(double merito) {
		this.merito = merito;
	}

	public HashMap<String, Integer> getP() {
		return P;
	}

	public void setP(HashMap<String, Integer> p) {
		P = p;
	}

	public HashMap<String, Integer> getN() {
		return N;
	}

	public void setN(HashMap<String, Integer> n) {
		N = n;
	}

	public HashMap<String, Integer> getA() {
		return A;
	}

	public void setA(HashMap<String, Integer> a) {
		A = a;
	}
	
	public Set<String> getTipos(){
		
		return A.keySet();
	}
}
