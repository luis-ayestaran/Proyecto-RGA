package buap.tec_ia.proyecto.estructuras;

import java.util.Scanner;

public class Grafo {
	
	private int[][] costos;
	private int vertices;
	
	public Grafo() {
		
		init();
		
	}
	
	
	public void init() {
		
		///leeDatos();
		//aleatoriamente();
		fijo();
		
	}
	
	private void imprimir_matriz(int [][]costos ) {
		//imprimir matriz de costos
		
				for (int x=0; x < costos.length; x++) {
			    	System.out.print("\t");
					  for (int y=0; y < costos[x].length; y++) {
						    System.out.print(costos[x][y] + " \t ");
						  }
					  System.out.println(" ");
						}
				
	}
	
	private void leeDatos() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Proporciona el numero de vertices: ");
	    vertices = sc.nextInt();
	    System.out.println("\n");
	    costos = new int[vertices][vertices];
		//se inicializa el vector de costos
		for (int x=0; x < costos.length; x++) {
			  for (int y=0; y < costos[x].length; y++) {
				  costos[x][y] = -2;
			  }
			}
		//llenado de la matriz de costos		
		for (int x=0; x < costos.length; x++) {
			  for (int y=0; y < costos[x].length; y++) {
			  	  if((costos[x][y]==-2) && (x!=y)) {
					  System.out.print("Proporciona el costo entre los vertices " + (x + 1) + " y " + (y + 1) + ": ");
					  //-1 si no existe camino
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
	
	private void aleatoriamente() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Proporciona el numero de vertices:");
		int vertices = sc.nextInt();
		System.out.println("\n");
		costos = new int[vertices][vertices];
		//se inicializa el vector de costos
				for (int x=0; x < costos.length; x++) {
					  for (int y=0; y < costos[x].length; y++) {
						  costos[x][y] = -2;
					  }
					}
				//llenado de la matriz de costos
				for (int x=0; x < costos.length; x++) {
					  for (int y=0; y < costos[x].length; y++) {
						  if((costos[x][y]==-2) && (x!=y)) {
							  costos[x][y] = (int)(Math.random()*10+(-1));
							  costos[y][x] = costos[x][y];
						  }else if(x==y){
							  costos[x][y] = -1;
						  }
					  }
					}		
				sc.close();
				//imprimir matriz de costos
				imprimir_matriz(costos);
				
	}
	
    private void fijo() {
    	
    	int[][] costos=
    	{ //  1 2 3 4 5 6 7
    		{-1,6,1,3,-1,-1,-1},
    		{6,-1,-1,-1,-1,-1,4},
    		{1,-1,-1,2,1,-1,2},
    		{3,-1,2,-1,1,-1,-1},
    		{-1,-1,1,1,-1,2,-1},
    		{-1,-1,-1,-1,2,-1,2},
    		{-1,4,2,-1,-1,2,-1},
    	};
    	
	
    
    	imprimir_matriz(costos);
    }
 
}
