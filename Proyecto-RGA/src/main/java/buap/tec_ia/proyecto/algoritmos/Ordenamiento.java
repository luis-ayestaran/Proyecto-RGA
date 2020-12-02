package buap.tec_ia.proyecto.algoritmos;

import java.util.Collections;
import java.util.List;

import buap.tec_ia.proyecto.estructuras.Individuo;

public class Ordenamiento {

	public static void ordenarPorAptitud( List<Individuo> generacion ) {
		
		Collections.sort(
			generacion,
			(individuo1, individuo2) -> String.valueOf(individuo2.getAptitud()).compareTo(String.valueOf(individuo1.getAptitud()))
		);
		
	}
	
}
