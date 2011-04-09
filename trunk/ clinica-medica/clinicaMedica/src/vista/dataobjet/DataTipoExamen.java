package vista.dataobjet;

import java.io.Serializable;

public class DataTipoExamen implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	
	public DataTipoExamen(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
