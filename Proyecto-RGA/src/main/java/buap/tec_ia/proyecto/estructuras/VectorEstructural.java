package buap.tec_ia.proyecto.estructuras;

import java.util.List;

import buap.tec_ia.proyecto.daos.GenEstructural;

public class VectorEstructural {
	
	private float aptitud;
	
	private List<GenEstructural> genesEstructurales;
	
	
	
	public float getAptitud() {
		return aptitud;
	}

	public void setAptitud(float aptitud) {
		this.aptitud = aptitud;
	}

	public List<GenEstructural> getGenesEstructurales() {
		return genesEstructurales;
	}

	public void setGenesEstructurales(List<GenEstructural> genesEstructurales) {
		this.genesEstructurales = genesEstructurales;
	}

}
