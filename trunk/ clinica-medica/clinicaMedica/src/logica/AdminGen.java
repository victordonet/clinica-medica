package logica;

import java.io.Serializable;

public class AdminGen extends Usuario {

	private String nombre,cargo;

	public AdminGen(String id, String contrasena, String tipo, String estado,
		String nombre, String cargo) {
		super(id, contrasena, tipo, estado);
		this.nombre = nombre;
		this.cargo = cargo;
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
