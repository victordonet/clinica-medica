package persistencia.mains;

import java.util.Calendar;
import java.util.Vector;

import vista.dataobjet.DataAfiliado;
import vista.dataobjet.VosLogin;
import logica.Afiliado;
import logica.Examen;
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
		DataAfiliado afil = new DataAfiliado("1001", "1001", "Pedro", "Jimenez", "pjimenez@hotmail.com", "Soca 1234", "27083223", "A",fecha, true);
		fachada.altaAfiliado(afil);
		

		
		//Listar
		Vector<DataAfiliado> listAfiliados = fachada.listarAfiliados();
		for (int i = 0; i < listAfiliados.size(); i++) {
			DataAfiliado af = listAfiliados.get(i);
			System.out.println("Listado afiliados, Nombre = "+af.getNombre());
		}
	
		//Modificacion
		fachada.modifAfil(afil.getId(), "PedroModif", "ApellidoMod", afil.getCi(), "pj@gmail.com", afil.getDireccion(), "26199911", afil.getFechaIngreso(), false);
		
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

		//Borrar
		fachada.bajaAfil(afil.getId());
		System.out.println("Estado afiliado eliminado= "+afil.getEstado());
		
		}
}
