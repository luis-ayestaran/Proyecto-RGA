package buap.tec_ia.proyecto.daos;

public class GenRegulador {
	
	private int idRg;
	private int valor;
	private OperadoresGeneticos operadores;
	
	public GenRegulador( int valor, OperadoresGeneticos operadores ) {
		
		this.setValor(valor);
		this.setOperadores(operadores);
		
	}
	
	
	public int getId_rg() {
		return idRg;
	}
	public void setIdRg(int idRg) {
		this.idRg = idRg;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public OperadoresGeneticos getOperadores() {
		return operadores;
	}
	public void setOperadores(OperadoresGeneticos operadores) {
		this.operadores = operadores;
	}

}
