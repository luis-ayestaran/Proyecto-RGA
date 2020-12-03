package buap.tec_ia.proyecto.algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import buap.tec_ia.proyecto.estructuras.Grafo;
import buap.tec_ia.proyecto.estructuras.Individuo;
import buap.tec_ia.proyecto.funciones.Fitness;
import buap.tec_ia.proyecto.funciones.OperadoresGeneticos;

public class GeneticoBidimensional {
	
	private static int contGen = 0;
	
	private List<List<Individuo>> poblacion;
	private Individuo mejorActual;
	Grafo grafo;
	
	
	public void crearGrafo( int vertices ) {
		
		grafo = new Grafo( vertices );
		
	}
	
	
	public void crearPoblacionInicial( int individuos ) {
		
		poblacion = new ArrayList<List<Individuo>>();
		
		List<Individuo> primeraGeneracion = new ArrayList<Individuo>();
		
		for( int i = 0; i < individuos; i++ ) {
			
			Individuo individuo = new Individuo( i, contGen, grafo.getVertices() );
			primeraGeneracion.add( individuo );
			
		}
		
		poblacion.add( primeraGeneracion );
		
		contGen++;
		
	}
	
	
	private void evaluarPoblacion() {
		
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		
		for( Individuo individuo : ultimaGeneracion ) {
			Fitness.funcionFitness(individuo, grafo);
		}
		
		Fitness.ordenarPorAptitud(ultimaGeneracion);
		
	}
	
	private void elegirMejorIndividuoActual() {
		
		
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		mejorActual = ultimaGeneracion.get(0);
		
	}
	
	
	private void cruzarIndividuos() {
		
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		Individuo padre = ultimaGeneracion.get(0);
		Individuo madre = ultimaGeneracion.get(1);
		List<Individuo> nuevaGeneracion = OperadoresGeneticos.funcionCruzamiento( contGen, padre, madre, ultimaGeneracion.size() );
		poblacion.add( nuevaGeneracion );
		
		contGen++;
		
	}
	
	
	private void mutarIndividuos() {
		
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		for( Individuo individuo : ultimaGeneracion ) {
			
			OperadoresGeneticos.funcionMutacion(individuo);
			
		}
		
	}
	
	
	private void actualizarIndividuos() {
		
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		for( Individuo individuo : ultimaGeneracion ) {
			
			OperadoresGeneticos.funcionMezcla(individuo);
			
		}
		
	}
	
	
	private boolean condicionParo( ) {
		
		boolean detener = false;
		
		if( contGen > 1 ) {
			
			
			List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
			
			Individuo mejorNuevo = obtenerMejorIndividuo( ultimaGeneracion );
			if(mejorNuevo != null) {
				System.out.println( "Mejor individuo actual: " + mejorNuevo );
				if(contGen > 135) {
					if( !mejoraRendimiento( mejorNuevo ) ) {
						detener = true;
						System.out.println( "\n\n***** SE DETIENE EL ALGORITMO *****\n" );
						System.out.println("Mejor resultado final:");
						StringBuilder sb = new StringBuilder();
						sb.append("Camino [ ");
						for(int vertice : mejorNuevo.getRecorrido()) {
							sb.append( vertice + ", ");
						}
						sb.append("]");
						System.out.println(sb.toString());
						System.out.println("Costo = " + (1 / mejorNuevo.getAptitud()));
					}
				}
			} else {
				System.out.println( "Mejor individuo actual: " + mejorActual );
			}
			
		}
		
		//System.out.println("Ha convergido " + detener);
		
		return detener;
		
	}
	
	
	private Individuo obtenerMejorIndividuo( List<Individuo> ultimaGeneracion ) {
		
		return ultimaGeneracion.get(0);
		
	}
	
	
	private boolean mejoraRendimiento( Individuo mejorNuevo ) {
		
		boolean mejoraAptitud = false;
		if( mejorNuevo.getAptitud() > mejorActual.getAptitud() ) {
			mejoraAptitud = true;
		}
		return mejoraAptitud;
		
	}
	
	public static void main( String[] args ) {
		
		GeneticoBidimensional rga = new GeneticoBidimensional();

		Scanner scanner = new Scanner( System.in );
		
		System.out.println("\nPASO 0: Creamos el grafo. ---------------------------------------------------------------\n");
		System.out.print("Número de vértices del grafo a generar: ");
		int vertices = scanner.nextInt();
		System.out.println();
		rga.crearGrafo( vertices );
		System.out.println("\nPASO 1: Generamos la poblacion inicial de individuos. -----------------------------------\n");
		System.out.print("Número de individuos de la primera generacion: ");
		int poblacionInicial = scanner.nextInt();
		System.out.println("NACE GENERACION " + contGen + ".\n\n");
		rga.crearPoblacionInicial( poblacionInicial );
		System.out.println("\nPASO 2: Evaluamos la poblacion para asignarle un valor de aptitud. ----------------------\n");
		rga.evaluarPoblacion();
		scanner.close();
		while( !rga.condicionParo() ) {
			
			rga.elegirMejorIndividuoActual();
			System.out.println("\nPASO 3: Cruzamos a los dos padres más aptos. --------------------------------------------\n");
			System.out.println("NACE GENERACION " + contGen + ".\n");
			rga.cruzarIndividuos();
			System.out.println("\nPASO 4: Aplicamos una mutacion con baja probabilidad. -----------------------------------\n");
			rga.mutarIndividuos();
			rga.actualizarIndividuos();
			System.out.println("\nPASO 5: Evaluamos la nueva generación. --------------------------------------------------\n");
			rga.evaluarPoblacion();
			
		}
		
		
	}
	
}
