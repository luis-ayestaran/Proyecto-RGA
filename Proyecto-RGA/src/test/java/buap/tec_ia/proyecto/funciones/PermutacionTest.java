package buap.tec_ia.proyecto.funciones;

import org.junit.Test;

import buap.tec_ia.proyecto.estructuras.Sujeto;

public class PermutacionTest {
	@Test
    public void test() {
    	Sujeto individuo = new Sujeto(0, 0, 12);
    	//RecorridosGrafos grafo = new RecorridosGrafos(20);
    	OperadoresGeneticos.mezclar(individuo);
    }

}
