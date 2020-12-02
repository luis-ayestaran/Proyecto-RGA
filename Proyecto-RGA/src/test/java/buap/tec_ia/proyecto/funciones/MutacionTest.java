package buap.tec_ia.proyecto.funciones;

import org.junit.Test;

import buap.tec_ia.proyecto.estructuras.Individuo;

public class MutacionTest {
	@Test
    public void test() {
    	Individuo individuo = new Individuo(0, 30);
    	Mutacion.funcionMutacion(individuo);
    }
}