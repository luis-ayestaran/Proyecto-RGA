package buap.tec_ia.proyecto.algoritmos;

import java.util.List;

import buap.tec_ia.proyecto.estructuras.Grafo;
import buap.tec_ia.proyecto.estructuras.Individuo;
import buap.tec_ia.proyecto.estructuras.VectorConexiones;
import buap.tec_ia.proyecto.estructuras.VectorEstructural;
import buap.tec_ia.proyecto.estructuras.VectorRegulador;
import buap.tec_ia.proyecto.utils.NumerosAleatorios;

public class RGA {
	
	private Grafo grafo;
	private List<List<Individuo>> poblacion;
	
	public RGA() {
		
		inicializar();
		
	}
	
	public void inicializar() {
		
		//crearGrafo();
		crearPoblacionInicial(20);
		//evaluarPoblacionInicial()
		//while( !condicionParo() ) {
		//	Todo el proceso del algoritmo genetico
		//}
		
	}
	
	
	public void crearPoblacionInicial( int individuos ) {
		
		for( int i = 0; i < individuos; i++ ) {
		
			int[] numerosAleatorios = NumerosAleatorios.generaAleatoriosNoRepetidos( 10 );
			
			System.out.println("Individuo " + (i + 1) + ":");
			for( int numero : numerosAleatorios ) {
				System.out.print(numero + " ");
			}
			System.out.println("\n");
			
		}
		
	}
	
}
