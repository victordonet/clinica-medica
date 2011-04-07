package vista.dataobjet;

import java.io.Serializable;
import java.util.Calendar;

public class VoTurnosDisp implements Serializable {

	private Calendar fecha;
	private int dia,horario,turno,idConsultorio;
	
	public VoTurnosDisp(Calendar fecha, int dia, int horario, int turno,
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
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getHorario() {
		return horario;
	}
	public void setHorario(int horario) {
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