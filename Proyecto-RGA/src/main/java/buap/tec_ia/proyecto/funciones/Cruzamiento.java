package buap.tec_ia.proyecto.funciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import buap.tec_ia.proyecto.daos.Conexion;
import buap.tec_ia.proyecto.daos.GenEstructural;
import buap.tec_ia.proyecto.daos.GenRegulador;
import buap.tec_ia.proyecto.estructuras.Individuo;
import buap.tec_ia.proyecto.estructuras.VectorConexiones;
import buap.tec_ia.proyecto.estructuras.VectorEstructural;
import buap.tec_ia.proyecto.estructuras.VectorRegulador;

public class Cruzamiento {
	
	public static List<Individuo> cruzar( int idGeneracion, Individuo padre, Individuo madre, int tamPoblacion) {
		
		List<Individuo> siguienteGeneracion = new ArrayList<Individuo>();
		
		int contadorHijos = 0;
		for( int i = 0; i < (tamPoblacion / 2) ; i++ ) {
			
			VectorRegulador cruzaRvHijo1 = crossover( padre, madre );
			
			Individuo hijo1 = new Individuo();
			hijo1.setIdIndividuo( contadorHijos );
			hijo1.setIdGeneracion(idGeneracion);
			contadorHijos++;
			hijo1.setRv( cruzaRvHijo1 );
			
			VectorRegulador cruzaRvHijo2 = crossover( padre, madre );
			
			Individuo hijo2 = new Individuo();
			hijo2.setIdIndividuo( contadorHijos );
			hijo2.setIdGeneracion(idGeneracion);
			contadorHijos++;
			hijo2.setRv( cruzaRvHijo2 );
			
			if( new Random().nextInt(10) < 5 ) {
				
				int[] recorridoHijo1 = new int[ padre.getRecorrido().length ];
				for( int j = 0; j < recorridoHijo1.length; j++ ) {
					
					recorridoHijo1[j] = padre.getRecorrido()[j];
					
				}
				
				VectorConexiones cvHijo1 = new VectorConexiones();
				for( int j = 0; j < padre.getCv().getConexiones().size(); j++ ) {
					cvHijo1.getConexiones().add( 
						new Conexion( 
							padre.getCv().getConexiones().get(j).getIdRg(),
							padre.getCv().getConexiones().get(j).getIdSg()
						) 
					);
				}
				
				VectorEstructural svHijo1 = new VectorEstructural();
				for( int j = 0; j < recorridoHijo1.length; j++ ) {
					
					svHijo1.getGenesEstructurales().add( new GenEstructural( recorridoHijo1[j] ) );
					
				}
				
				hijo1.setRecorrido( recorridoHijo1 );
				hijo1.setCv( cvHijo1 );
				hijo1.setSv( svHijo1 );
				
				
				int[] recorridoHijo2 = new int[ madre.getRecorrido().length ];
				for( int j = 0; j < recorridoHijo2.length; j++ ) {
					
					recorridoHijo2[j] = madre.getRecorrido()[j];
					
				}
				
				VectorConexiones cvHijo2 = new VectorConexiones();
				for( int j = 0; j < madre.getCv().getConexiones().size(); j++ ) {
					cvHijo2.getConexiones().add( 
						new Conexion( 
							madre.getCv().getConexiones().get(j).getIdRg(),
							madre.getCv().getConexiones().get(j).getIdSg()
						) 
					);
				}
				
				VectorEstructural svHijo2 = new VectorEstructural();
				for( int j = 0; j < recorridoHijo2.length; j++ ) {
					
					svHijo2.getGenesEstructurales().add( new GenEstructural( recorridoHijo2[j] ) );
					
				}
				hijo2.setRecorrido( recorridoHijo2 );
				hijo2.setCv( cvHijo2 );
				hijo2.setSv( svHijo2 );
				
			} else {
				
				int[] recorridoHijo1 = new int[ madre.getRecorrido().length ];
				for( int j = 0; j < recorridoHijo1.length; j++ ) {
					
					recorridoHijo1[j] = madre.getRecorrido()[j];
					
				}
				
				VectorConexiones cvHijo1 = new VectorConexiones();
				for( int j = 0; j < madre.getCv().getConexiones().size(); j++ ) {
					cvHijo1.getConexiones().add( 
						new Conexion( 
							madre.getCv().getConexiones().get(j).getIdRg(),
							madre.getCv().getConexiones().get(j).getIdSg()
						) 
					);
				}
				
				VectorEstructural svHijo1 = new VectorEstructural();
				for( int j = 0; j < recorridoHijo1.length; j++ ) {
					
					svHijo1.getGenesEstructurales().add( new GenEstructural( recorridoHijo1[j] ) );
					
				}
				
				hijo1.setRecorrido( recorridoHijo1 );
				hijo1.setCv( cvHijo1 );
				hijo1.setSv( svHijo1 );
				
				
				int[] recorridoHijo2 = new int[ padre.getRecorrido().length ];
				for( int j = 0; j < recorridoHijo2.length; j++ ) {
					
					recorridoHijo2[j] = padre.getRecorrido()[j];
					
				}
				
				VectorConexiones cvHijo2 = new VectorConexiones();
				for( int j = 0; j < padre.getCv().getConexiones().size(); j++ ) {
					cvHijo2.getConexiones().add( 
						new Conexion( 
							padre.getCv().getConexiones().get(j).getIdRg(),
							padre.getCv().getConexiones().get(j).getIdSg()
						) 
					);
				}
				
				VectorEstructural svHijo2 = new VectorEstructural();
				for( int j = 0; j < recorridoHijo2.length; j++ ) {
					
					svHijo2.getGenesEstructurales().add( new GenEstructural( recorridoHijo2[j] ) );
					
				}
				hijo2.setRecorrido( recorridoHijo2 );
				hijo2.setCv( cvHijo2 );
				hijo2.setSv( svHijo2 );
				
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
