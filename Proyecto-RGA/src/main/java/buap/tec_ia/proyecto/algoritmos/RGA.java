package buap.tec_ia.proyecto.algoritmos;

import buap.tec_ia.proyecto.estructuras.Grafo;
import buap.tec_ia.proyecto.estructuras.VectorConexiones;
import buap.tec_ia.proyecto.estructuras.VectorEstructural;
import buap.tec_ia.proyecto.estructuras.VectorRegulador;
import buap.tec_ia.proyecto.utils.NumerosAleatorios;

public class RGA {
	
	private Grafo grafo;
	private VectorRegulador rv;
	private VectorEstructural sv;
	private VectorConexiones cv;
	
	public VectorRegulador getRv() {
		return rv;
	}
	public void setRv(VectorRegulador rv) {
		this.rv = rv;
	}
	public VectorEstructural getSv() {
		return sv;
	}
	public void setSv(VectorEstructural sv) {
		this.sv = sv;
	}
	public VectorConexiones getCv() {
		return cv;
	}
	public void setCv(VectorConexiones cv) {
		this.cv = cv;
	}
	
	public RGA() {
		
		inicializar();
		
	}
	
	public void inicializar() {
		
		//crearGrafo();
		crearPoblacionInicial(20);
		//evaluarPoblacionInicial()
		//while( !condicionParo() ) {
		//	Todo el proceso del algoritmo genetico
		//}
		
	}
	
	
	public void crearPoblacionInicial( int individuos ) {
		
		for(int i = 0; i < individuos; i++) {
		
			int[] numerosAleatorios = NumerosAleatorios.generaAleatoriosNoRepetidos( 10 );
			
			System.out.println("Individuo " + (i + 1) + ":");
			for( int numero : numerosAleatorios ) {
				System.out.print(numero + " ");
			}
			System.out.println("\n");
			
		}
		
	}
	
}
