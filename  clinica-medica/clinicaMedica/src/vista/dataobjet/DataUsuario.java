package vista.dataobjet;

import java.io.Serializable;

public class DataUsuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id,contrasena,tipo,estado;

	public DataUsuario(String id, String contrasena, String tipo, String estado) {
		super();
		this.id = id;
		this.contrasena = contrasena;
		this.tipo = tipo;
		this.estado = estado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
