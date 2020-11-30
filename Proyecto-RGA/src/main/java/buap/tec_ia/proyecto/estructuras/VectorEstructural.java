package buap.tec_ia.proyecto.estructuras;

import java.util.ArrayList;
import java.util.List;

import buap.tec_ia.proyecto.daos.GenEstructural;

public class VectorEstructural {
	
	private List<GenEstructural> genesEstructurales;

	public List<GenEstructural> getGenesEstructurales() {
		return genesEstructurales;
	}
	public void setGenesEstructurales(List<GenEstructural> genesEstructurales) {
		this.genesEstructurales = genesEstructurales;
	}
	
	public VectorEstructural() {
		
		genesEstructurales = new ArrayList<GenEstructural>();
		
	}

}
