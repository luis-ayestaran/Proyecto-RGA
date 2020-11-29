package buap.tec_ia.proyecto.daos;

public class OperadoresGeneticos {
	
	private boolean mutacion;
	private boolean cruzamiento;
	
	public OperadoresGeneticos(boolean mutacion, boolean cruzamiento) {
		
		this.setMutacion(mutacion);
		this.setCruzamiento(cruzamiento);
		
	}
	
	public boolean isMutacion() {
		return mutacion;
	}
	public void setMutacion(boolean mutacion) {
		this.mutacion = mutacion;
	}
	public boolean isCruzamiento() {
		return cruzamiento;
	}
	public void setCruzamiento(boolean cruzamiento) {
		this.cruzamiento = cruzamiento;
	}

}
