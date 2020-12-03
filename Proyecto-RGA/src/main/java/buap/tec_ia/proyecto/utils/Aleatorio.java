package buap.tec_ia.proyecto.utils;

import java.util.Random;

public class Aleatorio {
	
	private static Random generadorRandom = new Random();
	
	public static int[] generaRecorrido(int longitud) {	
		int[] numerosAleatorios = new int[longitud];
		int valoresGenerados = 0;					
		int blankSpacePosition = generaNumeroAleatorio(0, longitud);
		while(valoresGenerados < longitud) {							
			if(valoresGenerados != blankSpacePosition) {				 
				int numeroAleatorio = generaNumeroAleatorio(0, longitud);	
				if( !numeroEstaRepetido(numerosAleatorios, numeroAleatorio) ) {	
					numerosAleatorios[valoresGenerados] = numeroAleatorio;		
					valoresGenerados++;
				}
			} else {													
				numerosAleatorios[valoresGenerados] = 0;						
				valoresGenerados++;
			}
		}
		return numerosAleatorios;
	}
	
	
	public static int generaNumeroAleatorio(int minValor, int maxValor) {
		int numeroGenerado = generadorRandom.nextInt(maxValor);		
		return numeroGenerado;
	}
	

	private static boolean numeroEstaRepetido(int[] numerosAlmacenados, int nuevoNumero) {		
		boolean repetido = false;					
		for(int numero : numerosAlmacenados) {		
			if(numero == nuevoNumero) {				
				repetido = true;					
				break;								
			}
		}
		return repetido;
	}
	
}