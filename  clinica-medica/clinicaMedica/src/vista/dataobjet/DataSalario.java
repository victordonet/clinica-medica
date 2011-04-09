package vista.dataobjet;

import java.io.Serializable;

public class DataSalario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id,nombre,apellido;
	private double salarioMed;
	
	public DataSalario(String id,String nombre, String apellido, double salarioMed) {
		this.setId(id);
		this.nombre = nombre;
		this.apellido = apellido;
		this.salarioMed = salarioMed;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
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

	public double getSalarioMed() {
		return salarioMed;
	}

	public void setSalarioMed(double salarioMed) {
		this.salarioMed = salarioMed;
	}
	
}