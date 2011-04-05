package persistencia.mains;

import java.util.Calendar;
import java.util.Vector;
import vista.dataobjet.DataMed;
import vista.dataobjet.VosLogin;
import logica.Consulta;
import logica.Disponibilidad;
import logica.Especialidad;
import logica.Medico;
import logica.Afiliado;
import logica.fachada.IfachadaLogica;
import logica.fachada.ProxyFachadaLogica;

public class MainDaoMedico {

	public static void main(String[] args) throws IllegalAccessException, Exception, Throwable {
		
		IfachadaLogica fachada = new ProxyFachadaLogica();
		
		//PRUEBO LOS METODOS
		//Medicos:
		//Alta
		Especialidad esp = new Especialidad(1, "Odontologo", 150);
		Disponibilidad disp = new Disponibilidad(3, 12);
		Medico med = new Medico("1234", "1234", "M", "A", "Carlos", "Prociutto", "17863574", "29001496", esp, disp, null);
		fachada.altaMedico(med);

		Medico med2 = new Medico("4567", "4567", "M", "A", "Jose", "Castro", "19358516", "24863278", esp, disp, null);
		fachada.altaMedico(med2);

		//Listar
		Vector<Medico> listMed = fachada.listarMedicos();
		for (int i = 0; i < listMed.size(); i++) {
			Medico me = listMed.get(i);
			System.out.println("Listado medicos, Nombre = "+me.getNombre());
		}
		
		//Borrar
		fachada.bajarMedico(med2.getId());
		System.out.println("Estado medico eliminado= "+med2.getEstado());
		
		//Modificacion
		esp.setMontoBase(170);
		fachada.modifMedico("1234", "Jose Maria", med.getApellido(), med.getCi(), "24860101", esp);
		
		//Listar Mededico Esp.
		Vector<Medico> vMedEsp = fachada.listarMedEsp(med.getEsp().getIdEspecialidad());
		for (int i = 0; i < vMedEsp.size(); i++) {
			Medico medic = vMedEsp.get(i);
			System.out.println("Listado Medicos x esp."+med.getEsp().getIdEspecialidad()+", Nombre = "+medic.getNombre());
		}
		
		//Validar
		boolean medOk = fachada.validarMed(med.getId());
		System.out.println("Medico valido? = "+medOk);

		//Obtener Medico
		med = fachada.getMedico("12341");
		System.out.println("Medico #"+med.getId());
		
		//Obtener VO
		VosLogin vo = fachada.getDataMedico(med.getId());
		//System.out.println("Nombre medico buscado = "+vo.getNombre());
		
		//Listar Salario
		Calendar fDesde = Calendar.getInstance();
		fDesde.set(2010, 02, 01);
		Calendar fHasta = Calendar.getInstance();
		fHasta.set(2010, 03, 01);
		Vector vSal = fachada.listarSalarios(fDesde, fHasta);
		
		//Listar Med. Premiado
		Vector<Medico> vMedPre = fachada.listarMedPremiado(fDesde, fHasta);
		for (int i = 0; i < vMedPre.size(); i++) {
			Medico medic = vMedPre.get(i);
			System.out.println("Listado Medicos premiados, Nombre = "+medic.getNombre());
		}
		
		//Calc. Salario Total
		Vector vSalTot = fachada.calcSalarioTotal(fDesde, fHasta);
		for (int i = 0; i < vMedPre.size(); i++) {
			Medico medic = vMedPre.get(i);
			System.out.println("Listado Medicos premiados, Nombre = "+medic.getNombre());
		}
		
		//Listar Disponibilidad
		DataMed voM = new DataMed(med.getId(), med.getNombre(), med.getApellido(), med.getCi(), med.getTel(), med.getEsp().getIdEspecialidad());
		Vector vDisp = fachada.listarDispMed(voM);
		for (int i = 0; i < vDisp.size(); i++) {
			Disponibilidad dispo = (Disponibilidad) vDisp.get(i);
			System.out.println("Lista dispo, dia = "+dispo.getDia()+", horario = "+dispo.getHorario());
		}
		
		//Carga Consultas prox mes
		Calendar fecha = Calendar.getInstance();
		fDesde.set(2010, 02, 01);
		fachada.cargaConsultasProxMes(med.getId(), fecha);
		
		//listar Consultas Disp.
		Vector vCons = fachada.listarConsultasDisp();
		for (int i = 0; i < vCons.size(); i++) {
			Consulta cons = (Consulta) vCons.get(i);
			System.out.println("Listado consultas disp = "+cons.getDia());
		}
		
		//Alta Consulta
		Afiliado af = fachada.getAfiliado("1001");
		fachada.altaConsulta(fecha, med.getId(), 3, af, 1);
	}
}
