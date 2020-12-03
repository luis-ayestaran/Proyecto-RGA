package buap.tec_ia.proyecto.algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import buap.tec_ia.proyecto.estructuras.DefGrafo;
import buap.tec_ia.proyecto.estructuras.Sujeto;
import buap.tec_ia.proyecto.funciones.OperadoresGeneticos;
import buap.tec_ia.proyecto.utils.Aleatorio;

public class GeneticoBidimensional {
	
	private static int contGen = 0;
	private List<List<Sujeto>> pob;
	private Sujeto mejAct;
	DefGrafo grafo;
	
	
	public void iniGrafo( int nVertices ) {
		grafo = new DefGrafo( nVertices );
	}
	
	
	public void iniPob( int sujetos ) {
		pob = new ArrayList<List<Sujeto>>();
		List<Sujeto> primGen = new ArrayList<Sujeto>();
		for( int i = 0; i < sujetos; i++ ) {
			Sujeto sujeto = new Sujeto( i, contGen, grafo.getVertices() );
			primGen.add( sujeto );
		}
		pob.add( primGen );
		contGen++;
	}
	
	
	private void eval() {
		List<Sujeto> nuevaGen = pob.get( pob.size() - 1 );
		for( Sujeto sujeto : nuevaGen ) {
			OperadoresGeneticos.eval(sujeto, grafo);
		}
		OperadoresGeneticos.ordenar(nuevaGen);
		
	}
	
	private void getMejSujAct() {
		List<Sujeto> ultimaGeneracion = pob.get( pob.size() - 1 );
		mejAct = ultimaGeneracion.get(0);
	}
	
	
	private void cruzar() {
		List<Sujeto> genActual = pob.get( pob.size() - 1 );
		Sujeto padre = genActual.get(0);
		Sujeto madre = genActual.get(1);
		List<Sujeto> nuevaGen = OperadoresGeneticos.cruzar( contGen, padre, madre, genActual.size() );
		pob.add( nuevaGen );
		contGen++;
	}
	
	
	private void mutar() {
		List<Sujeto> genActual = pob.get( pob.size() - 1 );
		for( Sujeto sujeto : genActual ) {
			OperadoresGeneticos.mutar(sujeto);
		}
	}
	
	
	private void actualizarIndividuos() {
		List<Sujeto> genActual = pob.get( pob.size() - 1 );
		for( Sujeto sujeto : genActual ) {
			OperadoresGeneticos.mezclar(sujeto);
		}
	}
	
	
	private boolean detener( ) {
		boolean detener = false;
		if( contGen > 1 ) {
			List<Sujeto> ultimaGeneracion = pob.get( pob.size() - 1 );
			Sujeto mejorNuevo = obtenerMejorIndividuo( ultimaGeneracion );
			if(mejorNuevo != null) {
				System.out.println( "Individuo más óptimo de la generación " + contGen + ": " + mejorNuevo );
				if(contGen > 100) {
					if( !mejoraRendimiento( mejorNuevo ) ) {
						detener = true;
						System.out.println( "\n\n----------\n SOLUCIÓN \n----------\n" );
						System.out.println("Mejor resultado final:");
						StringBuilder sb = new StringBuilder();
						sb.append("Camino: ");
						for(int vertice : mejorNuevo.getRecorrido()) {
							sb.append( vertice + ", ");
						}
						System.out.println(sb.toString());
						System.out.println("Costo = " + (1 / mejorNuevo.getAptitud()));
						System.out.println("Aptitud = " + (mejorNuevo.getAptitud() * 100) + "%");
					}
				}
			} else {
				System.out.println( "Mejor individuo : " + mejAct );
			}
		}
		return detener;
		
	}
	
	
	private Sujeto obtenerMejorIndividuo( List<Sujeto> ultimaGeneracion ) {
		return ultimaGeneracion.get(0);
	}
	
	
	private boolean mejoraRendimiento( Sujeto mejorNuevo ) {
		boolean mejoraAptitud = false;
		if( mejorNuevo.getAptitud() > mejAct.getAptitud() ) {
			mejoraAptitud = true;
		}
		return mejoraAptitud;
	}
	
	public static void main( String[] args ) {
		GeneticoBidimensional rga = new GeneticoBidimensional();
		Scanner scanner = new Scanner( System.in );
		System.out.println("\nALGORITMO GENETICO BIDIMENSIONAL");
		System.out.println("Problema del algoritmo de expansión mínima");
		System.out.print("\nNúmero de vértices del grafo a generar: ");
		int vertices = scanner.nextInt();
		System.out.println();
		rga.iniGrafo( vertices );
		int poblacionInicial = Aleatorio.generaNumeroAleatorio(0, 40);
		System.out.println("\nNace generacion " + contGen + ": " + poblacionInicial + " individuos.");
		rga.iniPob( poblacionInicial );
		rga.eval();
		System.out.println("Generacion " + contGen + " evaluada.\n\n");
		scanner.close();
		while( !rga.detener() ) {
			rga.getMejSujAct();
			rga.cruzar();
			System.out.println("\nNace generacion " + contGen + ": " + poblacionInicial + " individuos.");
			rga.mutar();
			rga.actualizarIndividuos();
			rga.eval();
			System.out.println("Generacion " + contGen + " evaluada.\n");
		}
	}
}
