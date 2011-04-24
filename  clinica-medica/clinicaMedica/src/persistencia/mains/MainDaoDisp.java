package persistencia.mains;

import java.util.Vector;

import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;
import vista.dataobjet.DataDisp;

public class MainDaoDisp {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Disponibilidad:
		//Modificacion
		String idMed = "1234";
		DataDisp vo = new DataDisp(04, 12, idMed);
//		fachada.modificarDisponibilidad(vo, null);
//		DataDisp vo1 = new DataDisp(2, 10, idMed);
//		fachada.modificarDisponibilidad(vo1, null);
//		DataDisp vo2 = new DataDisp(6, 18, idMed);
//		fachada.modificarDisponibilidad(vo2, null);
		System.out.println("Carga de Disponibilidad del medico = "+vo.getIdMed());
		
		//Eliminacion
		DataDisp vo3 = new DataDisp(6, 18, idMed);
		fachada.eliminarDisponibilidad(idMed);
		System.out.println("Elimino Disponibilidad del medico = "+vo.getIdMed()+" para el dia = "+vo.getDia());
		
		//Listar Disp. Medico
		Vector<DataDisp> vDsipMed = fachada.listarDispMed(idMed);
		for (int i = 0; i < vDsipMed.size(); i++) {
			DataDisp disp = vDsipMed.get(i);
			System.out.println("Listado disp. Medico:"+disp.getIdMed()+", Nombre = "+disp.getHorario());
		}
	}
}
