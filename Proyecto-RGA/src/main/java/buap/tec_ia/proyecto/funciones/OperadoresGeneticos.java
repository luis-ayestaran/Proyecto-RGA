package buap.tec_ia.proyecto.funciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import buap.tec_ia.proyecto.daos.Co;
import buap.tec_ia.proyecto.daos.SG;
import buap.tec_ia.proyecto.daos.RG;
import buap.tec_ia.proyecto.estructuras.DefGrafo;
import buap.tec_ia.proyecto.estructuras.Sujeto;
import buap.tec_ia.proyecto.estructuras.CV;
import buap.tec_ia.proyecto.estructuras.SV;
import buap.tec_ia.proyecto.estructuras.RV;

public class OperadoresGeneticos {
	
	public static final double inf = Double.POSITIVE_INFINITY;
	
	public static void eval(Sujeto individuo, DefGrafo grafo) {
		
		double costoTotal=0;
	    int bandera=0;
	    int valor;
	    int repetido=0;
	    boolean camino=false;
	    boolean band=false;

		for(int i=0;i<individuo.getRecorrido().length;i++) {
			
			if(individuo.getRecorrido()[i]<0 || individuo.getRecorrido()[i]>=individuo.getRecorrido().length) {
				
				individuo.setAptitud((float) (1.0/inf));
				band=true;
				break;
				
			}
			
		}
		
		valor=individuo.getRecorrido()[0];
		do {
			
			for(int i=0; i<individuo.getRecorrido().length; i++) {
				 
				if(individuo.getRecorrido()[i]==valor) {
					
					repetido=repetido+1;
					
				}
				
			}
			bandera=bandera+1;
			valor=individuo.getRecorrido()[bandera];
			if(repetido>=2) {
				individuo.setAptitud((float) (1.0/inf));
				band=true;
				break;
			}
			repetido=0;
		}while(bandera!=(individuo.getRecorrido().length-1));
		
		if(band==false){
		int[] costoAristas = grafo.calcularCostoAristas(individuo.getRecorrido());
		for(int i=0;i<costoAristas.length;i++) {
			
			if(costoAristas[i]!=-1) {
				costoTotal=costoAristas[i]+costoTotal;
				camino=false;
			} else {
				individuo.setAptitud((float) (1.0/inf));
				camino=true;
				break;
			}

		    
		}
		if(camino==false) {
			individuo.setAptitud((float) (1.0/costoTotal));
		  }
		
	   }

     }

	
	public static void ordenar( List<Sujeto> generacion ) {
		Collections.sort(
			generacion,
			(individuo1, individuo2) -> (int) (individuo2.getAptitud() * 10000 - individuo1.getAptitud() * 10000)
		);
	}
	
