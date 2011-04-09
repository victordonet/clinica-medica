package vista.dataobjet;

import java.io.Serializable;

public class DataAdmin implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id,nombre,estado;
	int cargo;

	public DataAdmin(String id, String nombre, int cargo, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
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
