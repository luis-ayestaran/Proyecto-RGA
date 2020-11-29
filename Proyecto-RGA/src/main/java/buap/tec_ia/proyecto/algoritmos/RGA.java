package buap.tec_ia.proyecto.algoritmos;

import buap.tec_ia.proyecto.estructuras.VectorConexiones;
import buap.tec_ia.proyecto.estructuras.VectorEstructural;
import buap.tec_ia.proyecto.estructuras.VectorRegulador;

public class RGA {
	
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

}
