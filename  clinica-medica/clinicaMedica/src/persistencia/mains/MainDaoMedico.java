package persistencia.mains;

import java.util.Calendar;
import java.util.Vector;

import logica.fachada.IfachadaLogica;
import vista.acceso.ProxyFachadaLogica;
import vista.dataobjet.DataCantConsu;
import vista.dataobjet.DataDisp;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataMed;
import vista.dataobjet.DataReservaTurno;
import vista.dataobjet.DataSalario;
import vista.dataobjet.DataUsuario;
import vista.dataobjet.VoMedEsp;
import vista.dataobjet.VoResumCont;
import vista.dataobjet.VoTurnosDisp;
import vista.dataobjet.VosLogin;

public class MainDaoMedico {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Medicos:
		//Alta
		DataMed med = new DataMed("1234", "Carlos", "Prociutto", "17863574", "29001496", "A", 1);
		fachada.altaMedico(med);
		//Usuarios:
		//Alta
		DataUsuario usuMed = new DataUsuario(med.getId(),"1234","ME","A");
		fachada.altaUsuario(usuMed);

		DataMed med2 = new DataMed("4567", "Jose", "Castro", "19358516", "24863278", "A", 1);
		fachada.altaMedico(med2);
		//Usuarios:
		//Alta
		DataUsuario usuMed2 = new DataUsuario(med2.getId(),"1234","ME","A");
		fachada.altaUsuario(usuMed2);

		//Listar
		Vector<DataMed> listMed = fachada.listarMedicos("A");
		for (int i = 0; i < listMed.size(); i++) {
			DataMed me = listMed.get(i);
			System.out.println("Listado medicos, Nombre = "+me.getNombre());
		}
		
		//Borrar
		fachada.bajarMedico(med2.getId());
		System.out.println("Estado medico eliminado= "+med2.getEstado());
		
		//Modificacion
		DataEsp esp = new DataEsp(4, "Traumatologia", 140);
		fachada.modifMedico("1234", "Jose Maria", med.getApellido(), med.getCi(), "24860101", esp, "I");
		
		//Listar Mededico Esp.
		Vector<VoMedEsp> vMedEsp = fachada.listarMedEsp(med.getEsp());
		for (int i = 0; i < vMedEsp.size(); i++) {
			VoMedEsp medic = vMedEsp.get(i);
			System.out.println("Listado Medicos x esp."+med.getEsp()+", Nombre = "+medic.getNombre());
		}
		
		//Validar
		boolean medOk = fachada.validarMed(med.getId());
		System.out.println("Medico valido? = "+medOk);

		//Obtener Medico
		//Medico medico = fachada.getMedico("12341");
		//System.out.println("Medico #"+medico.getId());
		
		//Obtener VO
		VosLogin vo = fachada.getDataMedico(med.getId());
		System.out.println("Nombre medico buscado = "+vo.getNombre());
		
		//Listar Salario
		Calendar fDesde = Calendar.getInstance();
		fDesde.set(2010, 02, 01);
		Calendar fHasta = Calendar.getInstance();
		fHasta.set(2010, 03, 01);
		Vector<DataSalario> vSal = fachada.listarSalarios(fDesde, fHasta);
		for (int i = 0; i < vSal.size(); i++) {
			DataSalario sal = vSal.get(i);
			System.out.println("Listando salario del Medico: "+sal.getNombre()+" Salario= "+sal.getSalarioMed());
		}
		
		//Listar Med. Premiado
		Vector<DataCantConsu> vMedPre = fachada.listarMedPremiado(fDesde, fHasta);
		for (int i = 0; i < vMedPre.size(); i++) {
			DataCantConsu medic = vMedPre.get(i);
			System.out.println("Listado Medicos premiados, Nombre = "+medic.getNombre());
		}
		
		//Calc. Salario Total
		VoResumCont vSalTot = fachada.calcSalarioTotal(fDesde, fHasta);
			System.out.println("Listado salario total = "+vSalTot.getValor());
		
		//Listar Disponibilidad
		Vector<DataDisp> vDisp = fachada.listarDispMed(med.getId());
		for (int i = 0; i < vDisp.size(); i++) {
			DataDisp dispo = vDisp.get(i);
			System.out.println("Lista dispo, dia = "+dispo.getDia()+", horario = "+dispo.getHorario());
		}
		
		//Carga Consultas prox mes
		Calendar fecha = Calendar.getInstance();
		fDesde.set(2010, 02, 01);
		fachada.cargaConsultasProxMes(med.getId());
		
		//listar Consultas Disp.
		Vector<VoTurnosDisp> vCons = fachada.listarConsultasDisp(med.getId());
		for (int i = 0; i < vCons.size(); i++) {
			VoTurnosDisp cons = vCons.get(i);
			System.out.println("Listado consultas disp = "+cons.getDia());
		}
		
		//Alta Consulta
		DataReservaTurno dataResTurno = new DataReservaTurno(fecha, 3, 10, "1001", 3, med.getId(), 2);
		fachada.altaConsulta(dataResTurno);
	}
}
