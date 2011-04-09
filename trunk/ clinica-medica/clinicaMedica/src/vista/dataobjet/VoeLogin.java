package vista.dataobjet;

import java.io.Serializable;

public class VoeLogin implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String pass;
	
	public VoeLogin(String usuario, String pass) {
		super();
		this.usuario = usuario;
		this.pass = pass;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
