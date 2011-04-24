package logica;

import java.io.Serializable;
import java.util.Calendar;

import persistencia.dao.IDaoExamen;

public class Afiliado extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre,apellido,ci,mail,dir,tel;
	private Calendar fecha;
	private boolean fonasa;
	private IDaoExamen daoExamen;
	public Afiliado (){
		
	}
	public Afiliado(String id, String contrasena, String tipo, String estado,
			String nombre, String apellido, String ci, String mail, String dir,
			String tel, Calendar fecha, boolean fonasa, IDaoExamen daoExamen) {
		super(id, contrasena, tipo, estado);
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.mail = mail;
		this.dir = dir;
		this.tel = tel;
		this.fecha = fecha;
		this.fonasa = fonasa;
		this.daoExamen = daoExamen;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public boolean isFonasa() {
		return fonasa;
	}
	public void setFonasa(boolean fonasa) {
		this.fonasa = fonasa;
	}
	public IDaoExamen getDaoExamen() {
		return daoExamen;
	}
	public void setDaoExamen(IDaoExamen daoExamen) {
		this.daoExamen = daoExamen;
	}	
}
