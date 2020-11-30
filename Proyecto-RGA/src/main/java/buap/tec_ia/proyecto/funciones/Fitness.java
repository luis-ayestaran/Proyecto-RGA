package buap.tec_ia.proyecto.funciones;

import buap.tec_ia.proyecto.estructuras.Individuo;

public class Fitness {
	private Individuo individuo;
	
	
	public Fitness() {
		init();
	}
	
	public void init() {
		Funcion_Fitness(individuo);
	}
	
	public void Funcion_Fitness(Individuo individuo) {
		
		System.out.println(individuo.getSv());
		
	}

}
