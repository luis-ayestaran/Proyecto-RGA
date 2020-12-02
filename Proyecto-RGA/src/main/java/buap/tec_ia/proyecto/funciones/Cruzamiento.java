package buap.tec_ia.proyecto.funciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import buap.tec_ia.proyecto.daos.GenRegulador;
import buap.tec_ia.proyecto.estructuras.Individuo;
import buap.tec_ia.proyecto.estructuras.VectorRegulador;

public class Cruzamiento {
	
	public static List<Individuo> cruzar( Individuo padre, Individuo madre, int tamPoblacion) {
		
		List<Individuo> siguienteGeneracion = new ArrayList<Individuo>();
		
		int contadorHijos = 0;
		for( int i = 0; i < (tamPoblacion / 2) ; i++ ) {
			
			VectorRegulador cruzaRvHijo1 = crossover( padre, madre );
			
			Individuo hijo1 = new Individuo();
			hijo1.setIdIndividuo( contadorHijos );
			contadorHijos++;
			hijo1.setRv( cruzaRvHijo1 );
			
			VectorRegulador cruzaRvHijo2 = crossover( padre, madre );
			
			Individuo hijo2 = new Individuo();
			hijo2.setIdIndividuo( contadorHijos );
			contadorHijos++;
			hijo2.setRv( cruzaRvHijo2 );
			
			if( new Random().nextInt(10) < 5 ) {
				
				hijo1.setRecorrido( padre.getRecorrido() );
				hijo1.setCv( padre.getCv() );
				hijo1.setSv( padre.getSv() );
				hijo2.setRecorrido( madre.getRecorrido() );
				hijo2.setCv( madre.getCv() );
				hijo2.setSv( padre.getSv() );
				
			} else {
				
				hijo1.setRecorrido( madre.getRecorrido() );
				hijo1.setSv( padre.getSv() );
				hijo1.setCv( padre.getCv() );
				hijo2.setRecorrido( padre.getRecorrido() );
				hijo2.setSv( madre.getSv() );
				hijo2.setCv( padre.getCv() );
				
			}
			
			
			
			siguienteGeneracion.add( hijo1 );
			siguienteGeneracion.add( hijo2 );
			
		}
		
		return siguienteGeneracion;
		
	}
	
	private static VectorRegulador crossover( Individuo padre, Individuo madre ) {
		
		int[] rvPadre = new int[ padre.getRv().getGenesReguladores().size() ];
		int[] rvMadre = new int[ madre.getRv().getGenesReguladores().size() ];
		
		for( int i = 0; i < rvPadre.length; i++ ) {
			rvPadre[i] = padre.getRv().getGenesReguladores().get(i).getValor();
		}
		for( int i = 0; i < rvPadre.length; i++ ) {
			rvMadre[i] = madre.getRv().getGenesReguladores().get(i).getValor();
		}
		
		int cromosomasPadre = new Random().nextInt( rvPadre.length );
		int cromosomasMadre = rvMadre.length - cromosomasPadre;
		
		VectorRegulador rvCruzado = new VectorRegulador();
		
		for(int i = 0; i < cromosomasMadre; i++) {
			
			rvCruzado.getGenesReguladores().add( new GenRegulador( rvMadre[i] ) );
			
		}
		
		for(int i = cromosomasMadre; i < rvPadre.length; i++) {
			
			rvCruzado.getGenesReguladores().add( new GenRegulador( rvPadre[i] ) );
			
		}
		
		return rvCruzado;
		
	}
	
}
