package buap.tec_ia.proyecto.funciones;

import org.junit.Test;

import buap.tec_ia.proyecto.estructuras.Sujeto;

public class MutacionTest {
	@Test
    public void test() {
    	Sujeto individuo = new Sujeto(0, 0, 30);
    	OperadoresGeneticos.mutar(individuo);
    }
}