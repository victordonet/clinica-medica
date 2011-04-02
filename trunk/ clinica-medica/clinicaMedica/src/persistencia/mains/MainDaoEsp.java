package persistencia.mains;

import java.util.Calendar;
import java.util.Vector;
import vista.dataobjet.DataEsp;
import vista.dataobjet.VosLogin;
import logica.Especialidad;
import logica.Afiliado;
import logica.Examen;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoEsp {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Administrativos:
		//Alta
		DataEsp datEsp = new DataEsp(2, "Traumatologia", 250);
		fachada.altaEspecialidad(datEsp);

		//Listar
		Vector<Especialidad> vEsp = fachada.listarEspecialidades();
		for (int i = 0; i < vEsp.size(); i++) {
			Especialidad es = vEsp.get(i);
			System.out.println("Listado Esp., Nombre = "+es.getDescripcion());
		}

		//Obtener
		Especialidad es = fachada.obtenerEspecialidad(2);
		System.out.println("Especialidad = "+es.getDescripcion());
	}
}
