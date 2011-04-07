package vista.dataobjet;

import java.io.Serializable;

public class DataMed implements Serializable {
	private String id,nombre,apellido,ci,tel, estado;
	private int esp;
	
	public DataMed(String id,String nombre, String apellido, String ci, String tel, int esp) {
		this.setId(id);
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.tel = tel;
		this.esp = esp;
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

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getEsp() {
		return esp;
	}

	public void setEsp(int esp) {
		this.esp = esp;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}
}