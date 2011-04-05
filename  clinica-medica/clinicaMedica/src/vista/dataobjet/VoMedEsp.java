package vista.dataobjet;

public class VoMedEsp {
	private String id,nombre,apellido;
	
	public VoMedEsp(String id,String nombre, String apellido) {
		this.setId(id);
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}