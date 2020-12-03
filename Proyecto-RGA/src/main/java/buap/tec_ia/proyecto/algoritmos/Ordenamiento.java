package buap.tec_ia.proyecto.algoritmos;

import java.util.Collections;
import java.util.List;

import buap.tec_ia.proyecto.estructuras.Individuo;

public class Ordenamiento {

	public static void ordenarPorAptitud( List<Individuo> generacion ) {
		
		Collections.sort(
			generacion,
			(individuo1, individuo2) -> (int) (individuo2.getAptitud() * 10000 - individuo1.getAptitud() * 10000)
		);
		
	}
	
}
