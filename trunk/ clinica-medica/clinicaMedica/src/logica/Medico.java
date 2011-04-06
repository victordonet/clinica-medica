package logica;

import persistencia.dao.IDaoConsultas;
import persistencia.dao.IDaoDisponibilidad;

public class Medico extends Usuario {

	private String nombre,apellido,ci,tel;
	private Especialidad esp;
	private IDaoDisponibilidad disp;
	private IDaoConsultas daoConsultas;
	
	public Medico(String id, String contrasena, String tipo, String estado,
			String nombre, String apellido, String ci, String tel,
			Especialidad esp, IDaoDisponibilidad disp, IDaoConsultas daoConsultas) {
		super(id, contrasena, tipo, estado);
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.tel = tel;
		this.esp = esp;
		this.disp = disp;
		this.daoConsultas = daoConsultas;
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

	public Especialidad getEsp() {
		return esp;
	}

	public void setEsp(Especialidad esp) {
		this.esp = esp;
	}

	public IDaoDisponibilidad getDisp() {
		return disp;
	}

	public void setDisp(IDaoDisponibilidad disp) {
		this.disp = disp;
	}

	public IDaoConsultas getDaoConsultas() {
		return daoConsultas;
	}

	public void setDaoConsultas(IDaoConsultas daoConsultas) {
		this.daoConsultas = daoConsultas;
	}

	public vector listarDisp(){
		return disp.listar(id);
	}
	
	
}
