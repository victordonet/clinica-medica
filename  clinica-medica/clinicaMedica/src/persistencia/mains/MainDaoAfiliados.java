package persistencia.mains;

import java.util.Calendar;
import java.util.Vector;

import vista.dataobjet.VosLogin;

import logica.AdminGen;
import logica.Afiliado;
import logica.Examen;
import logica.Usuario;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoAfiliados {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Afiliados:
		//Alta
		Calendar fecha = Calendar.getInstance();
		fecha.set(2009, 11, 31);
		Afiliado afil = new Afiliado("1001", "1001", "A", "A", "Pedro", "Jimenez", "12354726", "pjimenez@hotmail.com", "Soca 1234", "27083223", fecha, true, null);
		fachada.altaAfiliado(afil);

		fecha.set(2009, 8, 12);
		Afiliado afil2 = new Afiliado("1002", "1002", "A", "A", "Juan", "Guzman", "31364280", "jg@hotmail.com", "Orinoco 1234", "26191245", fecha, false, null);
		fachada.altaAfiliado(afil2);

		//Listar
		Vector<Afiliado> listAfiliados = fachada.listarAfiliados();
		for (int i = 0; i < listAfiliados.size(); i++) {
			Afiliado af = listAfiliados.get(i);
			System.out.println("Listado afiliados, Nombre = "+af.getNombre());
		}
		
		//Borrar
		fachada.bajaAfil(afil2.getId());
		System.out.println("Estado afiliado eliminado= "+afil2.getEstado());
		
		//Modificacion
		fachada.modifAfil(afil.getId(), "PedroModif", "ApellidoMod", afil.getCi(), "pj@gmail.com", afil.getDir(), "26199911", afil.getFecha(), false);
		
		//Obtener
		Afiliado af = fachada.getAfiliado(afil.getId());
		System.out.println("Nombre afiliado buscado = "+af.getNombre());
		
		//Validar
		boolean afilOk = fachada.validarAfil(afil.getId());
		System.out.println("Afiliado valido? = "+afilOk);

		//Obtener VO
		VosLogin vo = fachada.getDataAfiliado(afil.getId());
		//System.out.println("Nombre afiliado buscado = "+vo.getNombre());
		
		//listar Ex. Pend
		Vector exPend = fachada.listarExPend(afil.getId());
		for (int i = 0; i < exPend.size(); i++) {
			Examen ex = (Examen) exPend.get(i);
			System.out.println("Listado examenes, FechaIni. = "+ex.getFechaInicio());
		}
	}
}
