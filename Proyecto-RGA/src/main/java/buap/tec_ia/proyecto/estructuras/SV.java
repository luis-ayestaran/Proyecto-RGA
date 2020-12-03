package buap.tec_ia.proyecto.estructuras;

import java.util.ArrayList;
import java.util.List;

import buap.tec_ia.proyecto.daos.SG;

public class SV {
	
	private List<SG> genesEstructurales;

	public List<SG> getGenesEstructurales() {
		return genesEstructurales;
	}
	public void setGenesEstructurales(List<SG> genesEstructurales) {
		this.genesEstructurales = genesEstructurales;
	}
	
	public SV() {
		
		genesEstructurales = new ArrayList<SG>();
		
	}

}
