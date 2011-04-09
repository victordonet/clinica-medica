package persistencia.mains;

import vista.dataobjet.VoDispo;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoDisp {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Disponibilidad:
		//Modificacion
		VoDispo vo = new VoDispo();
		fachada.updateDisponibilidad(vo);
		System.out.println("Carga de Disponibilidad del medico = "+vo.getIdMed());
	}
}
