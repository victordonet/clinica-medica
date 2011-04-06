package persistencia.mains;

import java.util.Calendar;
import java.util.Vector;
import vista.dataobjet.VosLogin;
import logica.AdminGen;
import logica.Examen;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoAdmin {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Administrativos:
		//Alta
		AdminGen adm = new AdminGen("FGonzales", "admin", "AD","A" , "Fernando",1);
		fachada.altaAdmin(adm);

		AdminGen adm2 = new AdminGen("RPerez", "13", "AD", "A", "Ruso", 1);
		fachada.altaAdmin(adm2);

		//Listar
		Vector<AdminGen> listAdmin = fachada.listarAdmin();
		for (int i = 0; i < listAdmin.size(); i++) {
			AdminGen ad = listAdmin.get(i);
			System.out.println("Listado admins, Nombre = "+ad.getNombre());
		}
		
		//Borrar
		fachada.bajaAdmin(adm2.getId());
		System.out.println("Estado admins eliminado= "+adm2.getEstado());
		
		//Modificacion
		fachada.modificarAdmin(adm.getId(), "Diego", "Gerente");
		
		//Validar
		boolean admOk = fachada.validarAdmin(adm.getId());
		System.out.println("Admin valido? = "+admOk);

		//Obtener VO
		VosLogin vo = fachada.getDataAdmin(adm.getId());
		//System.out.println("Nombre admiado buscado = "+vo.getNombre());
		
		//Modif. Examen
		Calendar fechaI = Calendar.getInstance();
		fechaI.set(2010, 02, 20);
		Calendar fechaR = Calendar.getInstance();
		fechaR.set(2010, 02, 26);
		fachada.modifEx("1001", fechaI, 1, fechaR);
		
		//listar Ex. Pend
		Vector exPend = fachada.listarExPend(adm.getId());
		for (int i = 0; i < exPend.size(); i++) {
			Examen ex = (Examen) exPend.get(i);
			System.out.println("Listado examenes, FechaIni. = "+ex.getFechaInicio());
		}
	}
}
