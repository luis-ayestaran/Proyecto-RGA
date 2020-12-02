package buap.tec_ia.proyecto.funciones;

import buap.tec_ia.proyecto.algoritmos.RecorridosGrafos;
import buap.tec_ia.proyecto.estructuras.Individuo;

public class Fitness {
	
	
	public static final double inf = Double.POSITIVE_INFINITY;
	
	public static void funcionFitness(Individuo individuo, RecorridosGrafos grafo) {
		
		double costoTotal=0;
	    int bandera=0;
	    int valor;
	    int repetido=0;
	    boolean camino=false;
	    boolean band=false;
	  //se valida que el vertice este dentro del rango
		for(int i=0;i<individuo.getRecorrido().length;i++) {
			
			//System.out.print(individuo.getRecorrido()[i] +"\t"); //nodos que se visitaron del grafo
			if(individuo.getRecorrido()[i]<0 || individuo.getRecorrido()[i]>=individuo.getRecorrido().length) {
				
				//System.out.println("Nodo fuera del rango\n");
				individuo.setAptitud((float) (1.0/inf));
				//System.out.println("Aptitud:"+individuo.getAptitud());
				band=true;
				break;
				
			}
			
		}
		//System.out.println("\n");
		
		//se valida que el vertice no este repetido
		valor=individuo.getRecorrido()[0];
		do {
			
			for(int i=0; i<individuo.getRecorrido().length; i++) {
				
				//System.out.print(individuo.getRecorrido()[i] +"\t"); 
				if(individuo.getRecorrido()[i]==valor) {
					
					repetido=repetido+1;
					
				}
				
			}
			bandera=bandera+1;
			valor=individuo.getRecorrido()[bandera];
			if(repetido>=2){
				//System.out.println("Nodo repetido \n");
				individuo.setAptitud((float) (1.0/inf));
				//System.out.println("Aptitud:"+individuo.getAptitud());
				band=true;
				break;
			}
			repetido=0;
		}while(bandera!=(individuo.getRecorrido().length-1));
		//System.out.println("\n");
		
		//validacion, camino existente, que no exista -1 en los costos
		
		if(band==false){
		int[] costoAristas = grafo.calcularCostoAristas(individuo.getRecorrido());
		//System.out.println("Costos:\n");
		for(int i=0;i<costoAristas.length;i++) {
			
			//System.out.print(costoAristas[i] +"\t");
			if(costoAristas[i]!=-1)
			{
				costoTotal=costoAristas[i]+costoTotal;
				camino=false;
			}else {
				individuo.setAptitud((float) (1.0/inf));
				camino=true;
				//System.out.println("Aptitud:"+individuo.getAptitud());
				break;
			}

		    
		}
		//System.out.println("\n");
		if(camino==false) {
			//System.out.println("Costo Total: " +costoTotal+ "\n");
			//System.out.println("\n");
			individuo.setAptitud((float) (1.0/costoTotal));
			//System.out.println("Aptitud:"+individuo.getAptitud());
		  }
	   }

     }


}

       
