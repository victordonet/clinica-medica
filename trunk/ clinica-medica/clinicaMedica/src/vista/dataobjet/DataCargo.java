package vista.dataobjet;

public class DataCargo {
	
	private int idCargo;
	private String descripcion;
	
	public DataCargo(int idCargo, String descripcion) {
		super();
		this.idCargo = idCargo;
		this.descripcion = descripcion;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
