package buap.tec_ia.proyecto.estructuras;

public class Individuo {

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
	
	public Individuo() { }
	
	public Individuo( VectorRegulador rv, VectorEstructural sv, VectorConexiones cv ) {
		
		this.setRv(rv);
		this.setSv(sv);
		this.setCv(cv);
		
	}
	
}
