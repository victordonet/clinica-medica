package vista.dataobjet;

import java.io.Serializable;
import java.util.Calendar;

public class DataExamen implements Serializable{
	
	private Calendar fechaInicio,fechaResultado;
	private boolean enviaMail,cobroTimbre;
	private DataTipoExamen tex;
	
	public DataExamen(Calendar fechaInicio, Calendar fechaResultado,
			boolean enviaMail, boolean cobroTimbre, DataTipoExamen tex) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaResultado = fechaResultado;
		this.enviaMail = enviaMail;
		this.cobroTimbre = cobroTimbre;
		this.tex = tex;
	}
	public Calendar getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Calendar getFechaResultado() {
		return fechaResultado;
	}
	public void setFechaResultado(Calendar fechaResultado) {
		this.fechaResultado = fechaResultado;
	}
	public boolean isEnviaMail() {
		return enviaMail;
	}
	public void setEnviaMail(boolean enviaMail) {
		this.enviaMail = enviaMail;
	}
	public boolean isCobroTimbre() {
		return cobroTimbre;
	}
	public void setCobroTimbre(boolean cobroTimbre) {
		this.cobroTimbre = cobroTimbre;
	}
	public DataTipoExamen getTex() {
		return tex;
	}
	public void setTex(DataTipoExamen tex) {
		this.tex = tex;
	}
	
	
	
	

}
