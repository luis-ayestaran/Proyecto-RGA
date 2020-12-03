package buap.tec_ia.proyecto.estructuras;

import buap.tec_ia.proyecto.daos.Co;
import buap.tec_ia.proyecto.daos.SG;
import buap.tec_ia.proyecto.daos.RG;
import buap.tec_ia.proyecto.utils.Aleatorio;

public class Sujeto {
	
	public static final int PROPORCION_REG_EST = 4;
	
	private int idIndividuo;
	private int idGeneracion;
	private float aptitud;
	
	private int[] recorrido;
	
	private RV rv;
	private SV sv;
	private CV cv;
	
	
	// -------------------------- GETTERS Y SETTERS ----------------------------//
	
	public int getIdIndividuo() {
		return idIndividuo;
	}
	public void setIdIndividuo(int idIndividuo) {
		this.idIndividuo = idIndividuo;
	}
	public int getIdGeneracion() {
		return idGeneracion;
	}
	public void setIdGeneracion(int idGeneracion) {
		this.idGeneracion = idGeneracion;
	}
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
	public RV getRv() {
		return rv;
	}
	public void setRv(RV rv) {
		this.rv = rv;
	}
	public SV getSv() {
		return sv;
	}
	public void setSv(SV sv) {
		this.sv = sv;
	}
	public CV getCv() {
		return cv;
	}
	public void setCv(CV cv) {
		this.cv = cv;
	}
	
	
	// ------------------------------- CONSTRUCTORES ---------------------------------//
	
	public Sujeto() { 
		
		//this.creaVectores();
		
	}
	
	public Sujeto( int idIndividuo, int idGeneracion, int vertices ) {
		
		this.setIdIndividuo(idIndividuo);
		this.setIdGeneracion(idGeneracion);
		this.creaVectores();
		this.inicializarRecorrido(vertices);
		this.inicializarVectorEstructural();
		this.inicializarVectorRegulador();
		this.inicializarVectorConexiones();
		
	}
	
	public Sujeto( RV rv, SV sv, CV cv ) {
		
		this.setRv(rv);
		this.setSv(sv);
		this.setCv(cv);
		
	}
	
	
	// ------------------------ INICIALIZADORES -------------------------------//
	
	private void creaVectores() {
		
		aptitud = 0;
		rv = new RV();
		sv = new SV();
		cv = new CV();
		
	}
	
	private void inicializarRecorrido( int vertices ) {
		
		recorrido = Aleatorio.generaRecorrido( vertices );
		
	}
	
	public void inicializarVectorEstructural() {
		
		for( int i = 0; i < recorrido.length; i++ ) {
			
			this.sv.getGenesEstructurales().add( new SG( recorrido[i] ) );
			
		}
		
	}
	
	public void inicializarVectorRegulador() {
		
		int longitud = (int) Math.ceil( (double) recorrido.length / Sujeto.PROPORCION_REG_EST );
		
		for( int i = 0; i < longitud; i++ ) {
			
			if( Aleatorio.generaNumeroAleatorio(0, 10) < 2 ) {
				this.rv.getGenesReguladores().add( new RG( 0 ) );
			} else {
				this.rv.getGenesReguladores().add( new RG( 1 ) );
			}
			
		}
		
	}
	
	public void inicializarVectorConexiones() {
		
		for( int i = 0; i < recorrido.length; i++ ) {
			
			this.cv.getConexiones().add( 
				new Co( 
					Aleatorio.generaNumeroAleatorio(0, rv.getGenesReguladores().size()),
					i
				) 
			);
			
		}
		
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append( "\n[ GENERACION " + this.getIdIndividuo() + " ]\n");
		sb.append( "RV ( " );
		for( RG rg : rv.getGenesReguladores() ) {
			sb.append( rg.getValor() );
			sb.append( ", " );
		}
		sb.append( ")\n" );
		sb.append( "CV [ " );
		for( Co co : cv.getConexiones() ) {
			sb.append( "[" );
			sb.append( "R: " + co.getIdRg() );
			sb.append( ", " );
			sb.append( "S: " + co.getIdSg() );
			sb.append( "],   " );
		}
		sb.append( ")\n" );
		sb.append( "SV  (" );
		for( SG sg : sv.getGenesEstructurales() ) {
			sb.append( sg.getValor() );
			sb.append( ", " );
		}
		sb.append( ")\n" );
		//sb.append( "Generacion: " + this.getIdGeneracion() + "\n");
		sb.append( "Aptitud: " + (this.getAptitud() * 100) + "%\n");
		return sb.toString();
		
	}
	
}
