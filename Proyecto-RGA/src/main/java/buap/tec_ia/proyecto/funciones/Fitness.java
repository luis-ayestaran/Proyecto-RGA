package buap.tec_ia.proyecto.funciones;

import java.util.Collections;
import java.util.List;

import buap.tec_ia.proyecto.estructuras.Grafo;
import buap.tec_ia.proyecto.estructuras.Individuo;

public class Fitness {
	
	
	public static final double inf = Double.POSITIVE_INFINITY;
	
	public static void funcionFitness(Individuo individuo, Grafo grafo) {
		
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

	
	public static void ordenarPorAptitud( List<Individuo> generacion ) {
		
		Collections.sort(
			generacion,
			(individuo1, individuo2) -> (int) (individuo2.getAptitud() * 10000 - individuo1.getAptitud() * 10000)
		);
		
	}

}

       
