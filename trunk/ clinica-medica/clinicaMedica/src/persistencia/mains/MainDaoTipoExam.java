package persistencia.mains;

import java.util.Vector;

import logica.fachada.IfachadaLogica;
import vista.acceso.ProxyFachadaLogica;
import vista.dataobjet.DataTipoExamen;

public class MainDaoTipoExam {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Tipo Examenes:
		//Agregar
		DataTipoExamen tex = new DataTipoExamen(2, "Tomografia");
		fachada.agregar(tex);

		//Listar
		Vector<DataTipoExamen> vEx = fachada.listarTipoEx();
		for (int i = 0; i < vEx.size(); i++) {
			DataTipoExamen ex = vEx.get(i);
			System.out.println("Listado Examenes, Nombre = "+ex.getNombre());
		}
	}
}
