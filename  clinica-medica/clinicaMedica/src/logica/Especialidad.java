package logica;

import java.io.Serializable;

public class Especialidad implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idEspecialidad;
	private String descripcion;
	private double montoBase;
	
	public Especialidad(int idEspecialidad, String descripcion, double montoBase) {
		super();
		this.idEspecialidad = idEspecialidad;
		this.descripcion = descripcion;
		this.montoBase = montoBase;
	}
	public int getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getMontoBase() {
		return montoBase;
	}
	public void setMontoBase(double montoBase) {
		this.montoBase = montoBase;
	}	
}
