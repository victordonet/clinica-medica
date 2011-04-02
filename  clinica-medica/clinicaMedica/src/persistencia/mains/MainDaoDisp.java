package persistencia.mains;

import java.util.Calendar;
import java.util.Vector;
import vista.dataobjet.VoDispo;
import vista.dataobjet.VosLogin;
import logica.AdminGen;
import logica.Afiliado;
import logica.Examen;
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
		//System.out.println("Carga de Disponibilidad"+vo.get);
	}
}
