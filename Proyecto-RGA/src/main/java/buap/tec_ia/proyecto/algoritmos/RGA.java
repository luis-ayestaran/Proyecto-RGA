package buap.tec_ia.proyecto.algoritmos;

import java.util.ArrayList;
import java.util.List;

import buap.tec_ia.proyecto.estructuras.Individuo;
import buap.tec_ia.proyecto.funciones.Cruzamiento;
import buap.tec_ia.proyecto.funciones.Fitness;
import buap.tec_ia.proyecto.funciones.Mutacion;
import buap.tec_ia.proyecto.funciones.Permutacion;

public class RGA {
	
	RecorridosGrafos grafo;
	private List<List<Individuo>> poblacion;
	private Individuo mejorActual;
	private static int contadorGeneracional = 0;
	
	
	public RGA() {
		
		inicializar();
		
	}
	
	
	public void inicializar() {
		
		crearGrafo( 14 );
		crearPoblacionInicial( 60 );
		evaluarPoblacion();
		while( !condicionParo() ) {
			
			elegirMejorIndividuoActual();
			cruzarIndividuos();
			mutarIndividuos();
			actualizarIndividuos();
			evaluarPoblacion();
			
		}
		
	}
	
	
	public void crearGrafo( int vertices ) {
		
		grafo = new RecorridosGrafos( vertices );
		
	}
	
	
	public void crearPoblacionInicial( int individuos ) {
		
		poblacion = new ArrayList<List<Individuo>>();
		
		List<Individuo> primeraGeneracion = new ArrayList<Individuo>();
		
		for( int i = 0; i < individuos; i++ ) {
			
			Individuo individuo = new Individuo( i, contadorGeneracional, grafo.getGrafo().getVertices() );
			primeraGeneracion.add( individuo );
			
		}
		
		poblacion.add( primeraGeneracion );
		
		contadorGeneracional++;
		
	}
	
	
	private void evaluarPoblacion() {
		
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		
		for( Individuo individuo : ultimaGeneracion ) {
			Fitness.funcionFitness(individuo, grafo);
		}
		
		Ordenamiento.ordenarPorAptitud(ultimaGeneracion);
		
	}
	
	private void elegirMejorIndividuoActual() {
		
		
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		mejorActual = ultimaGeneracion.get(0);		//Se obtiene el mejor individuo actual que servirá para la condición de paro
		
	}
	
	
	private void cruzarIndividuos() {
		
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		Individuo padre = ultimaGeneracion.get(0);
		Individuo madre = ultimaGeneracion.get(1);
		List<Individuo> nuevaGeneracion = Cruzamiento.cruzar( contadorGeneracional, padre, madre, ultimaGeneracion.size() );
		poblacion.add( nuevaGeneracion );
		
		contadorGeneracional++;
		
	}
	
	
	private void mutarIndividuos() {
		
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		for( Individuo individuo : ultimaGeneracion ) {
			
			Mutacion.funcionMutacion(individuo);
			
		}
		
	}
	
	
	private void actualizarIndividuos() {
		
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		for( Individuo individuo : ultimaGeneracion ) {
			
			Permutacion.funcionPermutacion(individuo);
			
		}
		
	}
	
	
	private boolean condicionParo( ) {
		
		boolean detener = false;
		
		if( contadorGeneracional > 1 ) {
			
			
			List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
			
			Individuo mejorNuevo = obtenerMejorIndividuo( ultimaGeneracion );
			System.out.println( mejorActual );
			System.out.println( mejorNuevo );
			if(mejorNuevo != null) {
				if(contadorGeneracional > 100) {
					if( !mejoraRendimiento( mejorNuevo ) ) {
						detener = true;
					}
				}
			}
			
		}
		
		//System.out.println("Ha convergido " + detener);
		
		return detener;
		
	}
	
	
	private Individuo obtenerMejorIndividuo( List<Individuo> ultimaGeneracion ) {
		
		return ultimaGeneracion.get(0);
		
	}
	
	
	private boolean nuevaGeneracionCambia( Individuo mejorNuevo ) {
		
		boolean cambia = false;
		int[] mejorRecorridoActual = mejorActual.getRecorrido();
		int[] mejorRecorridoNuevo =  mejorNuevo.getRecorrido();
		
		for( int i = 0; i < mejorActual.getRecorrido().length; i++ ) {
			
			if( mejorRecorridoActual[i] != mejorRecorridoNuevo[i] ) {
				cambia = true;
				break;
			}
			
		}
		
		return cambia;
		
	}
	
	private boolean mejoraRendimiento( Individuo mejorNuevo ) {
		
		boolean mejoraAptitud = false;
		if( mejorNuevo.getAptitud() > mejorActual.getAptitud() ) {
			mejoraAptitud = true;
		}
		return mejoraAptitud;
		
	}
	
}
