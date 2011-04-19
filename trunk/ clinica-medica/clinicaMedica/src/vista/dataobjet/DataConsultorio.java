package vista.dataobjet;

import java.io.Serializable;

public class DataConsultorio implements Serializable {
	
	private int idConsultorio;
	private String nombre;
	
	public DataConsultorio(int idConsultorio, String nombre) {
		super();
		this.idConsultorio = idConsultorio;
		this.nombre = nombre;
	}
	public int getIdConsultorio() {
		return idConsultorio;
	}
	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
