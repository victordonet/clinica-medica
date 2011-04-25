package logica.fachada;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Vector;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.Medico;
import logica.observer.IObserver;
import vista.dataobjet.DataAdmin;
import vista.dataobjet.DataAfiliado;
import vista.dataobjet.DataCantConsu;
import vista.dataobjet.DataCargo;
import vista.dataobjet.DataConsAfi;
import vista.dataobjet.DataConsFecha;
import vista.dataobjet.DataConsulta;
import vista.dataobjet.DataConsultas;
import vista.dataobjet.DataConsultorio;
import vista.dataobjet.DataDisp;
import vista.dataobjet.DataEsp;
import vista.dataobjet.DataExamen;
import vista.dataobjet.DataMed;
import vista.dataobjet.DataReservaTurno;
import vista.dataobjet.DataSalario;
import vista.dataobjet.DataTipoExamen;
import vista.dataobjet.DataUsuario;
import vista.dataobjet.VoMedEsp;
import vista.dataobjet.VoResumCont;
import vista.dataobjet.VoTurnosDisp;
import vista.dataobjet.VosLogin;
import excepciones.LogicaException;
import excepciones.PersistenciaException;

public class ProxyFachadaLogicaWeb extends HttpServlet implements IfachadaLogica {

	private static final long serialVersionUID = 1L;
	private IfachadaLogica fachada;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProxyFachadaLogicaWeb() {}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		ServletContext sc = config.getServletContext();
		String ruta = config.getInitParameter("SERVER-RMI");

