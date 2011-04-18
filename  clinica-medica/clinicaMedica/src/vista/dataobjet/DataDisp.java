package vista.dataobjet;

import java.io.Serializable;

public class DataDisp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int dia,horario;
	private String idMed;
	
	public DataDisp() {
		super();
	}

	
	public DataDisp(int dia, int horario, String idMed) {
		super();
		this.dia = dia;
		this.horario = horario;
		this.idMed = idMed;
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

	public void setIdMed(String idMed) {
		this.idMed = idMed;
	}

	public String getIdMed() {
		return idMed;
	}

}
