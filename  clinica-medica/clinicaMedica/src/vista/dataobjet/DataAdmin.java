package vista.dataobjet;

public class DataAdmin {
	
	private String id,nombre,cargo;

	public DataAdmin(String id, String nombre, String cargo) {
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}	
}
