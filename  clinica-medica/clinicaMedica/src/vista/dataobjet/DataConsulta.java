package vista.dataobjet;

import java.io.Serializable;
import java.util.Calendar;

public class DataConsulta implements Serializable {
	
	private Calendar fecha;
	private int idMed, dia, IdConsultorio, turno, horario;
	private String idAfil;
	private boolean pagoConsulta;
	
	public DataConsulta(Calendar fecha, int idMed, String idAfil, int dia,
						int idConsultorio, int turno, int horario, boolean pagoConsulta) {
		super();
		this.fecha = fecha;
		this.idMed = idMed;
		this.idAfil = idAfil;
		this.dia = dia;
		IdConsultorio = idConsultorio;
		this.turno = turno;
		this.horario = horario;
		this.pagoConsulta = pagoConsulta;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public int getIdMed() {
		return idMed;
	}

	public void setIdMed(int idMed) {
		this.idMed = idMed;
	}

	public String getIdAfil() {
		return idAfil;
	}

	public void setIdAfil(String idAfil) {
		this.idAfil = idAfil;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getIdConsultorio() {
		return IdConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		IdConsultorio = idConsultorio;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public boolean isPagoConsulta() {
		return pagoConsulta;
	}

	public void setPagoConsulta(boolean pagoConsulta) {
		this.pagoConsulta = pagoConsulta;
	}
	
	

}
