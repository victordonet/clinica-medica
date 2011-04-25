package persistencia.mains;

import java.util.Calendar;

import logica.fachada.IfachadaLogica;
import vista.acceso.ProxyFachadaLogica;
import vista.dataobjet.DataExamen;
import vista.dataobjet.DataTipoExamen;

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
		int cantE = fachada.getCantExam(idAfil);
		System.out.println("Cantidad Ex = "+cantE);

	}
}
