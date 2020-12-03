package buap.tec_ia.proyecto.daos;

public class Co {
	
	private int idRg;
	private int idSg;
	
	public int getIdRg() {
		return idRg;
	}
	public void setIdRg(int idRg) {
		this.idRg = idRg;
	}
	public int getIdSg() {
		return idSg;
	}
	public void setIdSg(int idSg) {
		this.idSg = idSg;
	}
	
	public Co() {  }
	
	public Co( int idRg, int idSg ) {
		
		this.setIdRg(idRg);
		this.setIdSg(idSg);
		
	}

}
