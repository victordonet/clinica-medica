package vista.dataobjet;

import java.io.Serializable;

public class DataConsultas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int IdConsultorio;
	private String nomMed, horario;
	
	public DataConsultas(int idConsultorio, String nomMed, String horario) {
		super();
		IdConsultorio = idConsultorio;
		this.nomMed = nomMed;
		this.horario = horario;
	}
	
	public int getIdConsultorio() {
		return IdConsultorio;
	}
	public void setIdConsultorio(int idConsultorio) {
		IdConsultorio = idConsultorio;
	}
	public String getNomMed() {
		return nomMed;
	}
	public void setNomMed(String nomMed) {
		this.nomMed = nomMed;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
}
