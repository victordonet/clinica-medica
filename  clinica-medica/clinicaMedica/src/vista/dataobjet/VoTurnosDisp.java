package vista.dataobjet;

import java.io.Serializable;
import java.util.Calendar;

public class VoTurnosDisp implements Serializable {

	private static final long serialVersionUID = 1L;
	private Calendar fecha;
	private String dia,horario;
	private int turno,idConsultorio;
	
	public VoTurnosDisp(Calendar fecha, String dia, String horario, int turno,
			int idConsultorio) {
		super();
		this.fecha = fecha;
		this.dia = dia;
		this.horario = horario;
		this.turno = turno;
		this.idConsultorio = idConsultorio;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	public int getIdConsultorio() {
		return idConsultorio;
	}
	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}
}