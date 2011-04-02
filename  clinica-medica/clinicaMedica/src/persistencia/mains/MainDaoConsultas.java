package persistencia.mains;

import java.util.Calendar;
import java.util.Vector;
import logica.Afiliado;
import logica.Consulta;
import logica.Medico;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoConsultas {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {

		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Administrativos:
		//Alta
		Calendar fecha = Calendar.getInstance();
		fecha.set(2010, 02, 20);
		Afiliado af = fachada.getAfiliado("1001");
		Medico med = fachada.getMedico("12341");
		fachada.altaConsulta(fecha, "12", 27, af, 6, med);

		//Alta prox mes
		Consulta cons = new Consulta(fecha, 27, 12, 0, 1, null, false);
		fachada.altaConsultaProxMes(cons);
		
		//Listar Consultas Disp
		Vector vDisp = fachada.listarConsultasDisp();
		for (int i = 0; i < vDisp.size(); i++) {
			Consulta con = (Consulta) vDisp.get(i);
			System.out.println("Listado Cons.Disponibles, fecha = "+con.getFecha());
		}
		
		//Cantidad Consultas
		Calendar fDesde = Calendar.getInstance();
		fDesde.set(2010, 02, 01);
		Calendar fHasta = Calendar.getInstance();
		fHasta.set(2010, 03, 01);
		int cant = fachada.getCantidadConsultas(fDesde, fHasta);
		
		//Eliminar
		fachada.elimConsultasAfil("1001");		
	}
}
