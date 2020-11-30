package buap.tec_ia.proyecto.estructuras;

import java.util.ArrayList;
import java.util.List;

import buap.tec_ia.proyecto.daos.GenRegulador;

public class VectorRegulador {
	
	private List<GenRegulador> genesReguladores;

	public List<GenRegulador> getGenesReguladores() {
		return genesReguladores;
	}
	public void setGenesReguladores(List<GenRegulador> genesReguladores) {
		this.genesReguladores = genesReguladores;
	}
	
	public VectorRegulador() {
		
		genesReguladores = new ArrayList<GenRegulador>();
		
	}

}