		 try {
			fachada = (IfachadaLogica) Naming.lookup(ruta+"logica");
			sc.setAttribute("modeloProxy", fachada);
		} catch (MalformedURLException e) {
			new LogicaException("Publicación del servidor incorrecta");
			e.printStackTrace();
		} catch (NotBoundException e) {
			new LogicaException("Error Bound Exception");
			e.printStackTrace();
		}catch (RemoteException e) {
			new LogicaException("Error Remote Exception");
			e.printStackTrace();
		}
	}

	//SERVLET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
    
	//GENERALES
	public void addObsMenuGA(IObserver obs) throws RemoteException {
		fachada.addObsMenuGA(obs);
	}
	public void remObsMenuGA(IObserver obs) throws RemoteException {
		fachada.remObsMenuGA(obs);
	}
	public void notificarMenuGA() throws RemoteException {
		fachada.notificarMenuGA();
	}
	public void addObsReservaTurno(IObserver obs) throws RemoteException {
		fachada.addObsReservaTurno(obs);
	}
	public void remObsRservaTurno(IObserver obs) throws RemoteException {
		fachada.remObsRservaTurno(obs);
	}
	public void notificarReservaTurno() throws RemoteException {
		fachada.notificarReservaTurno();
	}
	public void addObsDispMed(IObserver obs) throws RemoteException {
		fachada.addObsDispMed(obs);
	}
	public void remObsDispMed(IObserver obs) throws RemoteException {
		fachada.remObsDispMed(obs);
	}
	public void notificarDispMed() throws RemoteException {
		fachada.notificarDispMed();
	}
	//AFILIADOS
	public void altaAfiliado(DataAfiliado afil) throws PersistenciaException, RemoteException {
		fachada.altaAfiliado(afil);
	}
	public void modifAfil(String idAfil, String nom, String apel, String ci, String mail, String dir, String tel, boolean fon, String estado) throws PersistenciaException, RemoteException {
		fachada.modifAfil(idAfil, nom, apel, ci, mail, dir, tel, fon, estado);
	}
	public void bajaAfil(String id) throws PersistenciaException, RemoteException {
		fachada.bajaAfil(id);
	}
	public Vector<DataAfiliado> listarAfiliados() throws PersistenciaException, RemoteException {
		return fachada.listarAfiliados();
	}
	public VosLogin getDataAfiliado(String id) throws PersistenciaException, RemoteException {
		return fachada.getDataAfiliado(id);
	}
	public boolean validarAfil(String idAfil) throws PersistenciaException, RemoteException {
		return fachada.validarAfil(idAfil);
	}
	public Vector<DataExamen> listarExPend(String idAfil) throws PersistenciaException, RemoteException {
		return fachada.listarExPend(idAfil);
	}
	public DataAfiliado getAfiliado(String idAfil) throws PersistenciaException, RemoteException {
		return fachada.getAfiliado(idAfil);
	}
	public boolean cobraTimbre(String idAfil) throws PersistenciaException, RemoteException {
		return fachada.cobraTimbre(idAfil);
	}
	public boolean cobraTicket(String idAfil) throws PersistenciaException, RemoteException {
		return fachada.cobraTicket(idAfil);
	}
	
	//ADMIN-GERENTE
	public void altaAdmin(DataAdmin adm) throws PersistenciaException, RemoteException {
		fachada.altaAdmin(adm);
	}
	public void modificarAdmin(String id, String nom, String cargo, String estado) throws PersistenciaException, RemoteException {
		fachada.modificarAdmin(id, nom, cargo, estado);
	}
	public void bajaAdmin(String id) throws PersistenciaException, RemoteException {
		fachada.bajaAdmin(id);
	}
	public Vector<DataAdmin> listarAdmin() throws PersistenciaException, RemoteException {
		return fachada.listarAdmin();
	}
	public VosLogin getDataAdmin(String id) throws PersistenciaException, RemoteException {
		return fachada.getDataAdmin(id);
	}
	public boolean validarAdmin(String id) throws PersistenciaException, RemoteException {
		return fachada.validarAdmin(id);
	}
	public void modifEx(String idAfil,Calendar fIni,int idTex,Calendar fRes) throws PersistenciaException, RemoteException {
		fachada.modifEx(idAfil, fIni, idTex, fRes);
	}
	public Vector<VoResumCont> listarResContable(Calendar fDesde, Calendar fHasta) throws PersistenciaException, RemoteException {
		return fachada.listarResContable(fDesde, fHasta);
	}
	public Vector<DataCargo> listarCargos() throws PersistenciaException, RemoteException {
		return fachada.listarCargos();
	}
	public DataAdmin getAdmin(String id) throws PersistenciaException, RemoteException {
		return fachada.getAdmin(id);
	}
	
	//CONSULTAS
	public int getCantidadConsultas(Calendar fDesde, Calendar fHasta, String idMed) throws PersistenciaException, RemoteException {
		return fachada.getCantidadConsultas(fDesde, fHasta, idMed);
	}
	public void altaConsultaProxMes() throws PersistenciaException, RemoteException {
		fachada.altaConsultaProxMes();
	}
	public Vector<VoTurnosDisp> listarConsultasDisp(String idMed) throws PersistenciaException, RemoteException {
		return fachada.listarConsultasDisp(idMed);
	}
	public void elimConsultasAfil(String idAfil) throws PersistenciaException, RemoteException {	
		fachada.elimConsultasAfil(idAfil);
	}
	public void altaConsulta(DataReservaTurno dataResTurno)  throws PersistenciaException, RemoteException {
		fachada.altaConsulta(dataResTurno);
	}
	public Vector<DataConsultas> listarConsultas() throws PersistenciaException, RemoteException {
		return fachada.listarConsultas();
	}
	
	//DISPONIBILIDAD
	public void modificarDisponibilidad(boolean[][] dataDsip, String idMed) throws PersistenciaException, RemoteException {
		fachada.modificarDisponibilidad(dataDsip, idMed);
	}
	public void eliminarDisponibilidad(String idMed) throws PersistenciaException, RemoteException {
		fachada.eliminarDisponibilidad(idMed);
	}
	public int[][] obetnerDispoDiaHora() throws PersistenciaException, RemoteException{
		return fachada.obetnerDispoDiaHora();
	}
	public boolean[][] obtenerDispoDiaHoraMedico(String idMedico)throws PersistenciaException, RemoteException {
		return fachada.obtenerDispoDiaHoraMedico(idMedico);
	}
	//ESPECIALIDADES
	public void altaEspecialidad(DataEsp datEsp) throws RemoteException, PersistenciaException {
			fachada.altaEspecialidad(datEsp);
	}
	public Vector<DataEsp> listarEspecialidades() throws PersistenciaException, RemoteException {
		return fachada.listarEspecialidades();
	}
	public DataEsp obtenerEspecialidad(int idEsp) throws PersistenciaException, RemoteException {
		return fachada.obtenerEspecialidad(idEsp);
	}
	public void bajaEspecialidad(int idEsp) throws RemoteException, PersistenciaException {
		fachada.bajaEspecialidad(idEsp);
	}
	
	//EXAMENES
	public void regEx(DataExamen ex, String idAfil) throws PersistenciaException, RemoteException {
		fachada.regEx(ex, idAfil);
	}
	public int getCantExPagos(Calendar fini,Calendar ffin) throws PersistenciaException, RemoteException {
		return fachada.getCantExPagos(fini, ffin);
	}
	public int getCantExam(String idAfil) throws PersistenciaException, RemoteException {
		return fachada.getCantExam(idAfil);
	}
	
	//MEDICOS
	public void altaMedico(DataMed med)  throws PersistenciaException, RemoteException {
		fachada.altaMedico(med);
	}
 	public void modifMedico(String id, String nom, String apell, String ci, String tel, DataEsp esp, String estado)  throws PersistenciaException, RemoteException {
 		fachada.modifMedico(id, nom, apell, ci, tel, esp, estado);
 	}
 	public void bajarMedico(String id)  throws PersistenciaException, RemoteException {
 		fachada.bajarMedico(id);
 	}
 	public Vector<DataMed> listarMedicos()  throws PersistenciaException, RemoteException {
 		return fachada.listarMedicos();
 	}
 	public Vector<VoMedEsp> listarMedEsp(int idEsp)  throws PersistenciaException, RemoteException {
 		return fachada.listarMedEsp(idEsp);
 	}
 	public Medico getMedico(String id)  throws PersistenciaException, RemoteException {
 		return fachada.getMedico(id);
 	}
 	public VosLogin getDataMedico(String id)  throws PersistenciaException, RemoteException {
 		return fachada.getDataMedico(id);
 	}
 	public boolean validarMed(String id)  throws PersistenciaException, RemoteException {
 		return fachada.validarMed(id);
 	}
 	public Vector<DataSalario> listarSalarios(Calendar fDesde, Calendar fHasta)  throws PersistenciaException, RemoteException {
 		return fachada.listarSalarios(fDesde, fHasta);
 	}
 	public Vector<DataCantConsu> listarMedPremiado(Calendar fDesde, Calendar fHasta)  throws PersistenciaException, RemoteException {
 		return fachada.listarMedPremiado(fDesde, fHasta);
 	}
 	public VoResumCont calcSalarioTotal(Calendar fDesde, Calendar fHasta)  throws PersistenciaException, RemoteException {
 		return fachada.calcSalarioTotal(fDesde, fHasta);
 	}
 	public Vector<DataDisp> listarDispMed(String idMed)  throws PersistenciaException, RemoteException {
 		return fachada.listarDispMed(idMed);
 	}
 	public void cargaConsultasProxMes(String id)  throws PersistenciaException, RemoteException {
 		fachada.cargaConsultasProxMes(id);
 	}
 	public DataMed getDataMed(String id)  throws PersistenciaException, RemoteException {
 		return fachada.getDataMed(id);
 	}
	
	public void modifConsultasMedFuturas(String idMed)
			throws PersistenciaException, RemoteException {
		fachada.modifConsultasMedFuturas(idMed);
			
	}
	
	//TIPO DE EXAMEN
	public void agregar(DataTipoExamen tex) throws PersistenciaException, RemoteException {
		fachada.agregar(tex);
	}
	public void modificar(DataTipoExamen tex) throws PersistenciaException, RemoteException {
		fachada.modificar(tex);
	}
	public Vector<DataTipoExamen> listarTipoEx() throws PersistenciaException, RemoteException {
		return fachada.listarTipoEx();
	}
	
	//TOTAL CONSULTAS
	public int getCantConsult(String idAfil) throws PersistenciaException, RemoteException {
		return fachada.getCantConsult(idAfil);
	}
	public int getCantConsultasPagas(Calendar fDesde,Calendar fHasta) throws PersistenciaException, RemoteException {
		return fachada.getCantConsultasPagas(fDesde, fHasta);
	}
	public Vector<DataConsAfi> listarConsultasAfi(String id) throws PersistenciaException, RemoteException {
		return fachada.listarConsultasAfi(id);
	}
	public Vector<DataConsFecha> listarConsFecha(Calendar fecha) throws PersistenciaException, RemoteException {
		return fachada.listarConsFecha(fecha);
	}
	public void elimConsulta(String idAfi)	throws PersistenciaException, RemoteException {
		fachada.elimConsulta(idAfi);
	}
	
	//USUARIOS
	public void altaUsuario(DataUsuario usu) throws PersistenciaException, RemoteException {
		fachada.altaUsuario(usu);
	}
	public boolean validarUsuario(String clave,String pass) throws PersistenciaException, RemoteException {
		return fachada.validarUsuario(clave, pass);
	}
	public void modifContrasena(String clave, String pass) throws PersistenciaException, RemoteException {
		fachada.modifContrasena(clave, pass);
	}
	public String getTipo(String idUsuario) throws PersistenciaException, RemoteException {
		return fachada.getTipo(idUsuario);
	}

	//CONSULTORIOS
	public boolean validarConsultorio(int id) throws PersistenciaException,RemoteException {
		return fachada.validarConsultorio(id);
	}
	public void altaConsultorio(DataConsultorio consultorio) throws PersistenciaException, RemoteException{
		fachada.altaConsultorio(consultorio);
	}
	public void bajaConsultorio(int idConsultorio) throws PersistenciaException, RemoteException {
		fachada.bajaConsultorio(idConsultorio);
	}
	public Vector<DataConsultorio> listarConsultorios() throws PersistenciaException, RemoteException {
		return fachada.listarConsultorios();
	}


}