	public static List<Sujeto> cruzar( int idGeneracion, Sujeto padre, Sujeto madre, int tamPoblacion) {
		List<Sujeto> siguienteGeneracion = new ArrayList<Sujeto>();
		int contadorHijos = 0;
		for( int i = 0; i < (tamPoblacion / 2) ; i++ ) {
			
			RV cruzaRvHijo1 = crossover( padre, madre );
			
			Sujeto hijo1 = new Sujeto();
			hijo1.setIdIndividuo( contadorHijos );
			hijo1.setIdGeneracion(idGeneracion);
			contadorHijos++;
			hijo1.setRv( cruzaRvHijo1 );
			
			RV cruzaRvHijo2 = crossover( padre, madre );
			
			Sujeto hijo2 = new Sujeto();
			hijo2.setIdIndividuo( contadorHijos );
			hijo2.setIdGeneracion(idGeneracion);
			contadorHijos++;
			hijo2.setRv( cruzaRvHijo2 );
			
			if( new Random().nextInt(10) < 5 ) {
				
				int[] recorridoHijo1 = new int[ padre.getRecorrido().length ];
				for( int j = 0; j < recorridoHijo1.length; j++ ) {
					
					recorridoHijo1[j] = padre.getRecorrido()[j];
					
				}
				
				CV cvHijo1 = new CV();
				for( int j = 0; j < padre.getCv().getConexiones().size(); j++ ) {
					cvHijo1.getConexiones().add( 
						new Co( 
							padre.getCv().getConexiones().get(j).getIdRg(),
							padre.getCv().getConexiones().get(j).getIdSg()
						) 
					);
				}
				
				SV svHijo1 = new SV();
				for( int j = 0; j < recorridoHijo1.length; j++ ) {
					
					svHijo1.getGenesEstructurales().add( new SG( recorridoHijo1[j] ) );
					
				}
				
				hijo1.setRecorrido( recorridoHijo1 );
				hijo1.setCv( cvHijo1 );
				hijo1.setSv( svHijo1 );
				
				
				int[] recorridoHijo2 = new int[ madre.getRecorrido().length ];
				for( int j = 0; j < recorridoHijo2.length; j++ ) {
					
					recorridoHijo2[j] = madre.getRecorrido()[j];
					
				}
				
				CV cvHijo2 = new CV();
				for( int j = 0; j < madre.getCv().getConexiones().size(); j++ ) {
					cvHijo2.getConexiones().add( 
						new Co( 
							madre.getCv().getConexiones().get(j).getIdRg(),
							madre.getCv().getConexiones().get(j).getIdSg()
						) 
					);
				}
				
				SV svHijo2 = new SV();
				for( int j = 0; j < recorridoHijo2.length; j++ ) {
					
					svHijo2.getGenesEstructurales().add( new SG( recorridoHijo2[j] ) );
					
				}
				hijo2.setRecorrido( recorridoHijo2 );
				hijo2.setCv( cvHijo2 );
				hijo2.setSv( svHijo2 );
				
			} else {
				
				int[] recorridoHijo1 = new int[ madre.getRecorrido().length ];
				for( int j = 0; j < recorridoHijo1.length; j++ ) {
					
					recorridoHijo1[j] = madre.getRecorrido()[j];
					
				}
				
				CV cvHijo1 = new CV();
				for( int j = 0; j < madre.getCv().getConexiones().size(); j++ ) {
					cvHijo1.getConexiones().add( 
						new Co( 
							madre.getCv().getConexiones().get(j).getIdRg(),
							madre.getCv().getConexiones().get(j).getIdSg()
						) 
					);
				}
				
				SV svHijo1 = new SV();
				for( int j = 0; j < recorridoHijo1.length; j++ ) {
					
					svHijo1.getGenesEstructurales().add( new SG( recorridoHijo1[j] ) );
					
				}
				
				hijo1.setRecorrido( recorridoHijo1 );
				hijo1.setCv( cvHijo1 );
				hijo1.setSv( svHijo1 );
				
				
				int[] recorridoHijo2 = new int[ padre.getRecorrido().length ];
				for( int j = 0; j < recorridoHijo2.length; j++ ) {
					
					recorridoHijo2[j] = padre.getRecorrido()[j];
					
				}
				
				CV cvHijo2 = new CV();
				for( int j = 0; j < padre.getCv().getConexiones().size(); j++ ) {
					cvHijo2.getConexiones().add( 
						new Co( 
							padre.getCv().getConexiones().get(j).getIdRg(),
							padre.getCv().getConexiones().get(j).getIdSg()
						) 
					);
				}
				
				SV svHijo2 = new SV();
				for( int j = 0; j < recorridoHijo2.length; j++ ) {
					
					svHijo2.getGenesEstructurales().add( new SG( recorridoHijo2[j] ) );
					
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
	
	private static RV crossover( Sujeto padre, Sujeto madre ) {
		
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
		
		RV rvCruzado = new RV();
		
		for(int i = 0; i < cromosomasMadre; i++) {
			
			rvCruzado.getGenesReguladores().add( new RG( rvMadre[i] ) );
			
		}
		
		for(int i = cromosomasMadre; i < rvPadre.length; i++) {
			
			rvCruzado.getGenesReguladores().add( new RG( rvPadre[i] ) );
			
		}
		
		return rvCruzado;
		
	}
	
	
	public static void mutar(Sujeto individuo) {
		
		int posi;
		
		Random generadorRandom = new Random();
		if(generadorRandom.nextInt(1000) < 250) {
			
			posi = new Random().nextInt( individuo.getRv().getGenesReguladores().size() );
			if(individuo.getRv().getGenesReguladores().get(posi).getValor()==1) {
				individuo.getRv().getGenesReguladores().get(posi).setValor(0);
			}else {
				individuo.getRv().getGenesReguladores().get(posi).setValor(1);
			}
			
		}

	}
	
	
	public static void mezclar(Sujeto individuo) {
		
		int idrg, idsg;
		int contador = 0;
		
		for(int i = 0; i < individuo.getCv().getConexiones().size(); i++) {
			
			idrg = individuo.getCv().getConexiones().get(i).getIdRg();
			if( individuo.getRv().getGenesReguladores().get(idrg).getValor() == 1 ){
				
				idrg = individuo.getCv().getConexiones().get(i).getIdRg();
				idsg=individuo.getCv().getConexiones().get(i).getIdSg();
				contador = contador + 1;
				
			}
			
		}
		
		int[] idSg = new int[contador];
		Integer[] vsg = new Integer[contador];
		int p = 0;
		
		for(int i = 0; i < individuo.getCv().getConexiones().size(); i++) {
			idrg = individuo.getCv().getConexiones().get(i).getIdRg();
			if(individuo.getRv().getGenesReguladores().get(idrg).getValor() == 1){
				idrg = individuo.getCv().getConexiones().get(i).getIdRg();
				idsg = individuo.getCv().getConexiones().get(i).getIdSg();
				idSg[p] = idsg;
				vsg[p] = individuo.getSv().getGenesEstructurales().get(idsg).getValor();
				p++;
			}
		}
		
		List<Integer> valoresSG = Arrays.asList( vsg );
		Collections.shuffle(valoresSG);
		valoresSG.toArray(vsg);
		
		for( int i = 0; i < idSg.length; i++ ) {
			
			individuo.getSv().getGenesEstructurales().get(idSg[i]).setValor(vsg[i]);
			
		}

		for( int i = 0; i < individuo.getRecorrido().length; i++ ) {
			
			individuo.getRecorrido()[i] = individuo.getSv().getGenesEstructurales().get(i).getValor();
			
		}
		
	}
	
}
