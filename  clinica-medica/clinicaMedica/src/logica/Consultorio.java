package logica;

import java.io.Serializable;

public class Consultorio implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idConsultorio;
	private String nombre;
	
	public Consultorio(int idConsultorio, String nombre) {
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
