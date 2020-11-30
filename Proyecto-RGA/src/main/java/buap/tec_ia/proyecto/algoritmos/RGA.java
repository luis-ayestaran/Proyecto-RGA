package buap.tec_ia.proyecto.algoritmos;

import java.util.ArrayList;
import java.util.List;

import buap.tec_ia.proyecto.estructuras.Individuo;
import buap.tec_ia.proyecto.utils.NumerosAleatorios;

public class RGA {
	
	
	RecorridosGrafos grafo;
	private List<List<Individuo>> poblacion;
	
	public RGA() {
		
		inicializar();
		
	}
	
	public void inicializar() {
		
		crearGrafo( 12 );
		crearPoblacionInicial(60);
		//evaluarPoblacionInicial()
		//while( !condicionParo() ) {
		//	funciones_geneticas();
		//}
		
	}
	
	
	public void crearGrafo( int vertices ) {
		
		grafo = new RecorridosGrafos( vertices );
		
	}
	
	
	public void crearPoblacionInicial( int individuos ) {
		
		poblacion = new ArrayList<List<Individuo>>();
		
		List<Individuo> primeraGeneracion = new ArrayList<Individuo>();
		
		for( int i = 0; i < individuos; i++ ) {
		
			int[] recorrido = NumerosAleatorios.generaAleatoriosNoRepetidos( grafo.getGrafo().getVertices() );
			
			Individuo individuo = new Individuo( recorrido );
			primeraGeneracion.add( individuo );
			
			System.out.println( individuo );
			
			
			/*System.out.println("Individuo " + (i + 1) + ":");
			for( int numero : recorrido ) {
				System.out.print(numero + " ");
			}
			System.out.println("\n");
				
			int[] costoAristas = grafo.calcularCostoAristas( recorrido );
			
			System.out.println("Aristas: ");
			for( int costo : costoAristas ) {
				System.out.print(costo + " ");
			}
			System.out.println("\n-------------------------------\n");*/
			
		}
		
		
		
	}
	
}
