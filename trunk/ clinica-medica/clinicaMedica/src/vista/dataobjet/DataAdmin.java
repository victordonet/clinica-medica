package vista.dataobjet;

public class DataAdmin {
	
	private String id,nombre,estado;
	int cargo;

	public DataAdmin(String id, String nombre, int cargo2, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo2;
		this.estado = estado;
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

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
