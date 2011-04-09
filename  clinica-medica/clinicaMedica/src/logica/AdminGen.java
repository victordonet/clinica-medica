package logica;

public class AdminGen extends Usuario {

	private String nombre;
	int cargo;

	public AdminGen(String id, String contrasena, String tipo, String estado,
		String nombre, Integer cargo) {
		super(id, contrasena, tipo, estado);
		this.nombre = nombre;
		this.cargo = cargo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}	
}
