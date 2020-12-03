package buap.tec_ia.proyecto.estructuras;

import java.util.Random;
import java.util.Scanner;

public class DefGrafo {
	
	private int[][] costos;
	private int vertices;
	
	public int[][] getCostos() {
		return costos;
	}
	public void setCostos(int[][] costos) {
		this.costos = costos;
	}
	public int getVertices() {
		return vertices;
	}
	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public DefGrafo() {}
	
	public DefGrafo( int vertices ) { 
		this.vertices = vertices;
		init( vertices );
	}
	
	
	public void init( int vertices ) {
		
		leeDatos( vertices );
		//aleatoriamente( vertices );
		
	}
	
	private void imprimir_matriz(int [][]costos ) {
		System.out.println("GRAFO GENERADO" );
		System.out.println("\n");
		for (int x = 0; x < costos.length; x++) {
	    	System.out.print("\t");
			  for (int y = 0; y < costos[x].length; y++) {
				    System.out.print(costos[x][y] + "\t ");
				  }
			  System.out.println("");
		}
		System.out.println("\n");
	}
	
	private void leeDatos( int vertices ) {
		
		Scanner sc = new Scanner(System.in);
	    costos = new int[vertices][vertices];
		for (int x=0; x < costos.length; x++) {
			  for (int y=0; y < costos[x].length; y++) {
				  costos[x][y] = -2;
			  }
			}	
		for (int x=0; x < costos.length; x++) {
			  for (int y=0; y < costos[x].length; y++) {
			  	  if((costos[x][y]==-2) && (x!=y)) {
					  System.out.print("Proporciona el costo entre los vertices " + (x + 1) + " y " + (y + 1) + ": ");
					  costos[x][y] = sc.nextInt();
					  costos[y][x] = costos[x][y];
				  }
			  	  else if(x==y) {
			  		costos[x][y] = -1;
			  	  }
			  }
			}
		
		System.out.println("\n");
		
		sc.close();
		imprimir_matriz(costos);
	      
		
	}
	
	private void aleatoriamente(int vertices) {
		
		costos = new int[vertices][vertices];
		
		for (int x=0; x < costos.length; x++) {
			for (int y=0; y < costos[x].length; y++) {
				costos[x][y] = -2;
			}
		}
		
		for (int x=0; x < costos.length; x++) {
			for (int y=0; y < costos[x].length; y++) {
				if((costos[x][y]==-2) && (x!=y)) {
					costos[x][y] = (int)(Math.random()*10+(-2));
					if( costos[x][y] == 0 ) {
						costos[x][y] = new Random().nextInt( 7 ) + 1;
					}
					costos[y][x] = costos[x][y];
				} else if(x==y) {
					costos[x][y] = -1;
				}
			}
		}
		
		imprimir_matriz(costos);
				
	}
	
	public int[] calcularCostoAristas( int[] recorrido ) {
		
		int[] costoAristas = new int[ recorrido.length - 1 ];
		for( int i = 0; i < recorrido.length - 1; i++ ) {
			
			costoAristas[ i ] = costos[ recorrido[i] ][ recorrido[i + 1] ];
			
		}
		return costoAristas;
		
	}
 
}
