package persistencia.mains;

import java.util.Calendar;
import java.util.Vector;
import vista.dataobjet.DataConsulta;
import vista.dataobjet.DataReservaTurno;
import vista.dataobjet.VoTurnosDisp;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoConsultas {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {

		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Administrativos:
		//Alta
//		String idMed = "1234";
//		String idAfil = "1001";
//		Calendar fecha = Calendar.getInstance();
//		fecha.set(2010, 02, 20);
//		DataReservaTurno dataResTurno = new DataReservaTurno(fecha, 4, 12, idAfil, 3, idMed, 1);
//		fachada.altaConsulta(dataResTurno);
//
//		//Alta prox mes
//		DataConsulta cons = new DataConsulta(fecha, idMed, idAfil, 4, 3, 2, 12, false);
		fachada.altaConsultaProxMes();
		
		//Listar Consultas Disp
//		Vector<VoTurnosDisp> vDisp = fachada.listarConsultasDisp(idMed);
//		for (int i = 0; i < vDisp.size(); i++) {
//			VoTurnosDisp con = (VoTurnosDisp) vDisp.get(i);
//			System.out.println("Listado Cons.Disponibles, fecha = "+con.getFecha());
//		}
//		
//		//Cantidad Consultas
//		Calendar fDesde = Calendar.getInstance();
//		fDesde.set(2010, 02, 01);
//		Calendar fHasta = Calendar.getInstance();
//		fHasta.set(2010, 03, 01);
//		int cant = fachada.getCantidadConsultas(fDesde, fHasta, idMed);
//		System.out.println("Cantidad de consultas = "+cant);
//		
//		//Eliminar
//		fachada.elimConsultasAfil("1001");		
	}
}
