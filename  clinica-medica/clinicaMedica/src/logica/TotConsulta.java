package logica;

import java.util.Calendar;

public class TotConsulta {

	private String idMedico,nombreMed,apellMed,idAfiliado;
	private int dia,idConsultorio;
	private Calendar fecha;
	private boolean pagoConsulta;
	
	public TotConsulta(String idMedico, String nombreMed, String apellMed,
			String idAfiliado, int dia, int idConsultorio, Calendar fecha,
			boolean pagoConsulta) {
		super();
		this.idMedico = idMedico;
		this.nombreMed = nombreMed;
		this.apellMed = apellMed;
		this.idAfiliado = idAfiliado;
		this.dia = dia;
		this.idConsultorio = idConsultorio;
		this.fecha = fecha;
		this.pagoConsulta = pagoConsulta;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombreMed() {
		return nombreMed;
	}

	public void setNombreMed(String nombreMed) {
		this.nombreMed = nombreMed;
	}

	public String getApellMed() {
		return apellMed;
	}

	public void setApellMed(String apellMed) {
		this.apellMed = apellMed;
	}

	public String getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(String idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public boolean isPagoConsulta() {
		return pagoConsulta;
	}

	public void setPagoConsulta(boolean pagoConsulta) {
		this.pagoConsulta = pagoConsulta;
	}
}
