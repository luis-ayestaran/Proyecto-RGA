package buap.tec_ia.proyecto.algoritmos;

import java.util.ArrayList;
import java.util.List;

import buap.tec_ia.proyecto.estructuras.Individuo;
import buap.tec_ia.proyecto.funciones.Fitness;
import buap.tec_ia.proyecto.utils.NumerosAleatorios;

public class RGA {
	
	
	RecorridosGrafos grafo;
	private List<List<Individuo>> poblacion;
	private Individuo mejorActual;
	
	public RGA() {
		
		inicializar();
		
	}
	
	public void inicializar() {
		
		crearGrafo( 12 );
		crearPoblacionInicial(60);
		evaluarPoblacion();
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
			
			Individuo individuo = new Individuo( grafo.getGrafo().getVertices() );
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
		
		poblacion.add( primeraGeneracion );
		
	}
	
	private void evaluarPoblacion() {
		
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		
		for( Individuo individuo : ultimaGeneracion ) {
			
			//Fitness.evaluarIndividuo(individuo);
			
		}
		
	}
	
	private boolean condicionParo(/* Individuo mejorNuevo */) {
		
		boolean detener = false;
		return detener;
		
	}
	
	/*private boolean generacionCambia() {
		
		boolean cambio = true;
		
		
		int[] mejorRecorridoActual = mejorActual.getRecorrido();
		//int[] mejorRecorridoNuevo =  mejorNuevo.getRecorrido();
		
		for( int i = 0; i < mejorActual.getRecorrido().length; i++ ) {
			
			if(  ) {
				
			}
			
			if(mejorRecorridoActual[i] != mejorRecorridoNuevo[i]) {
				iguales = false;
				break;
			}
			
		}
		
		return cambio;
		
	}
	
	private boolean mejoraRendimiento(// Individuo mejorNuevo ) {
		
		boolean mejoraAptitud = false;
		return mejoraAptitud;
		
	}*/
	
}
