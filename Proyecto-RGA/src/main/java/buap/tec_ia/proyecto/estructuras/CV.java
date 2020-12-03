package buap.tec_ia.proyecto.estructuras;

import java.util.ArrayList;
import java.util.List;

import buap.tec_ia.proyecto.daos.Co;
import buap.tec_ia.proyecto.daos.SG;

public class CV {
	
	private List<Co> conexiones;

	public List<Co> getConexiones() {
		return conexiones;
	}
	public void setConexiones(List<Co> conexiones) {
		this.conexiones = conexiones;
	}
	
	public CV() {
		
		conexiones = new ArrayList<Co>();
		
	}

}
