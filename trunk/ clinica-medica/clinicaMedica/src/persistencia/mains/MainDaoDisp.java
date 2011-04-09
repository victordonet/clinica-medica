package persistencia.mains;

import java.util.Vector;
import vista.dataobjet.VoDispo;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoDisp {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Disponibilidad:
		//Modificacion
		String idMed = "1234";
		VoDispo vo = new VoDispo(04, 12, idMed);
		fachada.updateDisponibilidad(vo);
		VoDispo vo1 = new VoDispo(2, 10, idMed);
		fachada.updateDisponibilidad(vo1);
		VoDispo vo2 = new VoDispo(6, 18, idMed);
		fachada.updateDisponibilidad(vo2);
		System.out.println("Carga de Disponibilidad del medico = "+vo.getIdMed());
		
		//Listar Disp. Medico
		Vector<VoDispo> vDsipMed = fachada.listarDispMed(idMed);
		for (int i = 0; i < vDsipMed.size(); i++) {
			VoDispo disp = vDsipMed.get(i);
			System.out.println("Listado disp. Medico:"+disp.getIdMed()+", Nombre = "+disp.getHorario());
		}
	}
}
