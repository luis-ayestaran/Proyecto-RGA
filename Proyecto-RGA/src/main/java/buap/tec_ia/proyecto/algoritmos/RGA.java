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
	private static int contadorGeneracional = 0;
	
	
	public RGA() {
		
		inicializar();
		
	}
	
	
	public void inicializar() {
		
		crearGrafo( 6 );
		crearPoblacionInicial(60);
		//evaluarPoblacion();
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
			
			Individuo individuo = new Individuo( i, grafo.getGrafo().getVertices() );
			primeraGeneracion.add( individuo );
			
			System.out.println( individuo );
			
		}
		
		poblacion.add( primeraGeneracion );
		
		contadorGeneracional++;
		
	}
	
	
	private void evaluarPoblacion() {
		
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		
		for( Individuo individuo : ultimaGeneracion ) {
			
			//Fitness.evaluarIndividuo(individuo);
			
		}
		
		
		
	}
	
	
	/*private boolean condicionParo( ) {
		
		boolean detener = false;
		List<Individuo> ultimaGeneracion = poblacion.get( poblacion.size() - 1 );
		
		Individuo mejorNuevo = obtenerMejorIndividuo(  ); 
		if(mejorNuevo != null) {
			if( !mejoraRendimiento( mejorNuevo ) ) {
				detener = true;
			}
		}
		return detener;
		
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
		
	}*/
	
}
