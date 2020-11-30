package buap.tec_ia.proyecto.utils;

import java.util.Random;

public class NumerosAleatorios {
	
	private static Random generadorRandom = new Random();		//Generador de numeros aleatorios
	
	//METODO que genera un vector lleno de numeros aleatorios no repetidos entre 0 y length - 1
	public static int[] generaAleatoriosNoRepetidos(int longitud) {	
		
		int[] numerosAleatorios = new int[longitud];					//Se crea el vector de longitud length
		
		int valoresGenerados = 0;										//Inicializamos el contador de valores no repetidos generados
		int blankSpacePosition = generaNumeroAleatorio(0, longitud);	//Debido a que randomGenerator no obtiene 0, calculamos aleatoriamente la posicion donde lo insertaremos arbitratiamente
		while(valoresGenerados < longitud) {							//Mientras no se haya llenado el vector
			
			if(valoresGenerados != blankSpacePosition) {				//Si el índice apunta a una posicion que no es donde insertaremos el 0 
				int numeroAleatorio = generaNumeroAleatorio(0, longitud);	//Generamos un numero aleatorio entre 1 y length - 1
				if( !numeroEstaRepetido(numerosAleatorios, numeroAleatorio) ) {	//Y si no esta repetido
					numerosAleatorios[valoresGenerados] = numeroAleatorio;		//Lo guardamos en el vector
					valoresGenerados++;
				}
			} else {													//Si el índice apunta a la posición donde insertaremos el 0
				numerosAleatorios[valoresGenerados] = 0;						//Insertamos el 0 en el vector
				valoresGenerados++;
			}
			
		}
		
		return numerosAleatorios;
	}
	
	
	//METODO que devuelve un número aleatorio en un rango entre minValue y maxValue
	public static int generaNumeroAleatorio(int minValor, int maxValor) {
		
		int numeroGenerado = generadorRandom.nextInt(maxValor);			//Obtenemos un numero aleatorio mayor a 0 y menor a maxValue
		return numeroGenerado;
		
	}
	
	
	//METODO que devuelve un booleano que indica si newNumber ya esta repetido con algún valor en el vector storedNumbers
	private static boolean numeroEstaRepetido(int[] numerosAlmacenados, int nuevoNumero) {
		
		boolean repetido = false;					//Suponemos que no se encuentra repetido
		for(int numero : numerosAlmacenados) {			//Para cada numero del vector
			if(numero == nuevoNumero) {				//Si el número está repetido
				repetido = true;					//Cambiamos la bandera
				break;								//Y rompemos el ciclo
			}
		}
		return repetido;
		
	}
	
}
