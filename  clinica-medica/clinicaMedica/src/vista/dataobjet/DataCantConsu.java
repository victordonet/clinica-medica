package vista.dataobjet;

import java.io.Serializable;

public class DataCantConsu implements Serializable{
	private String id, nombre, apellido;
	private int cantConsultas;
	
	public DataCantConsu() {
		super();
	}
	public DataCantConsu(String id, String nombre, String apellido,
			int cantConsultas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cantConsultas = cantConsultas;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getCantConsultas() {
		return cantConsultas;
	}
	public void setCantConsultas(int cantConsultas) {
		this.cantConsultas = cantConsultas;
	}
}
