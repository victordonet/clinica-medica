package persistencia.mains;

import java.util.Vector;
import logica.TipoExamen;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoTipoExam {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Tipo Examenes:
		//Agregar
		TipoExamen tex = new TipoExamen(2, "Tomografia");
		fachada.agregar(tex);

		//Modificacion ?????????????????
		tex = new TipoExamen(2, "Radiografia");
		fachada.modificar(tex);

		//Listar
		Vector<TipoExamen> vEx = fachada.listarTipoEx();
		for (int i = 0; i < vEx.size(); i++) {
			TipoExamen ex = vEx.get(i);
			System.out.println("Listado Examenes, Nombre = "+ex.getNombre());
		}

	}
}
