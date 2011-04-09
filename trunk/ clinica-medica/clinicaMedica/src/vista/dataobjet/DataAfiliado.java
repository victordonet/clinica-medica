package vista.dataobjet;

import java.io.Serializable;
import java.util.Calendar;

public class DataAfiliado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id, nombre, apellido, ci, mail, direccion, tel, estado;
	private Calendar fechaIngreso;
	private Boolean fonasa;
	
	public DataAfiliado(String id, String ci, String nombre, String apellido,
			String mail, String direccion, String tel, String estado,
			Calendar fechaIngreso, Boolean fonasa) {
		super();
		this.id = id;
		this.ci = ci;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.direccion = direccion;
		this.tel = tel;
		this.estado = estado;
		this.fechaIngreso = fechaIngreso;
		this.fonasa = fonasa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Boolean getFonasa() {
		return fonasa;
	}

	public void setFonasa(Boolean fonasa) {
		this.fonasa = fonasa;
	}
}
