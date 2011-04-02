package persistencia.mains;

import java.util.Calendar;
import java.util.Vector;
import logica.TotConsulta;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoTotConsulta {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Total Consulta:
		//Cantidad consultas
		int cant = fachada.getCantConsult("1001");
		System.out.println("Cantidad de consultas del Afi. 1001 = "+cant);

		//Cantidad consultas pagas
		Calendar fDesde = Calendar.getInstance();
		fDesde.set(2010, 02, 01);
		Calendar fHasta = Calendar.getInstance();
		fHasta.set(2010, 03, 01);
		int cant2 = fachada.getCantConsultasPagas(fDesde, fHasta);
		System.out.println("Cantidad de consultas pagas = "+cant2);

		//Listar Consultas x Afiliado
		Vector vCons = fachada.listarConsultasAfi("1001");
		for (int i = 0; i < vCons.size(); i++) {
			TotConsulta totCons = (TotConsulta) vCons.get(i);
			System.out.println("Listado consultas del afiliado 1001, nomMed = "+totCons.getNombreMed());
		}
		
		//Listar Consultas x Fecha
		Calendar fecha = Calendar.getInstance();
		fecha.set(2010, 02, 14);
		Vector vConsFecha = fachada.listarConsFecha(fecha);
		for (int i = 0; i < vConsFecha.size(); i++) {
			TotConsulta tc = (TotConsulta) vConsFecha.get(i);
			System.out.println("Listado consultas x dia, idAfil = "+tc.getIdAfiliado());
		}
		
		//Eliminar consutla
		fachada.elimConsulta("1001");
	}
}
