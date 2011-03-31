package vista.dataobjet;

import java.io.Serializable;

public class DataEsp implements Serializable{
 
	private int codigo;
	private String descripcion;
	private double montoBase;

	public DataEsp(int codigo, String descripcion,double montoBase) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.montoBase = montoBase;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
