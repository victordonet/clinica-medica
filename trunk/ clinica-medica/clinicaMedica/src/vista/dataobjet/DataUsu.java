package vista.dataobjet;

import java.io.Serializable;

public class DataUsu implements Serializable{

	private String idUsu, tipo;

	public DataUsu(String idUsu, String tipo) {
		super();
		this.idUsu = idUsu;
		this.tipo = tipo;
	}

	public String getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(String idUsu) {
		this.idUsu = idUsu;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
