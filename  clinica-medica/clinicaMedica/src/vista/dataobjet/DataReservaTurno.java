package vista.dataobjet;

import java.io.Serializable;
import java.util.Calendar;

public class DataReservaTurno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Calendar fecha;
	private int dia, horario, idConsultorio, turno;
	private String idAfil, idMedico;
	
	public DataReservaTurno(Calendar fecha, int dia, int horario, String idAfil,
			int idConsultorio, String idMedico, int turno) {
		super();
		this.fecha = fecha;
		this.dia = dia;
		this.horario = horario;
		this.idAfil = idAfil;
		this.idConsultorio = idConsultorio;
		this.idMedico = idMedico;
		this.turno = turno;
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

	public String getIdAfil() {
		return idAfil;
	}

	public void setIdAfil(String idAfil) {
		this.idAfil = idAfil;
	}

	public int getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
}
