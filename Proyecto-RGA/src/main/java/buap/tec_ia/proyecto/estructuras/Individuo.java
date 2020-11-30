package buap.tec_ia.proyecto.estructuras;

import buap.tec_ia.proyecto.daos.Conexion;
import buap.tec_ia.proyecto.daos.GenEstructural;
import buap.tec_ia.proyecto.daos.GenRegulador;
import buap.tec_ia.proyecto.utils.NumerosAleatorios;

public class Individuo {
	
	public static final int PROPORCION_REG_EST = 4;

	private float aptitud;
	
	private int[] recorrido;
	
	private VectorRegulador rv;
	private VectorEstructural sv;
	private VectorConexiones cv;
	
	
	// -------------------------- GETTERS Y SETTERS ----------------------------//
	
	public float getAptitud() {
		return aptitud;
	}
	public void setAptitud(float aptitud) {
		this.aptitud = aptitud;
	}
	public int[] getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(int[] recorrido) {
		this.recorrido = recorrido;
	}
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
	
	
	// ------------------------------- CONSTRUCTORES ---------------------------------//
	
	public Individuo() { 
		
		this.creaVectores();
		
	}
	
	public Individuo( int[] recorrido ) {
		
		this.creaVectores();
		this.setRecorrido(recorrido);
		this.inicializarVectorEstructural();
		this.inicializarVectorRegulador();
		this.inicializarVectorConexiones();
		
	}
	
	public Individuo( VectorRegulador rv, VectorEstructural sv, VectorConexiones cv ) {
		
		this.setRv(rv);
		this.setSv(sv);
		this.setCv(cv);
		
	}
	
	
	// ------------------------ INICIALIZADORES -------------------------------//
	
	private void creaVectores() {
		
		rv = new VectorRegulador();
		sv = new VectorEstructural();
		cv = new VectorConexiones();
		
	}
	
	public void inicializarVectorEstructural() {
		
		for( int i = 0; i < recorrido.length; i++ ) {
			
			this.sv.getGenesEstructurales().add( new GenEstructural( recorrido[i] ) );
			
		}
		
	}
	
	public void inicializarVectorRegulador() {
		
		int longitud = (int) Math.ceil( (double) recorrido.length / Individuo.PROPORCION_REG_EST );
		
		for( int i = 0; i < longitud; i++ ) {
			
			this.rv.getGenesReguladores().add( new GenRegulador( NumerosAleatorios.generaNumeroAleatorio(0, 2) ) );
			
		}
		
	}
	
	public void inicializarVectorConexiones() {
		
		for( int i = 0; i < recorrido.length; i++ ) {
			
			this.cv.getConexiones().add( 
				new Conexion( 
					NumerosAleatorios.generaNumeroAleatorio(0, rv.getGenesReguladores().size()),
					i
				) 
			);
			
		}
		
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append( "individuo@" + this.hashCode() + "{\n");
		sb.append( "\tSV [ " );
		for( GenEstructural sg : sv.getGenesEstructurales() ) {
			sb.append( sg.getValor() );
			sb.append( ", " );
		}
		sb.append( "]\n" );
		sb.append( "\tRV [ " );
		for( GenRegulador rg : rv.getGenesReguladores() ) {
			sb.append( rg.getValor() );
			sb.append( ", " );
		}
		sb.append( "]\n" );
		sb.append( "\tCV [ " );
		for( Conexion co : cv.getConexiones() ) {
			sb.append( "[" );
			sb.append( "rg: " + co.getIdRg() );
			sb.append( ", " );
			sb.append( "sg: " + co.getIdSg() );
			sb.append( "],   " );
		}
		sb.append( "]\n}\n" );
		return sb.toString();
		
	}
	
}
