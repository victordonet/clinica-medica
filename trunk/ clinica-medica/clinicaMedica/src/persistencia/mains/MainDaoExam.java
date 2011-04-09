package persistencia.mains;

import java.util.Calendar;

import vista.dataobjet.DataExamen;
import vista.dataobjet.DataTipoExamen;
import logica.Examen;
import logica.TipoExamen;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoExam {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Administrativos:
		//Registrar
		Calendar fechaI = Calendar.getInstance();
		fechaI.set(2010, 02, 20);
		Calendar fechaR = Calendar.getInstance();
		fechaR.set(2010, 02, 26);
		
		String idAfil = "1001";
		DataTipoExamen tex = new DataTipoExamen(1, "Ecografia");
		DataExamen ex = new DataExamen(fechaI, fechaR, true, true, tex);
		fachada.regEx(ex, idAfil);

		//Cant Ex. pagos
		int cantP = fachada.getCantExPagos(fechaI, fechaR);
		System.out.println("Cantidad Ex pagados = "+cantP);

		//Cant Ex.
		int cantE = fachada.getCantExam(fechaI);
		System.out.println("Cantidad Ex = "+cantE);

	}
}
