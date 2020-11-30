package buap.tec_ia.proyecto.estructuras;

import java.util.ArrayList;
import java.util.List;

import buap.tec_ia.proyecto.daos.Conexion;
import buap.tec_ia.proyecto.daos.GenEstructural;

public class VectorConexiones {
	
	private List<Conexion> conexiones;

	public List<Conexion> getConexiones() {
		return conexiones;
	}
	public void setConexiones(List<Conexion> conexiones) {
		this.conexiones = conexiones;
	}
	
	public VectorConexiones() {
		
		conexiones = new ArrayList<Conexion>();
		
	}

}
