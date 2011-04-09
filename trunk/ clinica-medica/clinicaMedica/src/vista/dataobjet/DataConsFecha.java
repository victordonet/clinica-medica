package vista.dataobjet;

import java.io.Serializable;
import java.util.Calendar;

public class DataConsFecha implements Serializable {

	private static final long serialVersionUID = 1L;
	private Calendar fecha;
	private String nomMed, apeMed, nomAfi, apeAfil;
	private int idConsultorio, turno;
	public DataConsFecha() {
		super();
	}
	public DataConsFecha(Calendar fecha, String nomMed, String apeMed,
			String nomAfi, String apeAfil, int idConsultorio, int turno) {
		super();
		this.fecha = fecha;
		this.nomMed = nomMed;
		this.apeMed = apeMed;
		this.nomAfi = nomAfi;
		this.apeAfil = apeAfil;
		this.idConsultorio = idConsultorio;
		this.turno = turno;
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
	public String getNomAfi() {
		return nomAfi;
	}
	public void setNomAfi(String nomAfi) {
		this.nomAfi = nomAfi;
	}
	public String getApeAfil() {
		return apeAfil;
	}
	public void setApeAfil(String apeAfil) {
		this.apeAfil = apeAfil;
	}
	public int getIdConsultorio() {
		return idConsultorio;
	}
	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}

}
