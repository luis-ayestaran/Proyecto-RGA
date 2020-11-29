package buap.tec_ia.proyecto.daos;

public class GenEstructural {
	
	private int idSg;
	private int valor;
	private OperadoresGeneticos operadores;
	
	public GenEstructural( int valor, OperadoresGeneticos operadores ) {
		
		this.setValor(valor);
		this.setOperadores(operadores);
		
	}
	
	
	public int getIdSg() {
		return idSg;
	}
	public void setId_sg(int idSg) {
		this.idSg = idSg;
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
