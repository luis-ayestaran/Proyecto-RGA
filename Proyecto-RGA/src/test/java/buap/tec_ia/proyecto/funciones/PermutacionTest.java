package buap.tec_ia.proyecto.funciones;

import org.junit.Test;

import buap.tec_ia.proyecto.algoritmos.RecorridosGrafos;
import buap.tec_ia.proyecto.estructuras.Individuo;

public class PermutacionTest {
	@Test
    public void test() {
    	Individuo individuo = new Individuo(0, 5);
    	//RecorridosGrafos grafo = new RecorridosGrafos(20);
    	Permutacion.funcionPermutacion(individuo);
    }

}