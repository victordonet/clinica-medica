package logica;

import java.io.Serializable;
import java.util.Calendar;

public class Consulta implements Serializable{

	private static final long serialVersionUID = 1L;
	private Calendar fecha;
	private int dia,horario,turno,idConsultorio;
	private Afiliado afil;
	private boolean pagoConsulta;
	public Consulta(Calendar fecha, int dia, int horario, int turno,
			int idConsultorio, Afiliado afil, boolean pagoConsulta) {
		super();
		this.fecha = fecha;
		this.dia = dia;
		this.horario = horario;
		this.turno = turno;
		this.idConsultorio = idConsultorio;
		this.afil = afil;
		this.pagoConsulta = pagoConsulta;
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
	public Afiliado getAfil() {
		return afil;
	}
	public void setAfil(Afiliado afil) {
		this.afil = afil;
	}
	public boolean isPagoConsulta() {
		return pagoConsulta;
	}
	public void setPagoConsulta(boolean pagoConsulta) {
		this.pagoConsulta = pagoConsulta;
	}
}
