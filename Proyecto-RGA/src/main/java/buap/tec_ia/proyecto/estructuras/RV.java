package buap.tec_ia.proyecto.estructuras;

import java.util.ArrayList;
import java.util.List;

import buap.tec_ia.proyecto.daos.RG;

public class RV {
	
	private List<RG> genesReguladores;

	public List<RG> getGenesReguladores() {
		return genesReguladores;
	}
	public void setGenesReguladores(List<RG> genesReguladores) {
		this.genesReguladores = genesReguladores;
	}
	
	public RV() {
		
		genesReguladores = new ArrayList<RG>();
		
	}

}
