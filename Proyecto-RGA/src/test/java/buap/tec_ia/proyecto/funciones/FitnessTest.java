package buap.tec_ia.proyecto.funciones;

import org.junit.Test;

import buap.tec_ia.proyecto.estructuras.DefGrafo;
import buap.tec_ia.proyecto.estructuras.Sujeto;

public class FitnessTest {
	
	@Test
    public void test() {
    	Sujeto sujeto = new Sujeto(0, 0, 5);
    	DefGrafo grafo = new DefGrafo(5);
    	OperadoresGeneticos.eval(sujeto,grafo);
    }
}


