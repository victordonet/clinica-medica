package logica;

public class Disponibilidad {

	private int dia,horario;

	public Disponibilidad(int dia, int horario) {
		super();
		this.dia = dia;
		this.horario = horario;
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
}
