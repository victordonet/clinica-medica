package persistencia.mains;

import java.util.Calendar;
import java.util.Vector;

import persistencia.transacciones.Transaccion;
import excepciones.PersistenciaException;
import vista.dataobjet.VosLogin;
import logica.AdminGen;
import logica.Afiliado;
import logica.Consulta;
import logica.Examen;
import logica.Medico;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoConsultas {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		/*
		public int getCantidadConsultas(Transaccion trn, Calendar fDesde, Calendar fHasta) throws PersistenciaException;
		public void altaconsultaProxMes(Transaccion trn, Consulta cons) throws PersistenciaException;
		public Vector listarConsultasDisp(Transaccion trn) throws PersistenciaException;
		public void altaConsulta(Transaccion trn, Calendar fecha, String horario, int dia, Afiliado afil, int turno, Medico med) throws PersistenciaException;
		*/
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Administrativos:
		//Alta
		Calendar fecha = Calendar.getInstance();
		fecha.set(2010, 02, 20);
		//fachada.altaConsulta(fecha, 12, 27, afil, 6, med);

		AdminGen adm2 = new AdminGen("RPerez", "13", "AD", "A", "Ruso", "Perez");
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
