package vista.dataobjet;

import java.util.Calendar;

public class DataConsAfi {

	private Calendar fecha;
	private String nomMed, apeMed;
	
	public DataConsAfi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataConsAfi(Calendar fecha, String nomMed, String apeMed) {
		super();
		this.fecha = fecha;
		this.nomMed = nomMed;
		this.apeMed = apeMed;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getNomMed() {
		return nomMed;
	}

	public void setNomMed(String nomMed) {
		this.nomMed = nomMed;
	}

	public String getApeMed() {
		return apeMed;
	}

	public void setApeMed(String apeMed) {
		this.apeMed = apeMed;
	}
	
	
}
