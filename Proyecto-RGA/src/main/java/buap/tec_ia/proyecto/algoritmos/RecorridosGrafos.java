package buap.tec_ia.proyecto.algoritmos;

import buap.tec_ia.proyecto.estructuras.Grafo;

public class RecorridosGrafos {
	
	private Grafo grafo;
	
	public Grafo getGrafo() {
		return grafo;
	}
	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}

	public RecorridosGrafos( int vertices ) {
		
		grafo = new Grafo( vertices );
		
	}
	
	public int[] calcularCostoAristas( int[] recorrido ) {
		
		int[] costoAristas = new int[ recorrido.length - 1 ];
		for( int i = 0; i < recorrido.length - 1; i++ ) {
			
			int[][] costos = grafo.getCostos();
			costoAristas[ i ] = costos[ recorrido[i] ][ recorrido[i + 1] ];
			
		}
		return costoAristas;
		
	}

}
