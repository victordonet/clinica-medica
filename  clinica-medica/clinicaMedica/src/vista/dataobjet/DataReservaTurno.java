package vista.dataobjet;

import java.io.Serializable;
import java.util.Calendar;

public class DataReservaTurno implements Serializable{
	
	private Calendar fecha;
	private int dia, horario, idAfil, idConsultorio, idMedico;
	
	public DataReservaTurno(Calendar fecha, int dia, int horario, int idAfil,
			int idConsultorio, int idMedico) {
		super();
		this.fecha = fecha;
		this.dia = dia;
		this.horario = horario;
		this.idAfil = idAfil;
		this.idConsultorio = idConsultorio;
		this.idMedico = idMedico;
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

	public int getIdAfil() {
		return idAfil;
	}

	public void setIdAfil(int idAfil) {
		this.idAfil = idAfil;
	}

	public int getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	
	

}
